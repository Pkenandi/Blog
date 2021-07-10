package com.magesty.backend.models.plainDto;

import com.magesty.backend.models.Competence;
import com.magesty.backend.models.dto.CompetenceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlainCompetenceDto {
    private UUID id;
    private String name;
    private Integer numberOfYear;
    private String description;

    public static PlainCompetenceDto from(Competence competence){
        PlainCompetenceDto competenceDto = new PlainCompetenceDto();

        if(Objects.isNull(competence)){
            return null;
        }else{
            competenceDto.setId(competence.getId());
            competenceDto.setName(competence.getName());
            competenceDto.setDescription(competence.getDescription());
            competenceDto.setNumberOfYear(competence.getNumberOfYear());

            return competenceDto;
        }
    }
}
