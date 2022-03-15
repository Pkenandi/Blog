package com.magesty.backend.service;

import com.magesty.backend.models.Projet;
import com.magesty.backend.models.dto.ProjetDto;
import com.magesty.backend.repository.ProjetRepository;
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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjetServiceTest {
    @Autowired private ProjetService underTest;
    @Mock private ProjetRepository projetRepository;

    @BeforeEach
    void setUp() {
        underTest = new ProjetService(projetRepository);
    }

    @AfterEach
    void tearDown() {
        underTest = null;
    }

    @Test
    void canAddProjet() {
        // given
        Projet expected = new Projet();
        expected.setId(1L);
        expected.setCurrent(true);
        expected.setProjetName("name");
        expected.setDescription("description");
        expected.setEnd(LocalDate.of(2010,10,8));
        expected.setStart(LocalDate.of(2010,10,8));
        expected.setSeulOuGroup("seul");
        expected.setImageUrl("URL");
        expected.setTechUsed("Spring");

        // when
        underTest.addProjet(ProjetDto.from(expected));

        // then
        ArgumentCaptor<Projet> projetArgumentCaptor = ArgumentCaptor.forClass(Projet.class);
        verify(projetRepository).save(projetArgumentCaptor.capture());
        Projet captorValue = projetArgumentCaptor.getValue();

        assertThat(captorValue).isEqualTo(expected);
    }

    @Test
    void canGetAll() {
        // when
        underTest.getAll();
        // then
        verify(projetRepository).findAll();
    }

    @Test
    void canGetOne() {
        // given
        Long id = anyLong();
        // when
        when(projetRepository.findById(id))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> underTest.getOne(id))
                .isInstanceOf(Exception.class)
                .hasMessageContaining("Projet Not found");

        verify(projetRepository).findById(id);
    }
}