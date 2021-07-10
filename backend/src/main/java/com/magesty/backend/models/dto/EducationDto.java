package com.magesty.backend.models.dto;

import com.magesty.backend.models.Education;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EducationDto {
    private UUID id;
    private String etablissement;
    private String degree;
    private String average;
    private LocalDate start;
    private LocalDate expected_end;
    private boolean current;

    private AdminDto adminDto;

    public static EducationDto from(Education education){
        EducationDto educationDto = new EducationDto();

        if(Objects.isNull(education)){
            return null;
        }else {
            educationDto.setId(education.getId());
            educationDto.setDegree(education.getDegree());
            educationDto.setAverage(education.getAverage());
            educationDto.setEtablissement(education.getEtablissement());
            educationDto.setCurrent(education.isCurrent());
            educationDto.setStart(education.getStart());
            educationDto.setExpected_end(education.getExpected_end());

            educationDto.setAdminDto(AdminDto.from(education.getAdmin()));

            return educationDto;
        }
    }
}
