package com.dota2.rozuke.persistence.repository;

import com.dota2.rozuke.domain.dto.HeroDTO;
import com.dota2.rozuke.domain.repository.HeroRepositoryDomain;
import com.dota2.rozuke.persistence.crud.HeroRepositoryCRUD;
import com.dota2.rozuke.persistence.entity.Hero;
import com.dota2.rozuke.persistence.mapper.HeroMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HeroRepository implements HeroRepositoryDomain {

    @Autowired
    private HeroRepositoryCRUD heroRepositoryCRUD;

    @Autowired
    private HeroMapper mapper;

    @Override
    public List<HeroDTO> getAll() {
        return mapper.toHeroesDTO( heroRepositoryCRUD.findAll());
    }

    @Override
    public Optional<List<HeroDTO>> getByAttribute(String attribute) {
        return Optional.empty();
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
    public boolean searchById(String heroId) {
        return heroRepositoryCRUD.existsById(heroId);
    }

}
