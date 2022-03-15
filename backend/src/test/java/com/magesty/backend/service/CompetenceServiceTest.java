package com.magesty.backend.service;

import com.magesty.backend.models.Competence;
import com.magesty.backend.models.dto.CompetenceDto;
import com.magesty.backend.repository.CompetenceRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CompetenceServiceTest {
    @Autowired private CompetenceService underTest;
    @Mock private CompetenceRepository competenceRepository;

    @BeforeEach
    void setUp() {
        underTest = new CompetenceService(competenceRepository);
    }

    @AfterEach
    void tearDown() {
        underTest = null;
    }

    @Test
    void addCompetence() {
        // given
        Competence expected = new Competence();
        expected.setId(1L);
        expected.setName("skills");
        expected.setNumberOfYear(anyInt());

        // when
        underTest.addCompetence(CompetenceDto.from(expected));

        // then
        ArgumentCaptor<Competence> competenceArgumentCaptor = ArgumentCaptor.forClass(Competence.class);
        verify(competenceRepository).save(competenceArgumentCaptor.capture());
        Competence capturedValue = competenceArgumentCaptor.getValue();

        assertThat(capturedValue).isEqualTo(expected);
    }

    @Test
    void getAll() {
        // given
        underTest.getAll();
        // then
        verify(competenceRepository).findAll();
    }

    @Test
    void getOne() throws Exception {
        // given
        Long id = anyLong();

        // when
        when(competenceRepository.findById(id))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> underTest.getOne(id))
                .isInstanceOf(Exception.class)
                .hasMessageContaining("Competence Not found ");

        verify(competenceRepository).findById(id);
    }
}