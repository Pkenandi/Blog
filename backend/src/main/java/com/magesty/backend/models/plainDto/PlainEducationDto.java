package com.magesty.backend.models.plainDto;

import com.magesty.backend.models.Education;
import com.magesty.backend.models.dto.AdminDto;
import com.magesty.backend.models.dto.EducationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlainEducationDto {
    private Long id;
    private String etablissement;
    private String degree;
    private String section;
    private String average;
    private LocalDate start;
    private LocalDate expected_end;
    private String current;
    private String image;

    public static PlainEducationDto from(Education education){
        PlainEducationDto educationDto = new PlainEducationDto();

        if(Objects.isNull(education)){
            return null;
        }else {
            educationDto.setId(education.getId());
            educationDto.setDegree(education.getDegree());
            educationDto.setAverage(education.getAverage());
            educationDto.setSection(education.getSection());
            educationDto.setEtablissement(education.getEtablissement());
            educationDto.setCurrent(education.getCurrent());
            educationDto.setStart(education.getStart());
            educationDto.setExpected_end(education.getExpected_end());
            educationDto.setImage(education.getImage());

            return educationDto;
        }
    }
}
