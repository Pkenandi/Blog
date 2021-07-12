package com.magesty.backend.service;

import com.magesty.backend.models.Projet;
import com.magesty.backend.models.dto.ProjetDto;
import com.magesty.backend.repository.ProjetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

@AllArgsConstructor
@Service
public class ProjetService {
    private final ProjetRepository projetRepository;

    public ProjetDto addProjet(ProjetDto projetDto){
        return ProjetDto.from(this.projetRepository.save(requireNonNull(Projet.from(projetDto))));
    }

    public List<ProjetDto> getAll(){
        return this.projetRepository.findAll().stream()
                .map(ProjetDto::from).collect(Collectors.toList());
    }

    public ProjetDto getOne(final Long id){
        return ProjetDto.from(this.projetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(" Not found")));
    }
}
