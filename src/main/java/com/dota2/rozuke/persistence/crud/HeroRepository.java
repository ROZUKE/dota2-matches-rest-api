package com.dota2.rozuke.persistence.crud;

import com.dota2.rozuke.persistence.entity.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HeroRepository extends MongoRepository<Hero, String> {
}
