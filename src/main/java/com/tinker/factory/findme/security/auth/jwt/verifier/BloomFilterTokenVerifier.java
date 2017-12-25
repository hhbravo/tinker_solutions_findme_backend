package com.tinker.factory.findme.security.auth.jwt.verifier;

import org.springframework.stereotype.Component;

/**
 * Created by hans_h'bravo on 21/12/2017.
 */
@Component
public class BloomFilterTokenVerifier implements TokenVerifier {
    @Override
    public boolean verify(String jti) {
        return true;
    }
}
