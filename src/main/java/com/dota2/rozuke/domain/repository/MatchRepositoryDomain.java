package com.dota2.rozuke.domain.repository;

import com.dota2.rozuke.domain.dto.MatchDTO;

import java.util.List;
import java.util.Optional;

public interface MatchRepositoryDomain {

    Optional<List<MatchDTO>> getAll();
    Optional<List<MatchDTO>> getAllByHero(String heroId);
    Optional<MatchDTO> findById(int matchId);
    MatchDTO save(MatchDTO match);
    void delete(int matchId);


}
