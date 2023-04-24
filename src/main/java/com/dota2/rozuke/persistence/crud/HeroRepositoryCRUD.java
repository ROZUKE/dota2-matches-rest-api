package com.dota2.rozuke.persistence.crud;

import com.dota2.rozuke.persistence.entity.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface HeroRepositoryCRUD extends MongoRepository<Hero, String> {
    Optional<Hero> findByName(String s);


    @Query("db.hero.updateOne({ _id: ObjectId('?0')}, { $set: {'heroStats.winRate': ?1}})")
    Hero updateWinrate(String id, double winrate);


}
