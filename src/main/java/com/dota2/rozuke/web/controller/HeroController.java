package com.dota2.rozuke.web.controller;

import com.dota2.rozuke.domain.dto.HeroDTO;
import com.dota2.rozuke.domain.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hero")
public class HeroController {

    @Autowired
    private HeroService heroService;

    @GetMapping("/all-heroes")
    public ResponseEntity<List<HeroDTO>> getAllHeroes(){
        return new ResponseEntity<>(heroService.getAllHeroes(), HttpStatus.OK);
    }

    @PostMapping("/save-hero")
    public ResponseEntity<HeroDTO> postNewHero(@RequestBody HeroDTO hero){
        return new ResponseEntity<>(heroService.saveNewHero(hero), HttpStatus.CREATED);
    }

    @PutMapping("/update-hero/{heroId}")
    public ResponseEntity<HeroDTO> putNewHeroData(@PathVariable("heroId") String heroId, @RequestBody HeroDTO newHeroData) {
        return new ResponseEntity<>(heroService.updateHero(heroId, newHeroData), HttpStatus.OK);
    }

    @DeleteMapping("/delete-hero/{heroId}")
    public ResponseEntity<String> deleteHero(@PathVariable("heroId") String heroId) {
        return new ResponseEntity<>("{\"message\": " + "\"" + heroService.deleteHero(heroId) + "\"" + "}", HttpStatus.OK);
    }
}
