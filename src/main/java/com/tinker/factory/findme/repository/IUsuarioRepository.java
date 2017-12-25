package com.tinker.factory.findme.repository;

import com.tinker.factory.findme.canonico.User;

public interface IUsuarioRepository {

    User loadUserByKey(Integer userId);

    User loadUserByEmail(String email);
}
