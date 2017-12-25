package com.tinker.factory.findme.service.impl;

import com.tinker.factory.findme.canonico.User;
import com.tinker.factory.findme.repository.impl.UsuarioRepository;
import com.tinker.factory.findme.service.IUsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private final Logger LOG = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Autowired
    private UsuarioRepository repository;

    @Override
    public User loadUserByUser(final Integer idUser) {
        return repository.loadUserByKey(idUser);
    }

    @Override
    public User loadUserByEmail(final String email) {
        return repository.loadUserByEmail(email);
    }

}
