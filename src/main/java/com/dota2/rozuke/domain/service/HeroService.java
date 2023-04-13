package com.dota2.rozuke.domain.service;

import com.dota2.rozuke.domain.dto.HeroDTO;
import com.dota2.rozuke.persistence.entity.HeroStats;
import com.dota2.rozuke.persistence.enums.HeroAttribute;
import com.dota2.rozuke.persistence.enums.TypeAttack;
import com.dota2.rozuke.persistence.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

     public HeroDTO updateHero(String heroId, HeroDTO newHeroData) {

         HeroDTO hero = heroRepository.findById(heroId).orElseThrow(() -> new RuntimeException("Hero not found with ID: " + heroId));
         hero.setName((String) compareHeroData(hero.getName(), newHeroData.getName()));
         hero.setHeroStats((HeroStats) compareHeroData(hero.getHeroStats(), newHeroData.getHeroStats()));
         hero.setAttack((TypeAttack) compareHeroData(hero.getAttack(), newHeroData.getAttack()));
         hero.setAttribute((HeroAttribute) compareHeroData(hero.getAttribute(), newHeroData.getAttribute()));
         hero.setCharacteristic((String[]) compareHeroData(hero.getCharacteristic(), newHeroData.getCharacteristic()));
         hero.setMechanic((Integer) compareHeroData(hero.getMechanic(), newHeroData.getCharacteristic()));

          return saveNewHero(hero);

     }

     private Object compareHeroData(Object currentData, Object newHeroData) {
        return newHeroData != null ? newHeroData : currentData;
     }

     private boolean searchHeroById(String heroId) {
         return heroRepository.findById(heroId).isPresent();

     }



     
}
