package com.dota2.rozuke.persistence.repository;

import com.dota2.rozuke.domain.dto.HeroDTO;
import com.dota2.rozuke.domain.repository.HeroRepositoryDomain;
import com.dota2.rozuke.persistence.crud.HeroRepositoryCRUD;
import com.dota2.rozuke.persistence.entity.Hero;
import com.dota2.rozuke.persistence.entity.HeroStats;
import com.dota2.rozuke.persistence.mapper.HeroMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HeroRepository implements HeroRepositoryDomain {

    @Autowired
    private HeroRepositoryCRUD heroRepositoryCRUD;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private HeroMapper mapper;

    public HeroRepository(){}

    @Override
    public List<HeroDTO> getAll() {

        return mapper.toHeroesDTO( heroRepositoryCRUD.findAll());
    }


    @Override
    public HeroDTO save(HeroDTO hero) {
        Hero newHero = mapper.toHero(hero);
        return mapper.toHeroDTO(heroRepositoryCRUD.save(newHero));

    }

    @Override
    public void delete(String heroId) {
        heroRepositoryCRUD.deleteById(heroId);
    }

    @Override
    public Optional<HeroDTO> findById(String heroId) {
        return heroRepositoryCRUD.findById(heroId).map(hero -> mapper.toHeroDTO(hero));

    }

    public HeroDTO updateHeroStats(String heroId, HeroStats heroStats) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(heroId));
        Update update = new Update().set("heroStats", heroStats);
        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(true);

        return mapper.toHeroDTO(mongoTemplate.findAndModify(query, update, options, Hero.class));
    }


}
