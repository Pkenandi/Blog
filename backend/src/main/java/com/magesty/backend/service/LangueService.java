package com.magesty.backend.service;

import com.magesty.backend.models.Langue;
import com.magesty.backend.models.dto.LangueDto;
import com.magesty.backend.repository.LangueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

@Service
@Transactional
public class LangueService {
    private final LangueRepository langueRepository;

    @Autowired
    public LangueService(LangueRepository langueRepository) {
        this.langueRepository = langueRepository;
    }

    public LangueDto addLangue(LangueDto langueDto) {
        return LangueDto.from(this.langueRepository.save(requireNonNull(Langue.from(langueDto))));
    }

    public List<LangueDto> getAll() {
        return this.langueRepository.findAll()
                .stream().map(LangueDto::from)
                .collect(Collectors.toList());
    }

    public LangueDto getOne(Long id) throws Exception {
        return LangueDto.from(this.langueRepository.findById(id)
                .orElseThrow(() -> new Exception("Langue Not found ")));
    }
}
