package com.magesty.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.magesty.backend.models.dto.AdresseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Adresse implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;
    private String avenue;
    private String pays;
    private String ville;
    private String phone;
    private String email;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adresseId")
    private Admin admin;

    public static Adresse from(AdresseDto adresseDto){
        Adresse adresse = new Adresse();

        if(Objects.isNull(adresseDto)){
            return null;
        }else{
            adresse.set_id(adresseDto.getId());
            adresse.setAvenue(adresseDto.getAvenue());
            adresse.setEmail(adresseDto.getEmail());
            adresse.setPhone(adresseDto.getPhone());
            adresse.setPays(adresseDto.getPays());
            adresse.setVille(adresseDto.getVille());

            return adresse;
        }
    }


}