package com.dota2.rozuke.persistence.entity;

import com.dota2.rozuke.persistence.HeroAttribute;
import com.dota2.rozuke.persistence.TypeAttack;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Hero {
    @Id
    private String id;
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
}
