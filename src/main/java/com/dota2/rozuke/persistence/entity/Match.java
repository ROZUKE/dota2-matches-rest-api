package com.dota2.rozuke.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Match {
    @Id
    private Integer id;
    private Integer totalGold;
    private Integer kills;
    private Integer deaths;
    private Integer assists;
    private Item [] items;
    private HeroAverage heroAverage;
    private PlayStyle playStyle;


}
