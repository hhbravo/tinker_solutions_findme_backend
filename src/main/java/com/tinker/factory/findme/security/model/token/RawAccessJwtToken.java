package com.tinker.factory.findme.security.model.token;

import com.tinker.factory.findme.security.exceptions.JwtExpiredTokenException;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;

/**
 * Created by hans_h'bravo on 21/12/2017.
 */
public class RawAccessJwtToken implements JwtToken {
    private static Logger logger = LoggerFactory.getLogger(RawAccessJwtToken.class);

    private String token;

    public RawAccessJwtToken(String token) {
        this.token = token;
    }

    /**
     * Parses and validates JWT Token signature.
     *
     * @throws BadCredentialsException
     * @throws com.tinker.factory.findme.security.exceptions.JwtExpiredTokenException
     *
     */
    public Jws<Claims> parseClaims(String signingKey) {
        try {
            return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(this.token);
        } catch (UnsupportedJwtException | MalformedJwtException | IllegalArgumentException | SignatureException ex) {
            logger.error("Invalido token JWT", ex);
            throw new BadCredentialsException("Invalido token JWT: ", ex);
        } catch (ExpiredJwtException expiredEx) {
            logger.info("JWT Token ha expirado", expiredEx);
            throw new JwtExpiredTokenException(this, "JWT Token ha expirado", expiredEx);
        }
    }

    @Override
    public String getToken() {
        return token;
    }
}