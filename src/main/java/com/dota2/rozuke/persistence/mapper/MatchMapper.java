package com.dota2.rozuke.persistence.mapper;


import com.dota2.rozuke.domain.dto.MatchDTO;
import com.dota2.rozuke.persistence.entity.Match;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MatchMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "hero", target = "hero"),
            @Mapping(source = "totalGold", target = "totalGold"),
            @Mapping(source = "kills", target = "kills"),
            @Mapping(source = "deaths", target = "deaths"),
            @Mapping(source = "assists", target = "assists"),
            @Mapping(source = "items", target = "items"),
            @Mapping(source = "heroAverage", target = "heroAverage"),
            @Mapping(source = "playStyle", target = "playStyle"),
    })
    Match toMatch(MatchDTO matchDTO);

    @InheritInverseConfiguration
    MatchDTO toMatchDTO(Match match);
}
