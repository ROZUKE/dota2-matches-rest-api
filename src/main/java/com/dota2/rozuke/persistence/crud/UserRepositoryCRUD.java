package com.dota2.rozuke.persistence.crud;

import com.dota2.rozuke.persistence.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepositoryCRUD extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);
}
