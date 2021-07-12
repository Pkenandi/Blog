package com.magesty.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.magesty.backend.models.dto.AdminDto;
import com.magesty.backend.models.dto.ExperienceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Experience implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String realisedAt;
    private LocalDate start;
    private LocalDate expected_end;
    private String description;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "expId")
    private Admin admin;

    public static Experience from(ExperienceDto experienceDto){
        Experience experience = new Experience();

        if(Objects.isNull(experienceDto)){
            return null;
        }else{
            experience.setId(experienceDto.getId());
            experience.setDescription(experienceDto.getDescription());
            experience.setRealisedAt(experienceDto.getRealisedAt());
            experience.setStart(experienceDto.getStart());
            experience.setExpected_end(experienceDto.getExpected_end());

            return experience;
        }
    }
}
