package com.magesty.backend.models.dto;

import com.magesty.backend.models.Langue;
import com.magesty.backend.models.plainDto.PlainAdminDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LangueDto {
    private Long id;
    private String name;
    private String level;
    private PlainAdminDto adminDto;

    public static LangueDto from(Langue langue){
        LangueDto langueDto = new LangueDto();

        if(langue != null){
            langueDto.setId(langue.getId());
            langueDto.setName(langue.getName());
            langueDto.setLevel(langue.getLevel());
            langueDto.setAdminDto(PlainAdminDto.from(langue.getAdmin()));

            return langueDto;
        }else{
            return null;
        }
    }
}
