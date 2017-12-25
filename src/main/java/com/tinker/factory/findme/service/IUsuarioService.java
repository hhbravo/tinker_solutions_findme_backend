package com.tinker.factory.findme.service;

import com.tinker.factory.findme.canonico.User;

public interface IUsuarioService {

    User loadUserByUser(Integer idUser);

    User loadUserByEmail(String email);



}
