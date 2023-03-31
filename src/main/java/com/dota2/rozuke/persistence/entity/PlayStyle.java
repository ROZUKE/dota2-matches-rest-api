package com.dota2.rozuke.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayStyle {
    private Integer support;
    private Integer press;
    private Integer fight;
    private Integer farm;
}
