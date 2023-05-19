package com.dota2.rozuke.web.controller;

import com.dota2.rozuke.ContainerConfig;
import com.dota2.rozuke.domain.dto.HeroDTO;
import com.dota2.rozuke.domain.service.HeroService;
import com.dota2.rozuke.persistence.entity.HeroStats;
import com.dota2.rozuke.persistence.enums.HeroAttribute;
import com.dota2.rozuke.persistence.enums.TypeAttack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.*;

class HeroControllerTest extends ContainerConfig {

    @Autowired
    private HeroController heroController;

    @Autowired
    private HeroService heroService;
    private HeroDTO heroTest;

    @BeforeEach
    public void createHero() {
        heroTest = heroService.saveNewHero(new HeroDTO("Luna", HeroAttribute.AGILITY, 3, TypeAttack.DISTANCE, new String[]{ "1", "3"}, new HeroStats(20, 8, 12, 0.46)));
    }
    @Test
    void getAllHeroes_ExistsHeroes_ReturnStatusOk() {
        assertEquals(HttpStatus.OK, heroController.getAllHeroes().getStatusCode());
    }

    @Test
    void postNewHero_HeroData_ReturnStatusCreated() {
        HeroDTO newHeroData = new HeroDTO("Clinks", HeroAttribute.AGILITY, 3, TypeAttack.DISTANCE, new String[]{ "11", "33"}, new HeroStats(20, 8, 12, 0.46));
        assertEquals(HttpStatus.CREATED, heroController.postNewHero(newHeroData).getStatusCode());
    }

    @Test
    void putNewHeroData_UpdatedHeroData_ReturnStatusOk() {
        HeroDTO newHeroData = new HeroDTO("Luna", HeroAttribute.AGILITY, 3, TypeAttack.DISTANCE, new String[]{ "11", "33"}, new HeroStats(50, 26, 24, 0.46));
        assertEquals(HttpStatus.OK, heroController.putNewHeroData(heroTest.getId(), newHeroData).getStatusCode());
    }

    @Test
    void deleteHero_DeletedHero_ReturnStatusCreated() {
        assertEquals(HttpStatus.OK, heroController.deleteHero(heroTest.getId()).getStatusCode());
    }
}