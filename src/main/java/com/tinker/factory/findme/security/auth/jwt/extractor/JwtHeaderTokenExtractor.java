package com.tinker.factory.findme.security.auth.jwt.extractor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Component;

/**
 * Created by hans_h'bravo on 21/12/2017.
 */
@Component
public class JwtHeaderTokenExtractor implements TokenExtractor {
    public static String HEADER_PREFIX = "Bearer ";

    @Override
    public String extract(String header) {
        if (StringUtils.isBlank(header)) {
            throw new AuthenticationServiceException("Authorization header no puede estar vacio!");
        }

        if (header.length() < HEADER_PREFIX.length()) {
            throw new AuthenticationServiceException("Invalido tamano de authorization header.");
        }

        return header.substring(HEADER_PREFIX.length(), header.length());
    }
}
