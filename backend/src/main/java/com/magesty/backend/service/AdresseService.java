package com.magesty.backend.service;

import com.magesty.backend.models.Adresse;
import com.magesty.backend.models.SocialMedia;
import com.magesty.backend.models.dto.AdresseDto;
import com.magesty.backend.models.dto.SocialMediaDto;
import com.magesty.backend.repository.AdresseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.*;

@Transactional
@AllArgsConstructor
@Service
public class AdresseService {
    private final AdresseRepository adresseRepository;

    public AdresseDto addAdresse(AdresseDto adresseDto) {
        return AdresseDto.from(this.adresseRepository.save(requireNonNull(Adresse.from(adresseDto))));
    }

    public List<AdresseDto> getAll() {
        return this.adresseRepository.findAll()
                .stream()
                .map(AdresseDto::from)
                .collect(Collectors.toList());
    }

    public AdresseDto getOne(Long id) throws Exception {
        return AdresseDto.from(this.adresseRepository.findById(id)
                .orElseThrow(() -> new Exception(" Adresse Not found")));
    }

}
