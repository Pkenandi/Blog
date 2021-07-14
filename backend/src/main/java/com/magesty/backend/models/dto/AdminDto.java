package com.magesty.backend.models.dto;

import com.magesty.backend.models.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminDto {
    private Long id;
    private String username;
    private String email;
    private String password;

    private List<EducationDto> educationDtoList = new ArrayList<>();
    private List<AdresseDto> adresseDtoList = new ArrayList<>();
    private List<CompetenceDto> competenceDtoList = new ArrayList<>();
    private List<CentreInteretDto> centreInteretDtoList = new ArrayList<>();
    private List<ProjetDto> projetDtoList = new ArrayList<>();
    private List<LangueDto> langueDtoList = new ArrayList<>();
    private List<ExperienceDto> experienceDtoList = new ArrayList<>();
    private List<SocialMediaDto> socialMediaDtoList = new ArrayList<>();
    private ProfileDto profileDto;

    public static AdminDto from(Admin admin) {
        AdminDto adminDto = new AdminDto();

        if (admin != null) {

            adminDto.setId(admin.getId());
            adminDto.setEmail(admin.getEmail());
            adminDto.setPassword(admin.getPassword());
            adminDto.setUsername(admin.getUsername());

            adminDto.setProfileDto(ProfileDto.from(admin.getProfile()));

            adminDto.setEducationDtoList(admin.getEducationList()
                    .stream()
                    .map(EducationDto::from)
                    .collect(Collectors.toList()));

            adminDto.setAdresseDtoList(admin.getAdresseList()
                    .stream()
                    .map(AdresseDto::from)
                    .collect(Collectors.toList()));

            adminDto.setCompetenceDtoList(admin.getCompetenceList()
                    .stream()
                    .map(CompetenceDto::from)
                    .collect(Collectors.toList()));

            adminDto.setCentreInteretDtoList(admin.getCentreInteretList()
                    .stream()
                    .map(CentreInteretDto::from)
                    .collect(Collectors.toList()));

            adminDto.setProjetDtoList(admin.getProjetList()
                    .stream()
                    .map(ProjetDto::from)
                    .collect(Collectors.toList()));

            adminDto.setLangueDtoList(admin.getLangueList()
                    .stream()
                    .map(LangueDto::from)
                    .collect(Collectors.toList()));

            adminDto.setExperienceDtoList(admin.getExperienceList()
                    .stream()
                    .map(ExperienceDto::from)
                    .collect(Collectors.toList()));

            adminDto.setSocialMediaDtoList(admin.getSocialMediaList()
                    .stream()
                    .map(SocialMediaDto::from)
                    .collect(Collectors.toList()));

            return adminDto;
        } else {
            return null;
        }
    }
}
