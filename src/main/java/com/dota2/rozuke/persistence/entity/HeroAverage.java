package com.dota2.rozuke.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HeroAverage {
    private Integer gpm;
    private Integer xpm;
    private Integer victims;
    private Integer deaths;
    private Integer assists;
    private String description;
}
