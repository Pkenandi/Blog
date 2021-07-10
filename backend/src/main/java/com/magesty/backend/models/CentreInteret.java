package com.magesty.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.magesty.backend.models.dto.CentreInteretDto;
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
public class CentreInteret implements Serializable {
    @Id
    @Column(updatable = false, unique = true, nullable = false)
    @GeneratedValue
    private UUID id;
    private String name;
    private String description;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "interest_Id")
    private Admin admin;

    public static CentreInteret from(CentreInteretDto centreInteretDto){
        CentreInteret centreInteret = new CentreInteret();

        if(Objects.isNull(centreInteretDto)){
            return null;
        }else{
            centreInteret.setId(centreInteretDto.getId());
            centreInteret.setDescription(centreInteretDto.getDescription());
            centreInteret.setName(centreInteretDto.getName());

            return centreInteret;
        }
    }

}
