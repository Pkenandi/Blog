package com.magesty.backend.models;

import com.magesty.backend.models.dto.AdminDto;
import com.magesty.backend.models.dto.ProfileDto;
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
public class Profile implements Serializable {
    @Id
    @Column(updatable = false, unique = true, nullable = false)
    @GeneratedValue
    private UUID id;
    private String content;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_Id")
    private Admin admin;

    public static Profile from(ProfileDto profileDto){
        Profile profile = new Profile();

        if(Objects.isNull(profileDto)){
            return null;
        }else{
            profile.setId(profileDto.getId());
            profile.setContent(profileDto.getContent());

            return profile;
        }
    }
}
