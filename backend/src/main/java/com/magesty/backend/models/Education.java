package com.magesty.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.magesty.backend.models.dto.AdminDto;
import com.magesty.backend.models.dto.EducationDto;
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
@Entity( name = "education")
public class Education implements Serializable {
    @Id
    @Column(updatable = false, unique = true, nullable = false)
    @GeneratedValue
    private UUID id;
    private String etablissement;
    private String degree;
    private String average;
    private LocalDate start;
    private LocalDate expected_end;
    private boolean current;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "edu_Id")
    private Admin admin;

    public static Education from(EducationDto educationDto){
        Education education = new Education();

        if(Objects.isNull(educationDto)){
            return null;
        }else {
            education.setId(educationDto.getId());
            education.setDegree(educationDto.getDegree());
            education.setAverage(educationDto.getAverage());
            education.setEtablissement(educationDto.getEtablissement());
            education.setCurrent(educationDto.isCurrent());
            education.setStart(educationDto.getStart());
            education.setExpected_end(educationDto.getExpected_end());

            return education;
        }
    }
}