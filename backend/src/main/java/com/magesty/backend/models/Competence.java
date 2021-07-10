package com.magesty.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.magesty.backend.models.dto.CompetenceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Competence implements Serializable {
    @Id
    @Column(updatable = false, unique = true, nullable = false)
    @GeneratedValue
    private UUID id;
    private String name;
    private Integer numberOfYear;
    private String description;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "comp_Id")
    private Admin admin;

    public static Competence from(CompetenceDto competenceDto){
        Competence competence = new Competence();

        if(Objects.isNull(competenceDto)){
            return null;
        }else{
            competence.setId(competenceDto.getId());
            competence.setName(competenceDto.getName());
            competence.setDescription(competenceDto.getDescription());
            competence.setNumberOfYear(competenceDto.getNumberOfYear());

            return competence;
        }
    }
}
