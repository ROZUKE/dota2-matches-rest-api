package com.dota2.rozuke.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class PlayStyle {
    private Integer support;
    private Integer press;
    private Integer fight;
    private Integer farm;

    public PlayStyle(Integer support, Integer press, Integer fight, Integer farm) {
        this.support = support;
        this.press = press;
        this.fight = fight;
        this.farm = farm;
    }

    public PlayStyle() {
    }

    public Integer getSupport() {
        return support;
    }

    public void setSupport(Integer support) {
        this.support = support;
    }

    public Integer getPress() {
        return press;
    }

    public void setPress(Integer press) {
        this.press = press;
    }

    public Integer getFight() {
        return fight;
    }

    public void setFight(Integer fight) {
        this.fight = fight;
    }

    public Integer getFarm() {
        return farm;
    }

    public void setFarm(Integer farm) {
        this.farm = farm;
    }
}
