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
    private String description;

    private PlainAdminDto adminDto;

    public static CompetenceDto from(Competence competence){
        CompetenceDto competenceDto = new CompetenceDto();

        if(Objects.isNull(competence)){
            return null;
        }else{
            competenceDto.setId(competence.getId());
            competenceDto.setName(competence.getName());
            competenceDto.setDescription(competence.getDescription());
            competenceDto.setNumberOfYear(competence.getNumberOfYear());

            competenceDto.setAdminDto(PlainAdminDto.from(competence.getAdmin()));

            return competenceDto;
        }
    }
}
