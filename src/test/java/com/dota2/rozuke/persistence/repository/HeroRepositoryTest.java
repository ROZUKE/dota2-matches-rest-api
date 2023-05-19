package com.dota2.rozuke.persistence.repository;

import com.dota2.rozuke.ContainerConfig;
import com.dota2.rozuke.domain.dto.HeroDTO;
import com.dota2.rozuke.persistence.entity.HeroStats;
import com.dota2.rozuke.persistence.enums.HeroAttribute;
import com.dota2.rozuke.persistence.enums.TypeAttack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeroRepositoryTest extends ContainerConfig{

    @Autowired
    private HeroRepository heroRepository;

    private HeroDTO heroTest;

    @BeforeEach
    public void createHero() {
        heroTest = heroRepository.save(new HeroDTO("Luna", HeroAttribute.AGILITY, 3, TypeAttack.DISTANCE, new String[]{ "1", "3"}, new HeroStats(20, 8, 12, 0.46)));
    }

    @Test
    void getAll_ListNotEmpty_ListOfHeroes() {
        List<HeroDTO> listHeroes = heroRepository.getAll();
        assertFalse(listHeroes.isEmpty());
    }

    @Test
    void save_HeroData_HeroSaved() {
        assertNotNull(heroTest);
    }

    @Test
    void save_HeroIsNull_ThrowError() {
        HeroDTO newHero = null;
        assertThrows(IllegalArgumentException.class, () -> heroRepository.save(newHero));

    }

    @Test
    void delete_ExistsHeroID_DeleteHero() {
        String heroID = heroRepository.getAll().get(0).getId();
        heroRepository.delete(heroID);
        assertFalse(heroRepository.findById(heroID).isPresent());
    }

    @Test
    void findById_ExistsID_ReturnHero() {
        String heroID = heroTest.getId();
        assertInstanceOf(HeroDTO.class, heroRepository.findById(heroID).get());
    }

    @Test
    void updateHeroStats_ExistsHero_ModifyStats() {
        HeroStats newStats = new HeroStats(50, 25, 25, 0.50);
        HeroDTO updatedHero = heroRepository.updateHeroStats(heroTest.getId(), newStats);
        assertEquals(newStats.getWinRate(), updatedHero.getHeroStats().getWinRate());

    }
}