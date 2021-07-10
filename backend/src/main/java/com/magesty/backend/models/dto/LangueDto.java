package com.magesty.backend.models.dto;

import com.magesty.backend.models.Langue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LangueDto {
    private UUID id;
    private String name;
    private String level;
    private AdminDto adminDto;

    public static LangueDto from(Langue langue){
        LangueDto langueDto = new LangueDto();

        if(Objects.isNull(langue)){
            return null;
        }else{
            langueDto.setId(langue.getId());
            langueDto.setName(langue.getName());
            langueDto.setLevel(langue.getLevel());
            langueDto.setAdminDto(AdminDto.from(langue.getAdmin()));

            return langueDto;
        }
    }
}
