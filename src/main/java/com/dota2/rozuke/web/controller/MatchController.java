package com.dota2.rozuke.web.controller;

import com.dota2.rozuke.domain.dto.MatchDTO;
import com.dota2.rozuke.domain.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping("/all-matches")
    public ResponseEntity<List<MatchDTO>> getAllMatches() {
        return new ResponseEntity<>(matchService.getAllMatches(), HttpStatus.OK);
    }

    @GetMapping("/all-matches/hero/{heroId}")
    public ResponseEntity<List<MatchDTO>> getAllMatchesByHero(@PathVariable("heroId") String heroId) {
        return new ResponseEntity<>(matchService.getAllMatchesByHero(heroId), HttpStatus.OK);
    }

    @PostMapping("/save-match")
    public ResponseEntity<MatchDTO> postNewMatch(@RequestBody MatchDTO newMatch) {
        return new ResponseEntity<>(matchService.saveNewMatch(newMatch), HttpStatus.CREATED);
    }

    @PutMapping("update-match/{matchId}")
    public ResponseEntity<MatchDTO> putMatch(@PathVariable("matchId")Integer matchId, @RequestBody MatchDTO data) {
        return new ResponseEntity<>(matchService.updateMatch(matchId, data), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-match/{matchId}")
    public ResponseEntity<String> deleteMatch(@PathVariable("matchId") int matchId) {
        return new ResponseEntity<>("{\"message\": " + "\"" + matchService.deleteMatch(matchId) + "\"" + "}", HttpStatus.OK);
    }
}
