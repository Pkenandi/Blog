package com.magesty.backend.models.dto;

import com.magesty.backend.models.Projet;
import com.magesty.backend.models.plainDto.PlainAdminDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

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
    private String imageUrl;
    private boolean current;

    private PlainAdminDto plainAdminDto;

    public static ProjetDto from(Projet projet){
        ProjetDto projetDto = new ProjetDto();

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