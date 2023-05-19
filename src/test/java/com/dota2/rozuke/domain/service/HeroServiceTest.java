package com.dota2.rozuke.domain.service;

import com.dota2.rozuke.ContainerConfig;
import com.dota2.rozuke.domain.dto.HeroDTO;
import com.dota2.rozuke.persistence.entity.Hero;
import com.dota2.rozuke.persistence.entity.HeroStats;
import com.dota2.rozuke.persistence.enums.HeroAttribute;
import com.dota2.rozuke.persistence.enums.TypeAttack;
import com.dota2.rozuke.persistence.repository.HeroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class HeroServiceTest extends ContainerConfig {

    @Autowired
    private HeroService heroService;

    private HeroDTO heroTest;

    @BeforeEach
    public void createHero() {
        heroTest = heroService.saveNewHero(new HeroDTO("Luna", HeroAttribute.AGILITY, 3, TypeAttack.DISTANCE, new String[]{ "1", "3"}, new HeroStats(20, 8, 12, 0.46)));
    }
    @Test
    void getAllHeroes_ExistsHeroes_ReturnListOfHeroes() {

        assertFalse(heroService.getAllHeroes().isEmpty());
        assertInstanceOf(HeroDTO.class, heroService.getAllHeroes().get(0));
    }

    @Test
    void saveNewHero_HeroData_ReturnHeroInstance() {
        assertInstanceOf(HeroDTO.class, heroTest);
    }

    @Test
    void deleteHero_HeroIDExists_Message() {
        assertEquals("Hero deleted", heroService.deleteHero(heroTest.getId()));

    }

    @Test
    void updateHero_UpdateData_ReturnInstanceHero() {
        HeroDTO newHeroData = new HeroDTO("Luna", HeroAttribute.INTELLIGENCE, 3, TypeAttack.DISTANCE, new String[]{ "1", "3"}, new HeroStats(20, 8, 12, 0.46));
        HeroDTO heroUpdated = heroService.updateHero(heroTest.getId(), newHeroData);
        assertEquals(HeroAttribute.INTELLIGENCE, heroUpdated.getAttribute());
        assertInstanceOf(HeroDTO.class, heroUpdated);
    }
}