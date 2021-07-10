package com.magesty.backend.models;

import com.magesty.backend.models.dto.SocialMediaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SocialMedia implements Serializable {
    @Id
    @Column(updatable = false, unique = true, nullable = false)
    @GeneratedValue
    private UUID id;
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
