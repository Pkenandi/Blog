package com.magesty.backend.service;

import com.magesty.backend.models.Competence;
import com.magesty.backend.models.dto.CompetenceDto;
import com.magesty.backend.repository.CompetenceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

@AllArgsConstructor
@Service
public class CompetenceService {
    private final CompetenceRepository competenceRepository;

    public CompetenceDto addCompetence(CompetenceDto competenceDto){
        return CompetenceDto.from(this.competenceRepository
                .save(requireNonNull(Competence.from(competenceDto))));
    }

    public List<CompetenceDto> getAll(){
        return this.competenceRepository.findAll().stream()
                .map(CompetenceDto::from)
                .collect(Collectors.toList());
    }

    public CompetenceDto getOne(final Long id){
        return CompetenceDto.from(this.competenceRepository.findById(id).orElseThrow(
                () -> new RuntimeException(" Not found ")
        ));
    }
}
