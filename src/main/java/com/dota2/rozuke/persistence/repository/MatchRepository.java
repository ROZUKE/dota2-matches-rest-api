package com.dota2.rozuke.persistence.repository;

import com.dota2.rozuke.domain.dto.MatchDTO;
import com.dota2.rozuke.domain.repository.MatchRepositoryDomain;
import com.dota2.rozuke.persistence.crud.MatchRepositoryCRUD;
import com.dota2.rozuke.persistence.entity.Match;
import com.dota2.rozuke.persistence.mapper.MatchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MatchRepository implements MatchRepositoryDomain {

    @Autowired
    private MatchRepositoryCRUD matchRepository;

    @Autowired
    private MatchMapper mapper;

    @Override
    public Optional<List<MatchDTO>> getAll() {
        List<Match> matches = matchRepository.findAll();
        return Optional.of(mapper.toMatchesDTO(matches));
    }

    @Override
    public Optional<List<MatchDTO>> getAllByHero(String heroId) {
        List<Match> matches = matchRepository.findByHero(heroId);
        return Optional.of(mapper.toMatchesDTO(matches));
    }

    @Override
    public Optional<MatchDTO> findById(int matchId) {
        return matchRepository.findById(matchId).map(match -> mapper.toMatchDTO(match));
    }

    @Override
    public MatchDTO save(MatchDTO match) {
        Match newMatch = mapper.toMatch(match);
        return mapper.toMatchDTO(matchRepository.save(newMatch));
    }

    @Override
    public void delete(int matchId) {
        matchRepository.deleteById(matchId);
    }
}
