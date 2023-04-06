package com.dota2.rozuke.domain.dto;

import com.dota2.rozuke.persistence.entity.Hero;
import com.dota2.rozuke.persistence.entity.HeroAverage;
import com.dota2.rozuke.persistence.entity.Item;
import com.dota2.rozuke.persistence.entity.PlayStyle;

public class MatchDTO {

    private Integer id;
    private Hero hero;
    private Integer totalGold;
    private Integer kills;
    private Integer deaths;
    private Integer assists;
    private Item[] items;
    private HeroAverage heroAverage;
    private PlayStyle playStyle;

    public Integer getId() {
        return id;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setId(Integer id) {
        this.id = id;
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
