package com.magesty.backend.models.dto;

import com.magesty.backend.models.SocialMedia;
import com.magesty.backend.models.plainDto.PlainAdminDto;
import com.magesty.backend.models.plainDto.PlainAdresseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SocialMediaDto {
    private Long id;
    private String mediaName;
    private String socialUrl;
    private PlainAdminDto plainAdminDto;

    public static SocialMediaDto from(SocialMedia socialMedia){
        SocialMediaDto socialMediaDto = new SocialMediaDto();

        return Optional.ofNullable(socialMedia)
                .map(media -> {
                    socialMediaDto.setId(media.getId());
                    socialMediaDto.setMediaName(media.getMediaName());
                    socialMediaDto.setSocialUrl(media.getSocialUrl());
                    socialMediaDto.setPlainAdminDto(PlainAdminDto.from(media.getAdmin()));

                    return socialMediaDto;
                }).orElse(null);
    }
}