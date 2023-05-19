package com.dota2.rozuke.web.controller;

import com.dota2.rozuke.ContainerConfig;
import com.dota2.rozuke.domain.dto.HeroDTO;
import com.dota2.rozuke.domain.dto.MatchDTO;
import com.dota2.rozuke.domain.service.HeroService;
import com.dota2.rozuke.domain.service.MatchService;
import com.dota2.rozuke.persistence.entity.HeroAverage;
import com.dota2.rozuke.persistence.entity.HeroStats;
import com.dota2.rozuke.persistence.entity.Item;
import com.dota2.rozuke.persistence.entity.PlayStyle;
import com.dota2.rozuke.persistence.enums.HeroAttribute;
import com.dota2.rozuke.persistence.enums.TypeAttack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

class MatchControllerTest extends ContainerConfig {

    @Autowired
    private MatchController matchController;

    @Autowired
    private MatchService matchService;
    @Autowired
    private HeroService heroService;

    private MatchDTO matchTest;
    private HeroDTO heroTest;

    @BeforeEach
    public void instanceEntities() {
        heroTest = heroService.saveNewHero(new HeroDTO("Luna", HeroAttribute.AGILITY, 3, TypeAttack.DISTANCE, new String[]{ "1", "3"}, new HeroStats(20, 8, 12, 0.46)));
        matchTest = matchService.saveNewMatch(new MatchDTO(234123, heroTest, true, 4030, 14, 3, 10, new Item[]{new Item("Travel", 2500), new Item("Vyse", 5700)}, new HeroAverage(800, 30, 14, 5, 30, "Low hero"), new PlayStyle(0, 12, 34,58)));
    }

    @Test
    void getAllMatches_ExitsMatches_ReturnStatusOk() {
        assertEquals(HttpStatus.OK, matchController.getAllMatches().getStatusCode());
    }

    @Test
    void getAllMatchesByHero_ExistsMatches_ReturnStatusOk() {
        assertEquals(HttpStatus.OK, matchController.getAllMatchesByHero(heroTest.getId()).getStatusCode());
    }

    @Test
    void postNewMatch_NewMatchData_ReturnStatusCreated() {
        MatchDTO newMatch = new MatchDTO(2332, heroTest, false, 5423, 14, 3, 10, new Item[]{new Item("Travel", 2500), new Item("Vyse", 5700)}, new HeroAverage(800, 30, 14, 5, 30, "Low hero"), new PlayStyle(0, 12, 34,58));
        assertEquals(HttpStatus.CREATED, matchController.postNewMatch(newMatch).getStatusCode());
    }

    @Test
    void putMatch_NewMatchData_ReturnStatusOk() {
        MatchDTO newDataMatch = new MatchDTO(234123, heroTest, false, 5423, 14, 3, 10, new Item[]{new Item("Travel", 2500), new Item("Vyse", 5700)}, new HeroAverage(800, 30, 14, 5, 30, "Low hero"), new PlayStyle(0, 12, 34,58));
        assertEquals(HttpStatus.OK, matchController.putMatch(matchTest.getId(), newDataMatch).getStatusCode());
    }

    @Test
    void deleteMatch_ExistsMatch_ReturnStatusCreated() {
        assertEquals(HttpStatus.OK, matchController.deleteMatch(matchTest.getId()).getStatusCode());
    }
}