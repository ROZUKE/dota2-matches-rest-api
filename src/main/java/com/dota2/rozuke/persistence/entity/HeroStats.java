package com.dota2.rozuke.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class HeroStats {

    private Integer games;
    private Integer wins;
    private Integer loses;
    private Double winRate;
}
