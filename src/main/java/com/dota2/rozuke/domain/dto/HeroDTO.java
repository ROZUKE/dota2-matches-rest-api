package com.dota2.rozuke.domain.dto;

import com.dota2.rozuke.persistence.HeroAttribute;
import com.dota2.rozuke.persistence.TypeAttack;
import com.dota2.rozuke.persistence.entity.HeroStats;

public class HeroDTO {
    private String id;
    private String name;
    private HeroAttribute attribute;
    private Integer mechanic;
    private TypeAttack attack;
    private String [] characteristic;
    private HeroStats heroStats;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroAttribute getAttribute() {
        return attribute;
    }

    public void setAttribute(HeroAttribute attribute) {
        this.attribute = attribute;
    }

    public Integer getMechanic() {
        return mechanic;
    }

    public void setMechanic(Integer mechanic) {
        this.mechanic = mechanic;
    }

    public TypeAttack getAttack() {
        return attack;
    }

    public void setAttack(TypeAttack attack) {
        this.attack = attack;
    }

    public String[] getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String[] characteristic) {
        this.characteristic = characteristic;
    }

    public HeroStats getHeroStats() {
        return heroStats;
    }

    public void setHeroStats(HeroStats heroStats) {
        this.heroStats = heroStats;
    }
}
