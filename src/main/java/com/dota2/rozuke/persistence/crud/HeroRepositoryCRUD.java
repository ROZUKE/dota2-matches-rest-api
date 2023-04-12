package com.dota2.rozuke.persistence.crud;

import com.dota2.rozuke.persistence.entity.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface HeroRepositoryCRUD extends MongoRepository<Hero, String> {
    Optional<Hero> findByName(String s);

}
