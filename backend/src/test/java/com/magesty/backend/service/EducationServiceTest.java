package com.magesty.backend.service;

import com.magesty.backend.models.Education;
import com.magesty.backend.models.dto.EducationDto;
import com.magesty.backend.repository.EducationRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EducationServiceTest {
    @Autowired private EducationService underTest;
    @Mock private EducationRepository educationRepository;

    @BeforeEach
    void setUp() {
        underTest = new EducationService(educationRepository);
    }

    @AfterEach
    void tearDown() {
        underTest = null;
    }

    @Test
    void addEducation() {
        // given
        Education expected = new Education();
        expected.setStart(LocalDate.of(2000, 12, 25));
        expected.setExpected_end(LocalDate.of(2000, 12, 25));
        expected.setAverage("54");
        expected.setCurrent("true");
        expected.setDegree(" L3 ");
        expected.setEtablissement("FSM");
        expected.setImage("image");
        expected.setId(1L);
        expected.setSection("info");

        // when
        underTest.addEducation(EducationDto.from(expected));

        // then
        ArgumentCaptor<Education> educationArgumentCaptor = ArgumentCaptor.forClass(Education.class);
        verify(educationRepository).save(educationArgumentCaptor.capture());
        Education capturedValue = educationArgumentCaptor.getValue();

        assertThat(capturedValue).isEqualTo(expected);
    }

    @Test
    void getAll() {
        //given
        underTest.getAll();

        // then
        verify(educationRepository).findAll();
    }

    @Test
    void getOne() {
        // given
        Long id = anyLong();

        // when
        when(educationRepository.findById(id))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> underTest.getOne(id))
                .isInstanceOf(Exception.class)
                .hasMessageContaining(" Education Not found ");

        verify(educationRepository).findById(id);
    }
}