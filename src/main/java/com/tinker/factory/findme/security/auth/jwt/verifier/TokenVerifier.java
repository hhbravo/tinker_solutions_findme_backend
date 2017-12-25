package com.tinker.factory.findme.security.auth.jwt.verifier;

/**
 * Created by hans_h'bravo on 21/12/2017.
 */
public interface TokenVerifier {
    boolean verify(String jti);
}
