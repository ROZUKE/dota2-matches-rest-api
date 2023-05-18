package com.dota2.rozuke.persistence.repository;

import com.dota2.rozuke.ContainerConfig;
import com.dota2.rozuke.domain.dto.HeroDTO;
import com.dota2.rozuke.persistence.entity.HeroStats;
import com.dota2.rozuke.persistence.enums.HeroAttribute;
import com.dota2.rozuke.persistence.enums.TypeAttack;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeroRepositoryTest extends ContainerConfig{

    @Autowired
    private HeroRepository heroRepository;

    @Test
    void getAll_ListNotEmpty_ListOfHeroes() {
        heroRepository.save(new HeroDTO("Luna", HeroAttribute.AGILITY, 3, TypeAttack.DISTANCE, new String[]{ "1", "3"}, new HeroStats(20, 8, 12, 0.46)));
        heroRepository.save(new HeroDTO("Clinks", HeroAttribute.AGILITY, 3, TypeAttack.DISTANCE, new String[]{ "1", "3"}, new HeroStats(30, 20, 10, 0.67)));

        List<HeroDTO> listHeroes = heroRepository.getAll();
        assertFalse(listHeroes.isEmpty());
    }

    @Test
    void save_HeroData_HeroSaved() {
        HeroDTO newHero = heroRepository.save(new HeroDTO("Luna", HeroAttribute.AGILITY, 3, TypeAttack.DISTANCE, new String[]{ "1", "3"}, new HeroStats(20, 8, 12, 0.46)));
        assertNotNull(newHero);
    }

    @Test
    void save_HeroIsNull_ThrowError() {
        HeroDTO newHero = null;
        assertThrows(IllegalArgumentException.class, () -> heroRepository.save(newHero));

    }

    @Test
    void delete_ExistsHeroID_DeleteHero() {
        heroRepository.save(new HeroDTO("Luna", HeroAttribute.AGILITY, 3, TypeAttack.DISTANCE, new String[]{ "1", "3"}, new HeroStats(20, 8, 12, 0.46)));
        String heroID = heroRepository.getAll().get(0).getId();
        heroRepository.delete(heroID);
        assertFalse(heroRepository.findById(heroID).isPresent());
    }

    @Test
    void findById_ExistsID_ReturnHero() {
        HeroDTO newHero = heroRepository.save(new HeroDTO("Luna", HeroAttribute.AGILITY, 3, TypeAttack.DISTANCE, new String[]{ "1", "3"}, new HeroStats(20, 8, 12, 0.46)));
        String heroID = newHero.getId();

        assertInstanceOf(HeroDTO.class, heroRepository.findById(heroID).get());
    }

    @Test
    void updateHeroStats_ExistsHero_ModifyStats() {
        HeroDTO newHero = heroRepository.save(new HeroDTO("Luna", HeroAttribute.AGILITY, 3, TypeAttack.DISTANCE, new String[]{ "1", "3"}, new HeroStats(20, 8, 12, 0.46)));
        HeroStats newStats = new HeroStats(50, 25, 25, 0.50);
        HeroDTO updatedHero = heroRepository.updateHeroStats(newHero.getId(), newStats);
        assertEquals(newStats.getWinRate(), updatedHero.getHeroStats().getWinRate());

    }
}