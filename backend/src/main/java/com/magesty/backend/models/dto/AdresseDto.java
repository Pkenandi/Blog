package com.magesty.backend.models.dto;

import com.magesty.backend.models.Adresse;
import com.magesty.backend.models.SocialMedia;
import com.magesty.backend.models.plainDto.PlainAdminDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdresseDto {
    private Long id;
    private String avenue;
    private String pays;
    private String ville;
    private String phone;
    private String email;

    private PlainAdminDto plainAdminDto;

    public static AdresseDto from(Adresse adresse) {
        AdresseDto adresseDto = new AdresseDto();

        if (Objects.isNull(adresse)) {
            return null;
        } else {
            adresseDto.setId(adresse.get_id());
            adresseDto.setEmail(adresse.getEmail());
            adresseDto.setPhone(adresse.getPhone());
            adresseDto.setPays(adresse.getPays());
            adresseDto.setAvenue(adresse.getAvenue());
            adresseDto.setVille(adresse.getVille());

            adresseDto.setPlainAdminDto(PlainAdminDto.from(adresse.getAdmin()));

            return adresseDto;
        }
    }
}
