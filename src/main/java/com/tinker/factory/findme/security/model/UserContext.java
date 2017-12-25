package com.tinker.factory.findme.security.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * Created by hans_h'bravo on 21/12/2017.
 */
public class UserContext {
    private Integer userId;
    private final List<GrantedAuthority> authorities;

    private UserContext(Integer userId, List<GrantedAuthority> authorities) {
        this.userId = userId;

        this.authorities = authorities;
    }

    public static UserContext create(Integer userId,  List<GrantedAuthority> authorities) {
        if (userId == null) throw new IllegalArgumentException("User es requerido");
        return new UserContext(userId,  authorities);
    }



    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Integer getUserId() {
        return userId;
    }


}
