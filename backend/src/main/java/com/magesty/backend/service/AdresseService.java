package com.magesty.backend.service;

import com.magesty.backend.models.Adresse;
import com.magesty.backend.models.dto.AdresseDto;
import com.magesty.backend.repository.AdresseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AdresseService {
    private final AdresseRepository adresseRepository;

    public AdresseDto addAdresse(AdresseDto adresseDto){
        if(Objects.isNull(adresseDto)){
            return null;
        }else {
            return AdresseDto.from(this.adresseRepository.save(Objects.requireNonNull(Adresse.from(adresseDto))));
        }
    }

    public List<AdresseDto> getAll(){
        return this.adresseRepository.findAll()
                .stream()
                .map(AdresseDto::from)
                .collect(Collectors.toList());
    }

    public AdresseDto getOne(Long id){
        return AdresseDto.from(this.adresseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(" Not found")));
    }
}
