package com.dota2.rozuke.domain.service;

import com.dota2.rozuke.ContainerConfig;
import com.dota2.rozuke.domain.dto.HeroDTO;
import com.dota2.rozuke.domain.dto.MatchDTO;
import com.dota2.rozuke.persistence.entity.HeroAverage;
import com.dota2.rozuke.persistence.entity.HeroStats;
import com.dota2.rozuke.persistence.entity.Item;
import com.dota2.rozuke.persistence.entity.PlayStyle;
import com.dota2.rozuke.persistence.enums.HeroAttribute;
import com.dota2.rozuke.persistence.enums.TypeAttack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatchServiceTest extends ContainerConfig {

    @Autowired
    private MatchService matchService;
    @Autowired
    private HeroService heroService;

    private HeroDTO heroTest;
    private MatchDTO matchTest;

    @BeforeEach
    public void instanceEntities() {
        heroTest = heroService.saveNewHero(new HeroDTO("Luna", HeroAttribute.AGILITY, 3, TypeAttack.DISTANCE, new String[]{ "1", "3"}, new HeroStats(20, 8, 12, 0.46)));
        matchTest = matchService.saveNewMatch(new MatchDTO(234123, heroTest, true, 4030, 14, 3, 10, new Item[]{new Item("Travel", 2500), new Item("Vyse", 5700)}, new HeroAverage(800, 30, 14, 5, 30, "Low hero"), new PlayStyle(0, 12, 34,58)));
    }

    @Test
    void getAllMatches_ExistsMatches_ReturnMatches() {
        assertFalse(matchService.getAllMatches().isEmpty());
    }

    @Test
    void getAllMatchesByHero_ExistsHero_ReturnMatches() {
        List<MatchDTO> heroMatches = matchService.getAllMatchesByHero(heroTest.getId());
        assertFalse(heroMatches.isEmpty());

    }

    @Test
    void saveNewMatch_MatchData_ReturnMatchInstance() {
        assertInstanceOf(MatchDTO.class, matchTest);
    }

    @Test
    void updateMatch_NewDataMatch_ReturnInstanceMatch() {
        MatchDTO dataMatch = new MatchDTO(234123, heroTest, false, 4030, 14, 3, 10, new Item[]{new Item("Travel", 2500), new Item("Vyse", 5700)}, new HeroAverage(800, 30, 14, 5, 30, "Low hero"), new PlayStyle(0, 12, 34,58));
        MatchDTO matchUpdated = matchService.updateMatch(matchTest.getId(), dataMatch);
        assertEquals(false, matchUpdated.getVictory());
    }

    @Test
    void deleteMatch_ExistsMatch_ReturnMessageDeleted() {
        assertEquals("Match deleted", matchService.deleteMatch(matchTest.getId()));
    }
}