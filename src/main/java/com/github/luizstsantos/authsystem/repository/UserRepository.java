package com.github.luizstsantos.authsystem.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.github.luizstsantos.authsystem.model.user;

public interface UserRepository extends CrudRepository<user, Long> {

    user findById(long id);

    @Query(value = "SELECT * FROM users WHERE email = :email AND password = :password", nativeQuery = true)
    public user login(String email, String password);
}
