package com.magesty.backend.models.plainDto;

import com.magesty.backend.models.SocialMedia;
import com.magesty.backend.models.dto.SocialMediaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlainSocialMediaDto {
    private Long id;
    private String mediaName;
    private String socialUrl;

    public static PlainSocialMediaDto from(SocialMedia socialMedia){
        PlainSocialMediaDto socialMediaDto = new PlainSocialMediaDto();

        return Optional.ofNullable(socialMedia)
                .map(media -> {
                    socialMediaDto.setSocialUrl(media.getSocialUrl());
                    socialMediaDto.setMediaName(media.getMediaName());
                    socialMediaDto.setId(media.getId());

                    return socialMediaDto;
                }).orElse(null);
    }
}
