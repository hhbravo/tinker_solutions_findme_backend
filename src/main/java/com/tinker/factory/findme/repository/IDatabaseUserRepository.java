package com.tinker.factory.findme.repository;

import com.tinker.factory.findme.canonico.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IDatabaseUserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u left join fetch u.userRols r where u.email=:username")
    public Optional<User> findByUsername(@Param("username") String username);

    @Query("select u from User u left join fetch u.userRols r where u.userId=:userId")
    public Optional<User> findByUserId(@Param("userId") Integer userId);
}
