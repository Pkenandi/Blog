package com.magesty.backend.service;

import com.magesty.backend.models.SocialMedia;
import com.magesty.backend.models.dto.SocialMediaDto;
import com.magesty.backend.repository.SocialMediaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

@AllArgsConstructor
@Service
public class SocialMediaService {
    private final SocialMediaRepository socialMediaRepository;

    public SocialMediaDto addSocialMedia( SocialMediaDto socialMediaDto){
        return SocialMediaDto.from(this.socialMediaRepository
                .save(requireNonNull(SocialMedia.from(socialMediaDto))));
    }

    public List<SocialMediaDto> getAll(){
        return this.socialMediaRepository.findAll()
                .stream().map(SocialMediaDto::from)
                .collect(Collectors.toList());
    }

    public SocialMediaDto getOne(final Long id){
        return SocialMediaDto.from(this.socialMediaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException(" Not found")));
    }
}
