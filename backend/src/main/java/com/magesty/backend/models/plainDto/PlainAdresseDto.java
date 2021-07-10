package com.magesty.backend.models.plainDto;

import com.magesty.backend.models.Adresse;
import com.magesty.backend.models.dto.AdresseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlainAdresseDto {
    private UUID id;
    private String avenue;
    private String pays;
    private String ville;
    private String phone;
    private String email;

    public static PlainAdresseDto from(Adresse adresse){
        PlainAdresseDto adresseDto = new PlainAdresseDto();

        if(Objects.isNull(adresse)){
            return null;
        }else{
            adresseDto.setId(adresse.getId());
            adresseDto.setEmail(adresse.getEmail());
            adresseDto.setPhone(adresse.getPhone());
            adresseDto.setPays(adresse.getPays());
            adresseDto.setAvenue(adresse.getAvenue());
            adresseDto.setVille(adresse.getVille());

            return adresseDto;
        }
    }
}
