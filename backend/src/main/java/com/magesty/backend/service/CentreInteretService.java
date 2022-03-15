package com.magesty.backend.service;

import com.magesty.backend.models.CentreInteret;
import com.magesty.backend.models.dto.CentreInteretDto;
import com.magesty.backend.repository.CentreInteretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

@Service
@Transactional
public class CentreInteretService {
    private final CentreInteretRepository centreInteretRepository;

    @Autowired
    public CentreInteretService(CentreInteretRepository centreInteretRepository) {
        this.centreInteretRepository = centreInteretRepository;
    }

    public CentreInteretDto addCentreInteret(CentreInteretDto centreInteretDto) {
        return CentreInteretDto.from(this.centreInteretRepository
                .save(requireNonNull(CentreInteret.from(centreInteretDto))));
    }

    public List<CentreInteretDto> getAll() {
        return this.centreInteretRepository.findAll()
                .stream().map(CentreInteretDto::from)
                .collect(Collectors.toList());
    }

    public CentreInteretDto getOne(Long id) throws Exception {
        return CentreInteretDto.from(this.centreInteretRepository.findById(id)
                .orElseThrow(() -> new Exception(" Not found")));
    }
}
