package com.magesty.backend.service;

import com.magesty.backend.models.Competence;
import com.magesty.backend.models.dto.CompetenceDto;
import com.magesty.backend.repository.CompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

@Service
@Transactional
public class CompetenceService {
    private final CompetenceRepository competenceRepository;

    @Autowired
    public CompetenceService(CompetenceRepository competenceRepository) {
        this.competenceRepository = competenceRepository;
    }

    public CompetenceDto addCompetence(CompetenceDto competenceDto){
        return CompetenceDto.from(this.competenceRepository
                .save(requireNonNull(Competence.from(competenceDto))));
    }

    public List<CompetenceDto> getAll(){
        return this.competenceRepository.findAll().stream()
                .map(CompetenceDto::from)
                .collect(Collectors.toList());
    }

    public CompetenceDto getOne(final Long id) throws Exception {
        return CompetenceDto.from(this.competenceRepository.findById(id)
                .orElseThrow(() -> new Exception("Competence Not found ")
        ));
    }
}
