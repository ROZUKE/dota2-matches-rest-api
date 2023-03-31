package com.dota2.rozuke.persistence.crud;

import com.dota2.rozuke.persistence.entity.Match;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatchRepository extends MongoRepository<Match, Integer> {
}
