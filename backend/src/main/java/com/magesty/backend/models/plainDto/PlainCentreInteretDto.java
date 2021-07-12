package com.magesty.backend.models.plainDto;

import com.magesty.backend.models.CentreInteret;
import com.magesty.backend.models.dto.AdminDto;
import com.magesty.backend.models.dto.CentreInteretDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlainCentreInteretDto {
    private Long id;
    private String name;
    private String description;

    public static PlainCentreInteretDto from(CentreInteret centreInteret){
        PlainCentreInteretDto centreInteretDto = new PlainCentreInteretDto();

        if(Objects.isNull(centreInteret)){
            return null;
        }else{
            centreInteretDto.setId(centreInteret.get_id());
            centreInteretDto.setName(centreInteret.getName());
            centreInteretDto.setDescription(centreInteret.getDescription());

            return centreInteretDto;
        }
    }
}
