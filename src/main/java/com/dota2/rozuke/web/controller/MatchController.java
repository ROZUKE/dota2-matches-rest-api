package com.dota2.rozuke.web.controller;

import com.dota2.rozuke.domain.dto.MatchDTO;
import com.dota2.rozuke.domain.service.MatchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
@Tag(name = "Match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @Operation(
            description = "GET endpoint to watch all the matches that are saved",
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
    @GetMapping("/all-matches")
    public ResponseEntity<List<MatchDTO>> getAllMatches() {
        return new ResponseEntity<>(matchService.getAllMatches(), HttpStatus.OK);
    }

    @Operation(
            description = "GET endpoint to watch all the matches for a hero",
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
    @GetMapping("/all-matches/hero/{heroId}")
    public ResponseEntity<List<MatchDTO>> getAllMatchesByHero(@PathVariable("heroId") String heroId) {
        return new ResponseEntity<>(matchService.getAllMatchesByHero(heroId), HttpStatus.OK);
    }

    @Operation(
            description = "POST endpoint to save data from a new match",
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
    @PostMapping("/save-match")
    public ResponseEntity<MatchDTO> postNewMatch(@RequestBody MatchDTO newMatch) {
        return new ResponseEntity<>(matchService.saveNewMatch(newMatch), HttpStatus.CREATED);
    }

    @Operation(
            description = "PUT endpoint to update a match with new data",
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
    @PutMapping("update-match/{matchId}")
    public ResponseEntity<MatchDTO> putMatch(@PathVariable("matchId")Integer matchId, @RequestBody MatchDTO data) {
        return new ResponseEntity<>(matchService.updateMatch(matchId, data), HttpStatus.OK);
    }

    @Operation(
            description = "DELETE endpoint to delete a match with id",
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
    @DeleteMapping("/delete-match/{matchId}")
    public ResponseEntity<String> deleteMatch(@PathVariable("matchId") int matchId) {
        return new ResponseEntity<>("{\"message\": " + "\"" + matchService.deleteMatch(matchId) + "\"" + "}", HttpStatus.OK);
    }
}
