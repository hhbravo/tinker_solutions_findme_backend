package com.tinker.factory.findme.service.impl;

import com.tinker.factory.findme.canonico.User;
import com.tinker.factory.findme.repository.IDatabaseUserRepository;
import com.tinker.factory.findme.service.IDatabaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DatabaseUserService implements IDatabaseUserService {

    private IDatabaseUserRepository userRepository;


    @Autowired
    public DatabaseUserService(IDatabaseUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> getByUserId(Integer userId) {
        return this.userRepository.findByUserId(userId);
    }
}
