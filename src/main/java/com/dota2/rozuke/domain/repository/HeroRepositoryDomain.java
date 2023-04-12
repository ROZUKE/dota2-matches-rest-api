package com.dota2.rozuke.domain.repository;

import com.dota2.rozuke.domain.dto.HeroDTO;
import com.dota2.rozuke.persistence.entity.Hero;

import java.util.List;
import java.util.Optional;

public interface HeroRepositoryDomain {

    List<HeroDTO> getAll();
    Optional<List<HeroDTO>> getByAttribute(String attribute);
    HeroDTO save(HeroDTO hero);
    void delete(String heroId);
    boolean searchById(String heroId);

}
