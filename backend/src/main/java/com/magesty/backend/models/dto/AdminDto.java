package com.magesty.backend.models.dto;

import com.magesty.backend.models.Admin;
import com.magesty.backend.models.plainDto.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminDto {
    private Long id;
    private String username;
    private String email;
    private String password;

    private PlainProfileDto plainProfileDto;
    private List<PlainEducationDto> plainEducationDtoList = new ArrayList<>();
    private List<PlainAdresseDto> plainAdresseDtoList = new ArrayList<>();
    private List<PlainCompetenceDto> plainCompetenceDtoList = new ArrayList<>();
    private List<PlainCentreInteretDto> plainCentreInteretDtoList = new ArrayList<>();
    private List<PlainProjetDto> plainProjetDtoList = new ArrayList<>();
    private List<PlainSocialMediaDto> plainSocialMediaDtoList = new ArrayList<>();
    private List<PlainLangueDto> plainLangueDtoList = new ArrayList<>();
    private List<PlainExperienceDto> plainExperienceDtoList = new ArrayList<>();

    public static AdminDto from(Admin admin){
        AdminDto adminDto = new AdminDto();

        if(Objects.isNull(admin)){
            return null;
        }else{
            adminDto.setId(admin.get_id());
            adminDto.setEmail(admin.getEmail());
            adminDto.setPassword(admin.getPassword());
            adminDto.setUsername(admin.getUsername());

            adminDto.setPlainProfileDto(PlainProfileDto.from(admin.getProfile()));

            adminDto.setPlainEducationDtoList(admin.getEducationList()
                    .stream()
                    .map(PlainEducationDto::from)
                    .collect(Collectors.toList()));

            adminDto.setPlainAdresseDtoList(admin.getAdresseList()
                    .stream()
                    .map(PlainAdresseDto::from)
                    .collect(Collectors.toList()));

            adminDto.setPlainCompetenceDtoList(admin.getCompetenceList()
                    .stream()
                    .map(PlainCompetenceDto::from)
                    .collect(Collectors.toList()));

            adminDto.setPlainCentreInteretDtoList(admin.getCentreInteretList()
                    .stream()
                    .map(PlainCentreInteretDto::from)
                    .collect(Collectors.toList()));

            adminDto.setPlainProjetDtoList(admin.getProjetList()
                    .stream()
                    .map(PlainProjetDto::from)
                    .collect(Collectors.toList()));

            adminDto.setPlainLangueDtoList(admin.getLangueList()
                    .stream()
                    .map(PlainLangueDto::from)
                    .collect(Collectors.toList()));

            adminDto.setPlainExperienceDtoList(admin.getExperienceList()
                    .stream()
                    .map(PlainExperienceDto::from)
                    .collect(Collectors.toList()));

            return adminDto;
        }
    }
}
