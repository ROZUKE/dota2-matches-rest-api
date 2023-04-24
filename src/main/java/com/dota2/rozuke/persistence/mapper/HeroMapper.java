package com.dota2.rozuke.persistence.mapper;

import com.dota2.rozuke.domain.dto.HeroDTO;
import com.dota2.rozuke.persistence.entity.Hero;
import org.mapstruct.*;

import java.util.List;

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

    List<HeroDTO> toHeroesDTO(List<Hero> heroes);

    @InheritInverseConfiguration
    HeroDTO toHeroDTO (Hero hero);
}
