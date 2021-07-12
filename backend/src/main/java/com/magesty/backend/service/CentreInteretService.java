package com.magesty.backend.service;

import com.magesty.backend.models.CentreInteret;
import com.magesty.backend.models.dto.CentreInteretDto;
import com.magesty.backend.repository.CentreInteretRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

@AllArgsConstructor
@Service
public class CentreInteretService {
    private final CentreInteretRepository centreInteretRepository;

    public CentreInteretDto addCentreInteret(CentreInteretDto centreInteretDto){
        if(Objects.nonNull(centreInteretDto)){
            return CentreInteretDto.from(this.centreInteretRepository
                    .save(requireNonNull(CentreInteret.from(centreInteretDto))));
        }
        return null;
    }

    public List<CentreInteretDto> getAll(){
        return this.centreInteretRepository.findAll()
                .stream().map(CentreInteretDto::from)
                .collect(Collectors.toList());
    }

    public CentreInteretDto getOne(Long id){
        return CentreInteretDto.from(this.centreInteretRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(" Not found")));
    }
}
