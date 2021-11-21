package com.magesty.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.magesty.backend.models.dto.AdminDto;
import com.magesty.backend.models.dto.ProjetDto;
import com.magesty.backend.models.plainDto.PlainAdminDto;
import com.magesty.backend.models.plainDto.PlainProjetDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Projet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projetName;
    private LocalDate start;
    private LocalDate end;
    private String techUsed;
    private String seulOuGroup;
    private String description;
    private String imageUrl;
    private boolean current;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "projectId")
    private Admin admin;

    public static Projet from(ProjetDto projetDto){
        Projet projet = new Projet();

        return Optional.ofNullable(projetDto)
                .map(projectDto -> {
                    projet.setId(projectDto.getId());
                    projet.setProjetName(projectDto.getProjetName());
                    projet.setSeulOuGroup(projectDto.getSeulOuGroup());
                    projet.setDescription(projectDto.getDescription());
                    projet.setTechUsed(projectDto.getTechUsed());
                    projet.setCurrent(projectDto.isCurrent());
                    projet.setStart(projectDto.getStart());
                    projet.setEnd(projectDto.getEnd());
                    projet.setImageUrl(projectDto.getImageUrl());

                    return projet;
                }).orElse(null);
    }
}
