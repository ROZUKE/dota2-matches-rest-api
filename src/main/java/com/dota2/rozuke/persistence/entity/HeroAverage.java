package com.dota2.rozuke.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class HeroAverage {
    private Integer gpm;
    private Integer xpm;
    private Integer victims;
    private Integer deaths;
    private Integer assists;
    private String description;

    public HeroAverage(Integer gpm, Integer xpm, Integer victims, Integer deaths, Integer assists, String description) {
        this.gpm = gpm;
        this.xpm = xpm;
        this.victims = victims;
        this.deaths = deaths;
        this.assists = assists;
        this.description = description;
    }

    public Integer getGpm() {
        return gpm;
    }

    public void setGpm(Integer gpm) {
        this.gpm = gpm;
    }

    public Integer getXpm() {
        return xpm;
    }

    public void setXpm(Integer xpm) {
        this.xpm = xpm;
    }

    public Integer getVictims() {
        return victims;
    }

    public void setVictims(Integer victims) {
        this.victims = victims;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
