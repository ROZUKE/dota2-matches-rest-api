package com.dota2.rozuke.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@AllArgsConstructor
public class Match {
    @Id
    private Integer id;
    @DBRef
    private Hero hero;
    private Boolean victory;
    private Integer totalGold;
    private Integer kills;
    private Integer deaths;
    private Integer assists;
    private Item [] items;
    private HeroAverage heroAverage;
    private PlayStyle playStyle;

    public Match(Hero hero, Boolean victory, Integer totalGold, Integer kills, Integer deaths, Integer assists, Item[] items, HeroAverage heroAverage, PlayStyle playStyle) {
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

    public Match() {
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
