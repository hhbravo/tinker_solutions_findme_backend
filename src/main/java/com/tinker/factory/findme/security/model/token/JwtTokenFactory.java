package com.tinker.factory.findme.security.model.token;

import com.tinker.factory.findme.canonico.User;
import com.tinker.factory.findme.security.config.JwtSettings;
import com.tinker.factory.findme.security.model.UserContext;
import com.tinker.factory.findme.service.IUsuarioService;
import com.tinker.factory.findme.util.StringUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * Created by hans_h'bravo on 21/12/2016.
 */
@Component
public class JwtTokenFactory {
    private final JwtSettings settings;
    private final static String ADMINISTRADOR = "administrador";
    private final static String ADMINISTRADOR_USER = "Administrador";
    private final static String CUENTA_USER = "cuentaUsuario";
    private final static String USER = "usuario";
    private final static String ADMIN = "admin";

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    public JwtTokenFactory(JwtSettings settings) {
        this.settings = settings;
    }

    /**
     * Factory method for issuing new JWT Tokens.
     *
     * @param userContext
     * @return
     */
    public AccessJwtToken createAccessJwtToken(UserContext userContext) {
        if (userContext.getUserId() == null)
            throw new IllegalArgumentException("No se puede crear token JWT sin usuario");

        if (userContext.getAuthorities() == null || userContext.getAuthorities().isEmpty())
            throw new IllegalArgumentException("El User no tiene ning\u00fan privilegio");

        Claims claims = Jwts.claims().setSubject(String.valueOf(userContext.getUserId()));
        User userDto = usuarioService.loadUserByUser(userContext.getUserId());
        if (ADMIN.equals(userDto.getEmail())) {
            claims.put(CUENTA_USER, userDto.getAccount());
            claims.put(ADMINISTRADOR, ADMINISTRADOR_USER);
            claims.put(ADMIN, true);
            String token = generateToken(claims);
            return new AccessJwtToken(token, claims);
        }

        claims.put(CUENTA_USER, userDto.getAccount());
        claims.put(USER, generateNameUserToken(userDto));
        claims.put(ADMIN, false);
        String token = generateToken(claims);
        return new AccessJwtToken(token, claims);
    }

    private String generateToken(Claims claims) {
        DateTime currentTime = new DateTime();
        return Jwts.builder()
                .setClaims(claims)
                .setNotBefore(new Date())
                .setIssuer(settings.getTokenIssuer())
                .setIssuedAt(currentTime.toDate())
                .setExpiration(currentTime.plusMinutes(settings.getTokenExpirationTime()).toDate())
                .signWith(SignatureAlgorithm.HS512, settings.getTokenSigningKey())
                .compact();
    }

    private String generateNameUserToken(User user) {
        return StringUtil.toCamelCase(user.getName())
                .concat(" ")
                .concat(StringUtil.toCamelCase(user.getLastName()));
    }

    public JwtToken createRefreshToken(UserContext userContext) {
        if (userContext.getUserId() == null) {
            throw new IllegalArgumentException("No se puede crear token JWT sin usuario");
        }

        Claims claims = Jwts.claims().setSubject(String.valueOf(userContext.getUserId()));
        User userDto = usuarioService.loadUserByUser(userContext.getUserId());
        if (ADMIN.equals(userDto.getAccount())) {
            claims.put(CUENTA_USER, userDto.getAccount());
            claims.put(ADMINISTRADOR, ADMINISTRADOR_USER);
            String token = generateToken(claims);
            return new AccessJwtToken(token, claims);
        }

        claims.put(CUENTA_USER, userDto.getAccount());
        claims.put(USER, generateNameUserToken(userDto));


        String token = generateToken(claims);
        return new AccessJwtToken(token, claims);
    }
}
