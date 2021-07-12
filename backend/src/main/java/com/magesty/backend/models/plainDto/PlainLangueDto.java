package com.magesty.backend.models.plainDto;

import com.magesty.backend.models.Langue;
import com.magesty.backend.models.dto.LangueDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlainLangueDto {
    private Long id;
    private String name;
    private String level;

    public static PlainLangueDto from(Langue langue){
        PlainLangueDto langueDto = new PlainLangueDto();

        if(Objects.isNull(langue)){
            return null;
        }else{
            langueDto.setId(langue.getId());
            langueDto.setName(langue.getName());
            langueDto.setLevel(langue.getLevel());

            return langueDto;
        }
    }
}
