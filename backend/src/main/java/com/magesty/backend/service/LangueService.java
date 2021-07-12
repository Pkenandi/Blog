package com.magesty.backend.service;

import com.magesty.backend.models.Langue;
import com.magesty.backend.models.dto.LangueDto;
import com.magesty.backend.repository.LangueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

@AllArgsConstructor
@Service
public class LangueService {
    private final LangueRepository langueRepository;

    public LangueDto addLangue(LangueDto langueDto) {
        return LangueDto.from(this.langueRepository.save(requireNonNull(Langue.from(langueDto))));
    }

    public List<LangueDto> getAll() {
        return this.langueRepository.findAll()
                .stream().map(LangueDto::from)
                .collect(Collectors.toList());
    }

    public LangueDto getOne(final Long id) {
        return LangueDto.from(this.langueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(" Not found ")));
    }
}
