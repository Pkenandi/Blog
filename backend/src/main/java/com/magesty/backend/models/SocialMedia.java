package com.magesty.backend.models;

import com.magesty.backend.models.dto.SocialMediaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SocialMedia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String socialUrl;

    public static SocialMedia from(SocialMediaDto socialMediaDto){
        SocialMedia socialMedia = new SocialMedia();

        if(Objects.isNull(socialMediaDto)){
            return null;
        }else {
            socialMedia.setSocialUrl(socialMediaDto.getSocialUrl());
            socialMedia.setId(socialMediaDto.getId());

            return socialMedia;
        }
    }

}
