package com.tinker.factory.findme.security.exceptions;

import com.tinker.factory.findme.security.model.token.JwtToken;
import org.springframework.security.core.AuthenticationException;

/**
 * Created by hans_h'bravo on 21/12/2017.
 */
public class JwtExpiredTokenException extends AuthenticationException {
    private static final long serialVersionUID = -5959543783324224864L;

    private JwtToken token;

    public JwtExpiredTokenException(String msg) {
        super(msg);
    }

    public JwtExpiredTokenException(JwtToken token, String msg, Throwable t) {
        super(msg, t);
        this.token = token;
    }

    public String token() {
        return this.token.getToken();
    }
}
