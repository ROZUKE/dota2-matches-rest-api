package com.dota2.rozuke.domain.dto;

import com.dota2.rozuke.persistence.entity.Hero;
import com.dota2.rozuke.persistence.entity.HeroAverage;
import com.dota2.rozuke.persistence.entity.Item;
import com.dota2.rozuke.persistence.entity.PlayStyle;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

public class MatchDTO {

    private Integer id;
    private Hero hero;
    private Boolean victory;
    private Integer totalGold;
    private Integer kills;
    private Integer deaths;
    private Integer assists;
    private Item[] items;
    private HeroAverage heroAverage;
    private PlayStyle playStyle;

    public MatchDTO(Integer id, Hero hero, Boolean victory, Integer totalGold, Integer kills, Integer deaths, Integer assists, Item[] items, HeroAverage heroAverage, PlayStyle playStyle) {
        this.id = id;
        this.hero = hero;
        this.victory = victory;
        this.totalGold = totalGold;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.items = items;
        this.heroAverage = heroAverage;
        this.playStyle = playStyle;
    }

    public MatchDTO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Boolean getVictory() {
        return victory;
    }

    public void setVictory(Boolean victory) {
        this.victory = victory;
    }

    public Integer getTotalGold() {
        return totalGold;
    }

    public void setTotalGold(Integer totalGold) {
        this.totalGold = totalGold;
    }

    public Integer getKills() {
        return kills;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public HeroAverage getHeroAverage() {
        return heroAverage;
    }

    public void setHeroAverage(HeroAverage heroAverage) {
        this.heroAverage = heroAverage;
    }

    public PlayStyle getPlayStyle() {
        return playStyle;
    }

    public void setPlayStyle(PlayStyle playStyle) {
        this.playStyle = playStyle;
    }
}
