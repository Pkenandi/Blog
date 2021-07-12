package com.magesty.backend.models.dto;

import com.magesty.backend.models.Projet;
import com.magesty.backend.models.plainDto.PlainAdminDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjetDto {
    private Long id;
    private String projetName;
    private LocalDate start;
    private LocalDate end;
    private String techUsed;
    private String seulOuGroup;
    private String description;
    private boolean current;

    private PlainAdminDto adminDto;

    public static ProjetDto from(Projet projet){
        ProjetDto projetDto = new ProjetDto();

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
            projetDto.setAdminDto(PlainAdminDto.from(projet.getAdmin()));

            return projetDto;
        }
    }
}