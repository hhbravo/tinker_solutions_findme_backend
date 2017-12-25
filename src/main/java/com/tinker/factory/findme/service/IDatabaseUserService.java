package com.tinker.factory.findme.service;

import com.tinker.factory.findme.canonico.User;

import java.util.Optional;

public interface IDatabaseUserService {
    Optional<User> getByUsername(String username);

    Optional<User> getByUserId(Integer userId);
}