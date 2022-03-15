package com.magesty.backend.service;

import com.magesty.backend.models.Projet;
import com.magesty.backend.models.dto.ProjetDto;
import com.magesty.backend.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

@Service
@Transactional
public class ProjetService {
    private final ProjetRepository projetRepository;

    @Autowired
    public ProjetService(ProjetRepository projetRepository) {
        this.projetRepository = projetRepository;
    }

    public ProjetDto addProjet(ProjetDto projetDto){
        return ProjetDto.from(this.projetRepository.save(requireNonNull(Projet.from(projetDto))));
    }

    public List<ProjetDto> getAll(){
        return this.projetRepository.findAll()
                .stream()
                .map(ProjetDto::from)
                .collect(Collectors.toList());
    }

    public ProjetDto getOne(final Long id) throws Exception {
        return ProjetDto.from(this.projetRepository.findById(id)
                .orElseThrow(() -> new Exception("Projet Not found")));
    }
}
