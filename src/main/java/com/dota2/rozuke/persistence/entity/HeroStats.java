package com.dota2.rozuke.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data

public class HeroStats {

    public HeroStats(Integer games, Integer wins, Integer loses, Double winRate) {
        this.games = games;
        this.wins = wins;
        this.loses = loses;
        this.winRate = winRate;
    }

    private Integer games;
    private Integer wins;
    private Integer loses;
    private Double winRate;

    public Integer getGames() {
        return games;
    }

    public void setGames(Integer games) {
        this.games = games;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLoses() {
        return loses;
    }

    public void setLoses(Integer loses) {
        this.loses = loses;
    }

    public Double getWinRate() {
        return winRate;
    }

    public void setWinRate(Double winRate) {
        this.winRate = winRate;
    }
}
