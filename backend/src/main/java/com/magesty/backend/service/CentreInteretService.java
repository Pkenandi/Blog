package com.magesty.backend.service;

import com.magesty.backend.models.CentreInteret;
import com.magesty.backend.models.dto.CentreInteretDto;
import com.magesty.backend.repository.CentreInteretRepository;
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
public class CentreInteretService {
    private final CentreInteretRepository centreInteretRepository;

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
