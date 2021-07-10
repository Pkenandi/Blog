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
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity( name = "projet")
public class Projet implements Serializable {
    @Id
    @Column(updatable = false, unique = true, nullable = false)
    @GeneratedValue
    private UUID id;
    private String projetName;
    private LocalDate start;
    private LocalDate end;
    private String techUsed;
    private String seulOuGroup;
    private String description;
    private boolean current;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "project_Id")
    private Admin admin;

    public static Projet from(ProjetDto projetDto){
        Projet projet = new Projet();

        if(Objects.isNull(projetDto)){
            return null;
        }else{
            projet.setId(projetDto.getId());
            projet.setProjetName(projetDto.getProjetName());
            projet.setSeulOuGroup(projetDto.getSeulOuGroup());
            projet.setDescription(projetDto.getDescription());
            projet.setTechUsed(projetDto.getTechUsed());
            projet.setCurrent(projetDto.isCurrent());
            projet.setStart(projetDto.getStart());
            projet.setEnd(projetDto.getEnd());

            return projet;
        }
    }
}
