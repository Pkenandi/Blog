package com.magesty.backend.models.dto;

import com.magesty.backend.models.CentreInteret;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CentreInteretDto {
    private UUID id;
    private String name;
    private String description;
    private AdminDto adminDto;

    public static CentreInteretDto from(CentreInteret centreInteret){
        CentreInteretDto centreInteretDto = new CentreInteretDto();

        if(Objects.isNull(centreInteret)){
            return null;
        }else{
            centreInteretDto.setId(centreInteret.getId());
            centreInteretDto.setName(centreInteret.getName());
            centreInteretDto.setDescription(centreInteret.getDescription());
            centreInteretDto.setAdminDto(AdminDto.from(centreInteret.getAdmin()));

            return centreInteretDto;
        }
    }
}
