package com.tinker.factory.findme.security.auth.jwt;

import com.tinker.factory.findme.canonico.User;
import com.tinker.factory.findme.security.auth.JwtAuthenticationToken;
import com.tinker.factory.findme.security.config.JwtSettings;
import com.tinker.factory.findme.security.model.UserContext;
import com.tinker.factory.findme.security.model.token.RawAccessJwtToken;
import com.tinker.factory.findme.service.IDatabaseUserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hans_h'bravo on 21/12/2017.
 */
@Component
@SuppressWarnings("unchecked")
public class JwtAuthenticationProvider implements AuthenticationProvider {
    private final JwtSettings jwtSettings;


    @Autowired
    private IDatabaseUserService databaseUserService;


    @Autowired
    public JwtAuthenticationProvider(JwtSettings jwtSettings) {
        this.jwtSettings = jwtSettings;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        RawAccessJwtToken rawAccessToken = (RawAccessJwtToken) authentication.getCredentials();

        Jws<Claims> jwsClaims = rawAccessToken.parseClaims(jwtSettings.getTokenSigningKey());
        Integer subject = Integer.valueOf(jwsClaims.getBody().getSubject());


        User user = databaseUserService.getByUserId(subject).orElseThrow(() -> new UsernameNotFoundException("User Id no encontrado: " + subject));

        List<GrantedAuthority> authorities = user.getUserRols().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getRol().authority()))
                .collect(Collectors.toList());

        UserContext context = UserContext.create(subject, authorities);

        return new JwtAuthenticationToken(context, context.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }
}