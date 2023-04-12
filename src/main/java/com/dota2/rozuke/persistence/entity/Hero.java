package com.dota2.rozuke.persistence.entity;

import com.dota2.rozuke.persistence.enums.HeroAttribute;
import com.dota2.rozuke.persistence.enums.TypeAttack;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
public class Hero {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private HeroAttribute attribute;
    private Integer mechanic;
    private TypeAttack attack;
    private String [] characteristic;
    private HeroStats heroStats;

    public Hero(String name, HeroAttribute attribute, Integer mechanic, TypeAttack attack, String[] characteristic, HeroStats heroStats) {
        this.name = name;
        this.attribute = attribute;
        this.mechanic = mechanic;
        this.attack = attack;
        this.characteristic = characteristic;
        this.heroStats = heroStats;
    }

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

    public Hero() {}
}
