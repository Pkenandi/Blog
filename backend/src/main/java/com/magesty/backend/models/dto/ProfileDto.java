package com.magesty.backend.models.dto;

import com.magesty.backend.models.Profile;
import com.magesty.backend.models.plainDto.PlainAdminDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfileDto {
    private Long id;
    private String content;
    private PlainAdminDto adminDto;

    public static ProfileDto from(Profile profile){
        ProfileDto profileDto = new ProfileDto();

        if(Objects.isNull(profile)){
            return null;
        }else{
            profileDto.setId(profile.getId());
            profileDto.setContent(profile.getContent());
            profileDto.setAdminDto(PlainAdminDto.from(profile.getAdmin()));

            return profileDto;
        }
    }
}
