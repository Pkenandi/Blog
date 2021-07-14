package com.magesty.backend.models.dto;

import com.magesty.backend.models.SocialMedia;
import com.magesty.backend.models.plainDto.PlainAdminDto;
import com.magesty.backend.models.plainDto.PlainAdresseDto;
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
    private String mediaName;
    private String socialUrl;
    private PlainAdminDto plainAdminDto;

    public static SocialMediaDto from(SocialMedia socialMedia){
        SocialMediaDto socialMediaDto = new SocialMediaDto();

        if(Objects.isNull(socialMedia)){
            return null;
        }else{
            socialMediaDto.setId(socialMedia.getId());
            socialMediaDto.setMediaName(socialMedia.getMediaName());
            socialMediaDto.setSocialUrl(socialMedia.getSocialUrl());
            socialMediaDto.setPlainAdminDto(PlainAdminDto.from(socialMedia.getAdmin()));

            return socialMediaDto;
        }
    }
}
