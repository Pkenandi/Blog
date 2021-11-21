package com.magesty.backend.models.plainDto;

import com.magesty.backend.models.Profile;
import com.magesty.backend.models.dto.AdminDto;
import com.magesty.backend.models.dto.ProfileDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlainProfileDto {
    private Long id;
    private String content;

    public static PlainProfileDto from(Profile profile){
        PlainProfileDto profileDto = new PlainProfileDto();

        return Optional.ofNullable(profile)
                .map(profiles -> {
                    profileDto.setId(profiles.getId());
                    profileDto.setContent(profiles.getContent());

                    return profileDto;
                }).orElse(null);
    }
}
