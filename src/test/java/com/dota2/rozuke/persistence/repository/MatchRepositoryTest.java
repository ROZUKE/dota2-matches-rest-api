package com.dota2.rozuke.persistence.repository;

import com.dota2.rozuke.ContainerConfig;
import com.dota2.rozuke.domain.dto.HeroDTO;
import com.dota2.rozuke.domain.dto.MatchDTO;
import com.dota2.rozuke.persistence.entity.*;
import com.dota2.rozuke.persistence.enums.HeroAttribute;
import com.dota2.rozuke.persistence.enums.TypeAttack;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MatchRepositoryTest extends ContainerConfig {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private HeroRepository heroRepository;


    private HeroDTO heroTest;
    private MatchDTO matchTest;
    @BeforeEach
    void instanceEntities() {
         heroTest = heroRepository.save(new HeroDTO("Luna", HeroAttribute.AGILITY, 3, TypeAttack.DISTANCE, new String[]{ "1", "3"}, new HeroStats(20, 8, 12, 0.46)));
         matchTest = matchRepository.save(new MatchDTO(234123, heroTest, true, 4030, 14, 3, 10, new Item[]{new Item("Travel", 2500), new Item("Vyse", 5700)}, new HeroAverage(800, 30, 14, 5, 30, "Low hero"), new PlayStyle(0, 12, 34,58)));
    }

    @Test
    void getAll_ListNotEmpty_AllMatches() {
        assertFalse(matchRepository.getAll().get().isEmpty());
    }

    @Test
    void getAllByHero_ExistsHero_AllHeroMatches() {
        List<MatchDTO> matches = matchRepository.getAllByHero(heroTest.getId()).get();
        assertEquals(heroTest.getId(), matches.get(0).getHero().getId());
    }

    @Test
    void findById_ExistsMatch_InstanceMatch() {
        assertInstanceOf(MatchDTO.class, matchRepository.findById(234123).get());
    }

    @Test
    void findById_NotExistsMatch_Null() {
        assertThrows(NoSuchElementException.class, () -> matchRepository.findById(123123).get());
    }

    @Test
    void save_MatchData_MatchInstance() {
        assertInstanceOf(MatchDTO.class, matchRepository.save(matchTest));

    }

    @Test
    void delete_ExistsMatchID_DeleteMatch() {
       matchRepository.delete(matchTest.getId());
        assertFalse(matchRepository.findById(matchTest.getId()).isPresent());

    }
}