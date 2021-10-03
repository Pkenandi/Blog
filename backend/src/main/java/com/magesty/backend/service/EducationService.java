package com.magesty.backend.service;

import com.magesty.backend.models.Education;
import com.magesty.backend.models.dto.EducationDto;
import com.magesty.backend.repository.EducationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;

@AllArgsConstructor
@Service
@Transactional
public class EducationService {
    private final EducationRepository educationRepository;

    public EducationDto addEducation(EducationDto educationDto) {
        return EducationDto.from(this.educationRepository.save(requireNonNull(Education.from(educationDto))));
    }

    public List<EducationDto> getAll() {
        return this.educationRepository.findAll()
                .stream()
                .map(EducationDto::from)
                .collect(Collectors.toList());
    }

    public EducationDto getOne(Long id) throws Exception {
        return EducationDto.from(this.educationRepository.findById(id)
                .orElseThrow(() -> new Exception(" Education Not found ")));
    }
}
