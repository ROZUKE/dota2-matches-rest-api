package com.dota2.rozuke.domain.service;

import com.dota2.rozuke.domain.dto.HeroDTO;
import com.dota2.rozuke.persistence.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    public List<HeroDTO> getAllHeroes(){
        return heroRepository.getAll();
    }

     public HeroDTO saveNewHero(HeroDTO hero) {
        return heroRepository.save(hero);
     }

     public String deleteHero(String heroId) {
        boolean existHero = searchHeroById(heroId);
        if (!existHero) return "Hero not exists";
        heroRepository.delete(heroId);
        return "Hero deleted";
     }

     private boolean searchHeroById(String heroId) {
        return heroRepository.searchById(heroId);
     }



     
}
