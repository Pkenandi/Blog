package com.magesty.backend.models.dto;

import com.magesty.backend.models.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfileDto {
    private UUID id;
    private String content;
    private AdminDto adminDto;

    public static ProfileDto from(Profile profile){
        ProfileDto profileDto = new ProfileDto();

        if(Objects.isNull(profile)){
            return null;
        }else{
            profileDto.setId(profile.getId());
            profileDto.setContent(profile.getContent());
            profileDto.setAdminDto(AdminDto.from(profile.getAdmin()));

            return profileDto;
        }
    }
}
