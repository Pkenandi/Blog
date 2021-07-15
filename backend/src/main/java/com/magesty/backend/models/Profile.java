package com.magesty.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.magesty.backend.models.dto.ProfileDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Profile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String imgUrl;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adminId")
    private Admin admin;

    public static Profile from(ProfileDto profileDto){
        Profile profile = new Profile();

        if(Objects.isNull(profileDto)){
            return null;
        }else{
            profile.setId(profileDto.getId());
            profile.setImgUrl(profile.getImgUrl());
            profile.setContent(profileDto.getContent());

            return profile;
        }
    }
}
