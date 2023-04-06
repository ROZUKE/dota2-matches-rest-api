package com.dota2.rozuke.persistence.mapper;

import com.dota2.rozuke.domain.dto.HeroDTO;
import com.dota2.rozuke.persistence.entity.Hero;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface HeroMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "attribute", target = "attribute"),
            @Mapping(source = "mechanic", target = "mechanic"),
            @Mapping(source = "attack", target = "attack"),
            @Mapping(source = "characteristic", target = "characteristic"),
            @Mapping(source = "heroStats", target = "heroStats"),
    })
    Hero toHero (HeroDTO heroDTO);

    @InheritInverseConfiguration
    HeroDTO toHeroDTO (Hero hero);
}
