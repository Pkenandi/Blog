package com.magesty.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.magesty.backend.models.dto.SocialMediaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static javax.persistence.FetchType.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SocialMedia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mediaName;
    private String socialUrl;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "media_id")
    private Admin admin;

    public static SocialMedia from(SocialMediaDto socialMediaDto) {
        SocialMedia socialMedia = new SocialMedia();
        return Optional.ofNullable(socialMediaDto)
                .map(media -> {
                    socialMedia.setSocialUrl(media.getSocialUrl());
                    socialMedia.setMediaName(media.getMediaName());
                    socialMedia.setId(media.getId());

                    return socialMedia;
                }).orElse(null);
    }
}