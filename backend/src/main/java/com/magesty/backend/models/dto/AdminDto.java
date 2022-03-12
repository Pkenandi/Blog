package com.magesty.backend.models.dto;

import com.magesty.backend.models.Admin;
import com.magesty.backend.models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminDto {
    private Long id;
    private String username;
    private String email;
    private String password;

    private Collection<Role> roles = new ArrayList<>();
    private List<EducationDto> educationDtoList = new ArrayList<>();
    private List<AdresseDto> adresseDtoList = new ArrayList<>();
    private List<CompetenceDto> competenceDtoList = new ArrayList<>();
    private List<CentreInteretDto> centreInteretDtoList = new ArrayList<>();
    private List<ProjetDto> projetDtoList = new ArrayList<>();
    private List<LangueDto> langueDtoList = new ArrayList<>();
    private List<ExperienceDto> experienceDtoList = new ArrayList<>();
    private List<SocialMediaDto> socialMediaDtoList = new ArrayList<>();
    private ProfileDto profileDto;

    public AdminDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public static AdminDto from(Admin admin) {
        AdminDto adminDto = new AdminDto();

        return Optional.ofNullable(admin)
                .map(admins -> {
                    adminDto.setId(admins.getId());
                    adminDto.setEmail(admins.getEmail());
                    adminDto.setPassword(admins.getPassword());
                    adminDto.setUsername(admins.getUsername());

                    adminDto.setProfileDto(ProfileDto.from(admins.getProfile()));
                    adminDto.setRoles(admins.getRoles());

                    adminDto.setEducationDtoList(admins.getEducationList()
                            .stream()
                            .map(EducationDto::from)
                            .collect(Collectors.toList()));

                    adminDto.setAdresseDtoList(admins.getAdresseList()
                            .stream()
                            .map(AdresseDto::from)
                            .collect(Collectors.toList()));

                    adminDto.setCompetenceDtoList(admins.getCompetenceList()
                            .stream()
                            .map(CompetenceDto::from)
                            .collect(Collectors.toList()));

                    adminDto.setCentreInteretDtoList(admins.getCentreInteretList()
                            .stream()
                            .map(CentreInteretDto::from)
                            .collect(Collectors.toList()));

                    adminDto.setProjetDtoList(admins.getProjetList()
                            .stream()
                            .map(ProjetDto::from)
                            .collect(Collectors.toList()));

                    adminDto.setLangueDtoList(admins.getLangueList()
                            .stream()
                            .map(LangueDto::from)
                            .collect(Collectors.toList()));

                    adminDto.setExperienceDtoList(admins.getExperienceList()
                            .stream()
                            .map(ExperienceDto::from)
                            .collect(Collectors.toList()));

                    adminDto.setSocialMediaDtoList(admins.getSocialMediaList()
                            .stream()
                            .map(SocialMediaDto::from)
                            .collect(Collectors.toList()));

                    return adminDto;
                }).orElse(null);
    }
}
