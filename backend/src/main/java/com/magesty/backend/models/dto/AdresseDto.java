package com.magesty.backend.models.dto;

import com.magesty.backend.models.Admin;
import com.magesty.backend.models.Adresse;
import com.magesty.backend.models.SocialMedia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdresseDto {
    private UUID id;
    private String avenue;
    private String pays;
    private String ville;
    private String phone;
    private String email;

    private AdminDto adminDto;
    private List<SocialMediaDto> socialMediaDtoList = new ArrayList<>();

    public static AdresseDto from(Adresse adresse){
        AdresseDto adresseDto = new AdresseDto();

        if(Objects.isNull(adresse)){
            return null;
        }else{
            adresseDto.setId(adresse.getId());
            adresseDto.setEmail(adresse.getEmail());
            adresseDto.setPhone(adresse.getPhone());
            adresseDto.setPays(adresse.getPays());
            adresseDto.setAvenue(adresse.getAvenue());
            adresseDto.setVille(adresse.getVille());

            adresseDto.setAdminDto(AdminDto.from(adresse.getAdmin()));

            return adresseDto;
        }
    }
}
