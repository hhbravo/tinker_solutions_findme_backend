package com.tinker.factory.findme.security.exceptions;

import org.springframework.security.authentication.AuthenticationServiceException;

/**
 * Created by hans_h'bravo on 21/12/2017.
 */
public class AuthMethodNotSupportedException extends AuthenticationServiceException {
    private static final long serialVersionUID = 3705043083010304496L;

    public AuthMethodNotSupportedException(String msg) {
        super(msg);
    }
}
