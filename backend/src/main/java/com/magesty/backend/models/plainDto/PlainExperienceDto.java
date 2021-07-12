package com.magesty.backend.models.plainDto;

import com.magesty.backend.models.Experience;
import com.magesty.backend.models.dto.ExperienceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlainExperienceDto {
    private Long id;
    private String realisedAt;
    private LocalDate start;
    private LocalDate expected_end;
    private String description;

    public static PlainExperienceDto from(Experience experience){
        PlainExperienceDto experienceDto = new PlainExperienceDto();

        if(Objects.isNull(experience)){
            return null;
        }else{
            experienceDto.setId(experience.getId());
            experienceDto.setDescription(experience.getDescription());
            experienceDto.setRealisedAt(experience.getRealisedAt());
            experienceDto.setStart(experience.getStart());
            experienceDto.setExpected_end(experience.getExpected_end());

            return experienceDto;
        }
    }
}
