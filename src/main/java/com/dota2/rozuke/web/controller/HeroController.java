package com.dota2.rozuke.web.controller;

import com.dota2.rozuke.domain.dto.HeroDTO;
import com.dota2.rozuke.domain.service.HeroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hero")
@Tag(name = "Hero")
public class HeroController {

    @Autowired
    private HeroService heroService;

    @Operation(
            description = "GET endpoint to watch all the heroes saved",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }
    )
    @GetMapping("/all-heroes")
    public ResponseEntity<List<HeroDTO>> getAllHeroes(){
        return new ResponseEntity<>(heroService.getAllHeroes(), HttpStatus.OK);
    }

    @Operation(
            description = "POST endpoint to save a new hero",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "201"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }
    )
    @PostMapping("/save-hero")
    public ResponseEntity<HeroDTO> postNewHero(@RequestBody HeroDTO hero){
        return new ResponseEntity<>(heroService.saveNewHero(hero), HttpStatus.CREATED);
    }

    @Operation(
            description = "PUT endpoint to update a new hero data",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }
    )
    @PutMapping("/update-hero/{heroId}")
    public ResponseEntity<HeroDTO> putNewHeroData(@PathVariable("heroId") String heroId, @RequestBody HeroDTO newHeroData) {
        return new ResponseEntity<>(heroService.updateHero(heroId, newHeroData), HttpStatus.OK);
    }

    @Operation(
            description = "DELETE endpoint to delete a hero with id",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }
    )
    @DeleteMapping("/delete-hero/{heroId}")
    public ResponseEntity<String> deleteHero(@PathVariable("heroId") String heroId) {
        return new ResponseEntity<>("{\"message\": " + "\"" + heroService.deleteHero(heroId) + "\"" + "}", HttpStatus.OK);
    }
}
