package com.magesty.backend.models.plainDto;

import com.magesty.backend.models.SocialMedia;
import com.magesty.backend.models.dto.SocialMediaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
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

        if(Objects.isNull(socialMedia)){
            return null;
        }else{
            socialMediaDto.setId(socialMedia.getId());
            socialMediaDto.setMediaName(socialMedia.getMediaName());
            socialMediaDto.setSocialUrl(socialMedia.getSocialUrl());

            return socialMediaDto;
        }
    }
}
