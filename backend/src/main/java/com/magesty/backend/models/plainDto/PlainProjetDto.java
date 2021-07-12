package com.magesty.backend.models.plainDto;

import com.magesty.backend.models.Projet;
import com.magesty.backend.models.dto.ProjetDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlainProjetDto {
    private Long id;
    private String projetName;
    private LocalDate start;
    private LocalDate end;
    private String techUsed;
    private String seulOuGroup;
    private String description;
    private boolean current;

    public static PlainProjetDto from(Projet projet){
        PlainProjetDto projetDto = new PlainProjetDto();

        if(Objects.isNull(projet)){
            return null;
        }else{
            projetDto.setId(projet.getId());
            projetDto.setProjetName(projet.getProjetName());
            projetDto.setSeulOuGroup(projet.getSeulOuGroup());
            projetDto.setDescription(projet.getDescription());
            projetDto.setTechUsed(projet.getTechUsed());
            projetDto.setCurrent(projet.isCurrent());
            projetDto.setStart(projet.getStart());
            projetDto.setEnd(projet.getEnd());

            return projetDto;
        }
    }
}
