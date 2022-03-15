package com.magesty.backend.service;

import com.magesty.backend.models.Adresse;
import com.magesty.backend.models.Experience;
import com.magesty.backend.models.dto.AdresseDto;
import com.magesty.backend.models.dto.ExperienceDto;
import com.magesty.backend.repository.ExperienceRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExperienceServiceTest {
    @Autowired private ExperienceService underTest;
    @Mock private ExperienceRepository experienceRepository;

    @BeforeEach
    void setUp() {
        underTest = new ExperienceService(experienceRepository);
    }

    @AfterEach
    void tearDown() {
        underTest = null;
    }

    @Test
    void addExperience() {
        // given
        Experience expected = new Experience();
        expected.setExpected_end(LocalDate.of(2000, 12, 25));
        expected.setStart(LocalDate.of(2000, 12, 25));
        expected.setRealisedAt("Somewhere");
        expected.setId(1L);
        expected.setDescription("description");

        // when
        underTest.addExperience(ExperienceDto.from(expected));

        // then
        ArgumentCaptor<Experience> experienceArgumentCaptor = ArgumentCaptor.forClass(Experience.class);
        verify(experienceRepository).save(experienceArgumentCaptor.capture());
        Experience experienceValue = experienceArgumentCaptor.getValue();

        assertThat(experienceValue).isEqualTo(expected);
    }

    @Test
    void getAll() {
        // when
        underTest.getAll();
        // then
        verify(experienceRepository).findAll();
    }

    @Test
    void getOne() {
        // given
        Long id = anyLong();
        // when
        when(experienceRepository.findById(id))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> underTest.getOne(id))
                .isInstanceOf(Exception.class)
                .hasMessageContaining(" Experience Not found ");

        verify(experienceRepository).findById(id);
    }
}