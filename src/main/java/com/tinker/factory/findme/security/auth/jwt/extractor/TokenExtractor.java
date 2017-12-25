package com.tinker.factory.findme.security.auth.jwt.extractor;

/**
 * Created by hans_h'bravo on 21/12/2017.
 */
public interface TokenExtractor {
    String extract(String payload);
}
