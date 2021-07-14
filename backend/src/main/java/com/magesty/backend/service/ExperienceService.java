package com.magesty.backend.service;

import com.magesty.backend.models.Experience;
import com.magesty.backend.models.dto.ExperienceDto;
import com.magesty.backend.repository.ExperienceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

@AllArgsConstructor
@Service
@Transactional
public class ExperienceService {
    private final ExperienceRepository experienceRepository;

    public ExperienceDto addExperience(ExperienceDto experienceDto){
        return ExperienceDto.from(this.experienceRepository
                .save(requireNonNull(Experience.from(experienceDto))));
    }

    public List<ExperienceDto> getAll(){
        return this.experienceRepository.findAll()
                .stream().map(ExperienceDto::from)
                .collect(Collectors.toList());
    }

    public ExperienceDto getOne(final Long id) throws Exception {
        return ExperienceDto.from(this.experienceRepository.findById(id)
                .orElseThrow(() -> new Exception(" Experience Not found ")));
    }

}
