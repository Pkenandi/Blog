package com.magesty.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.magesty.backend.models.dto.AdminDto;
import com.magesty.backend.models.dto.LangueDto;
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
@Entity( name = "langue")
public class Langue implements Serializable {
    @Id
    @Column(updatable = false, unique = true, nullable = false)
    @GeneratedValue
    private UUID id;
    private String name;
    private String level;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "langue_Id")
    private Admin admin;

    public static Langue from(LangueDto langueDto){
        Langue langue = new Langue();

        if(Objects.isNull(langueDto)){
            return null;
        }else{
            langue.setId(langueDto.getId());
            langue.setName(langueDto.getName());
            langue.setLevel(langueDto.getLevel());

            return langue;
        }
    }
}
