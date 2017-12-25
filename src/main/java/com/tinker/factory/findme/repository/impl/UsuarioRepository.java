package com.tinker.factory.findme.repository.impl;

import com.tinker.factory.findme.canonico.User;
import com.tinker.factory.findme.repository.IUsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UsuarioRepository implements IUsuarioRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioRepository.class);
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    UsuarioRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    private static final String SEARCH_USER = "select * from user where user_id = :idUsuario";
    private static final String SEARCH_USER_BY_MAIL = "select * from user where email = :email";


    @Transactional(readOnly = true)
    @Override
    public User loadUserByKey(Integer userId) {
        LOGGER.info("Buscando usuarios para la autenticacion ", userId);

        Map<String, Integer> queryParams = new HashMap<>();
        queryParams.put("idUsuario", userId);

        List<User> searchResults = jdbcTemplate.query(SEARCH_USER,
                queryParams,
                new BeanPropertyRowMapper<>(User.class)
        );

        LOGGER.info("Found usuario {}", searchResults);

        if (searchResults.size() > 0) {
            return searchResults.get(0);
        }

        return null;
    }

    @Override
    public User loadUserByEmail(String email) {
        LOGGER.info("Buscando usuarios para la autenticacion ", email);

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("email", email);

        List<User> searchResults = jdbcTemplate.query(SEARCH_USER_BY_MAIL,
                queryParams,
                new BeanPropertyRowMapper<>(User.class)
        );

        LOGGER.info("Found usuario {}", searchResults);

        if (searchResults.size() > 0) {
            return searchResults.get(0);
        }

        return null;
    }
}
