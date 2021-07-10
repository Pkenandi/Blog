package com.magesty.backend.models.dto;

import com.magesty.backend.models.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminDto {
    private UUID id;
    private String username;
    private String email;
    private String password;

    private ProfileDto profileDto;
    private List<EducationDto> educationDtoList = new ArrayList<>();
    private List<AdresseDto> adresseDtoList = new ArrayList<>();
    private List<CompetenceDto> competenceDtoList = new ArrayList<>();
    private List<CentreInteretDto> centreInteretDtoList = new ArrayList<>();
    private List<ProjetDto> projetDtoList = new ArrayList<>();
    private List<SocialMediaDto> socialMediaDtoList = new ArrayList<>();
    private List<LangueDto> langueDtoList = new ArrayList<>();
    private List<ExperienceDto> experienceDtoList = new ArrayList<>();

    public static AdminDto from(Admin admin){
        AdminDto adminDto = new AdminDto();

        if(Objects.isNull(admin)){
            return null;
        }else{
            adminDto.setId(admin.getId());
            adminDto.setEmail(admin.getEmail());
            adminDto.setPassword(admin.getPassword());
            adminDto.setUsername(admin.getUsername());

            return adminDto;
        }
    }
}
