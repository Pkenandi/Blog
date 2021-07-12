package com.magesty.backend.models.dto;

import com.magesty.backend.models.SocialMedia;
import com.magesty.backend.models.plainDto.PlainAdminDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SocialMediaDto {
    private Long id;
    private String socialUrl;

    public static SocialMediaDto from(SocialMedia socialMedia){
        SocialMediaDto socialMediaDto = new SocialMediaDto();

        if(Objects.isNull(socialMedia)){
            return null;
        }else{
            socialMediaDto.setId(socialMedia.getId());
            socialMediaDto.setSocialUrl(socialMedia.getSocialUrl());

            return socialMediaDto;
        }
    }
}
