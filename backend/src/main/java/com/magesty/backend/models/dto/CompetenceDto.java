package com.magesty.backend.models.dto;

import com.magesty.backend.models.Competence;
import com.magesty.backend.models.plainDto.PlainAdminDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompetenceDto {
    private Long id;
    private String name;
    private Integer numberOfYear;

    private PlainAdminDto plainAdminDto;

    public static CompetenceDto from(Competence competence){
        CompetenceDto competenceDto = new CompetenceDto();

        if(competence != null){
            competenceDto.setId(competence.getId());
            competenceDto.setName(competence.getName());
            competenceDto.setNumberOfYear(competence.getNumberOfYear());

            competenceDto.setPlainAdminDto(PlainAdminDto.from(competence.getAdmin()));

            return competenceDto;
        }else{
           return null;
        }
    }
}
