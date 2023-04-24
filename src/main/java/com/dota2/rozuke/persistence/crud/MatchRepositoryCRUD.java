package com.dota2.rozuke.persistence.crud;

import com.dota2.rozuke.persistence.entity.Match;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MatchRepositoryCRUD extends MongoRepository<Match, Integer> {

    List<Match> findByHero(String heroId);
}
