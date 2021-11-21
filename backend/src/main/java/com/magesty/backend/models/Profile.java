package com.magesty.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.magesty.backend.models.dto.ProfileDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adminId")
    private Admin admin;

    public static Profile from(ProfileDto profileDto) {
        Profile profile = new Profile();

        return Optional.ofNullable(profileDto)
                .map(profiles -> {
                    profile.setId(profiles.getId());
                    profile.setContent(profiles.getContent());

                    return profile;
                }).orElse(null);
    }
}