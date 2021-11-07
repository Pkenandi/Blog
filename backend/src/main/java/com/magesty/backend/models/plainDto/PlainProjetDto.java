package com.magesty.backend.models.plainDto;

import com.magesty.backend.models.Projet;
import com.magesty.backend.models.dto.ProjetDto;
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
public class PlainProjetDto {
    private Long id;
    private String projetName;
    private LocalDate start;
    private LocalDate end;
    private String techUsed;
    private String seulOuGroup;
    private String description;
    private String imageUrl;
    private boolean current;

    public static PlainProjetDto from(Projet projet){
        PlainProjetDto projetDto = new PlainProjetDto();

        return Optional.ofNullable(projet)
                .map(project -> {
                    projetDto.setId(project.getId());
                    projetDto.setProjetName(project.getProjetName());
                    projetDto.setSeulOuGroup(project.getSeulOuGroup());
                    projetDto.setDescription(project.getDescription());
                    projetDto.setTechUsed(project.getTechUsed());
                    projetDto.setCurrent(project.isCurrent());
                    projetDto.setStart(project.getStart());
                    projetDto.setEnd(project.getEnd());
                    projetDto.setImageUrl(project.getImageUrl());

                    return projetDto;
                }).orElse(null);
    }
}
