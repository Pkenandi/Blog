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
    @Column(updatable = false, unique = true, nullable = false)
    @GeneratedValue
    private UUID id;
    private String avenue;
    private String pays;
    private String ville;
    private String phone;
    private String email;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "adresse_Id")
    private Admin admin;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "adresse_Id")
    private List<SocialMedia> socialMediaList = new ArrayList<>();

    public static Adresse from(AdresseDto adresseDto){
        Adresse adresse = new Adresse();

        if(Objects.isNull(adresseDto)){
            return null;
        }else{
            adresse.setId(adresseDto.getId());
            adresse.setAvenue(adresseDto.getAvenue());
            adresse.setEmail(adresseDto.getEmail());
            adresse.setPhone(adresseDto.getPhone());
            adresse.setPays(adresseDto.getAvenue());
            adresse.setVille(adresseDto.getVille());

            adresse.setAdmin(Admin.from(adresseDto.getAdminDto()));

            return adresse;
        }
    }

}
