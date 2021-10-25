package com.magesty.backend.models.dto;

import com.magesty.backend.models.Education;
import com.magesty.backend.models.plainDto.PlainAdminDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EducationDto {
    private Long id;
    private String etablissement;
    private String degree;
    private String section;
    private String average;
    private LocalDate start;
    private LocalDate expected_end;
    private String current;
    private String image;

    private PlainAdminDto plainAdminDto;

    public static EducationDto from(Education education){
        EducationDto educationDto = new EducationDto();

        return Optional.ofNullable(education)
                .map(edu -> {
                    educationDto.setId(education.getId());
                    educationDto.setDegree(education.getDegree());
                    educationDto.setAverage(education.getAverage());
                    educationDto.setSection(education.getSection());
                    educationDto.setEtablissement(education.getEtablissement());
                    educationDto.setCurrent(education.getCurrent());
                    educationDto.setStart(education.getStart());
                    educationDto.setExpected_end(education.getExpected_end());
                    educationDto.setImage(education.getImage());

                    educationDto.setPlainAdminDto(PlainAdminDto.from(education.getAdmin()));
                    return educationDto;
                }).orElse(null);
    }
}