package com.magesty.backend.models.dto;

import com.magesty.backend.models.Experience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExperienceDto {
    private UUID id;
    private String realisedAt;
    private LocalDate start;
    private LocalDate expected_end;
    private String description;

    private AdminDto adminDto;

    public static ExperienceDto from(Experience experience){
        ExperienceDto experienceDto = new ExperienceDto();

        if(Objects.isNull(experience)){
            return null;
        }else{
            experienceDto.setId(experience.getId());
            experienceDto.setDescription(experience.getDescription());
            experienceDto.setRealisedAt(experience.getRealisedAt());
            experienceDto.setStart(experience.getStart());
            experienceDto.setExpected_end(experience.getExpected_end());
            experienceDto.setAdminDto(AdminDto.from(experience.getAdmin()));

            return experienceDto;
        }
    }
}
