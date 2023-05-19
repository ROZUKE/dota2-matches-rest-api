package com.dota2.rozuke.domain.service;

import com.dota2.rozuke.domain.dto.HeroDTO;
import com.dota2.rozuke.domain.dto.MatchDTO;
import com.dota2.rozuke.persistence.entity.*;
import com.dota2.rozuke.persistence.repository.HeroRepository;
import com.dota2.rozuke.persistence.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private HeroRepository heroRepository;

    public List<MatchDTO> getAllMatches() {
        return matchRepository.getAll().isPresent() ? matchRepository.getAll().get() : List.of();
    }

    public List<MatchDTO> getAllMatchesByHero(String heroId) {
        return matchRepository.getAll().isPresent() ? matchRepository.getAllByHero(heroId).get() : List.of();
    }

    public MatchDTO saveNewMatch(MatchDTO matchDTO) {
        HeroDTO hero = heroRepository.findById(matchDTO.getHero().getId()).get();
        calculateWinRate(hero, matchDTO.getVictory(), true);
        return matchRepository.save(matchDTO);
    }

    public MatchDTO updateMatch(int matchId, MatchDTO newMatchData) {
        MatchDTO match = matchRepository.findById(matchId).orElseThrow(()-> new RuntimeException("Match not found with ID : " + matchId));
        match.setHero((HeroDTO) compareMatchData(match.getHero(), newMatchData.getHero()));
        match.setVictory((Boolean) compareMatchData(match.getVictory(), newMatchData.getVictory()));
        match.setAssists((Integer) compareMatchData(match.getAssists(), newMatchData.getAssists()));
        match.setDeaths((Integer) compareMatchData(match.getDeaths(), newMatchData.getDeaths()));
        match.setItems((Item[]) compareMatchData(match.getItems(), newMatchData.getItems()));
        match.setHeroAverage((HeroAverage) compareMatchData(match.getHeroAverage(), newMatchData.getHeroAverage()));
        match.setKills((Integer) compareMatchData(match.getKills(), newMatchData.getKills()));
        match.setPlayStyle((PlayStyle) compareMatchData(match.getPlayStyle(), newMatchData.getPlayStyle()));
        match.setTotalGold((Integer) compareMatchData(match.getTotalGold(), newMatchData.getTotalGold()));

        return saveNewMatch(match);
    }

    public String deleteMatch(int matchId) {
        Optional<MatchDTO> matchDetail = matchRepository.findById(matchId);
        if(!matchDetail.isPresent()) return "Match does not exists";
        HeroDTO hero = heroRepository.findById(matchDetail.get().getHero().getId()).get();
        calculateWinRate(hero, matchDetail.get().getVictory(), false);
        matchRepository.delete(matchId);
        return "Match deleted";

    }

    private void calculateWinRate(HeroDTO hero, boolean gameWin, boolean isSaveMatch) {
        int totalMatches = isSaveMatch ? hero.getHeroStats().getGames() + 1 : hero.getHeroStats().getGames() - 1;
        int totalWinnerMatches = hero.getHeroStats().getWins();
        int totalLoseMatches = hero.getHeroStats().getLoses();

        if (gameWin) {
            totalWinnerMatches += isSaveMatch ? 1 : -1;
        } else {
            totalLoseMatches += isSaveMatch ? 1 : -1;
        }
        double winRate = (double) totalWinnerMatches / totalMatches;
        winRate = Math.floor(winRate * 1e2) / 1e2;
        HeroStats newHeroStats = new HeroStats(totalMatches, totalWinnerMatches, totalLoseMatches, winRate);
        heroRepository.updateHeroStats(hero.getId(), newHeroStats);
    }

    private Object compareMatchData(Object currentData, Object newData) {
        return newData != null ? newData: currentData;
    }

}
