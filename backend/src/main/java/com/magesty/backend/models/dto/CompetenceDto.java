package com.magesty.backend.models.dto;

import com.magesty.backend.models.Admin;
import com.magesty.backend.models.Competence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompetenceDto {
    private UUID id;
    private String name;
    private Integer numberOfYear;
    private String description;

    private AdminDto adminDto;

    public static CompetenceDto from(Competence competence){
        CompetenceDto competenceDto = new CompetenceDto();

        if(Objects.isNull(competence)){
            return null;
        }else{
            competenceDto.setId(competence.getId());
            competenceDto.setName(competence.getName());
            competenceDto.setDescription(competence.getDescription());
            competenceDto.setNumberOfYear(competence.getNumberOfYear());

            competenceDto.setAdminDto(AdminDto.from(competence.getAdmin()));

            return competenceDto;
        }
    }
}
