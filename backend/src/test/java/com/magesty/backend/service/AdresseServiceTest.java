package com.magesty.backend.service;

import com.magesty.backend.models.Admin;
import com.magesty.backend.models.Adresse;
import com.magesty.backend.models.dto.AdresseDto;
import com.magesty.backend.repository.AdresseRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AdresseServiceTest {
    @Autowired private AdresseService underTest;
    @Mock private AdresseRepository adresseRepository;

    @BeforeEach
    void setUp() {
        underTest = new AdresseService(adresseRepository);
    }

    @AfterEach
    void tearDown() {
        underTest = null;
    }

    @Test
    void canAddAdresse() {
        // given
        Adresse givenAdresse = new Adresse();
        givenAdresse.set_id(1L);
        givenAdresse.setVille("Monastir");
        givenAdresse.setPays("Tunisia");
        givenAdresse.setAvenue("Mpeti");
        givenAdresse.setEmail("adresse@gmail.com");
        givenAdresse.setPhone("00123456789");

        // when
        underTest.addAdresse(AdresseDto.from(givenAdresse));

        // then
        ArgumentCaptor<Adresse> adresseArgumentCaptor = ArgumentCaptor.forClass(Adresse.class);
        verify(adresseRepository).save(adresseArgumentCaptor.capture());
        Adresse adresseValue = adresseArgumentCaptor.getValue();

        assertThat(adresseValue).isInstanceOf(givenAdresse.getClass());
    }

    @Test
    void getAll() {
        // when
        underTest.getAll();
        // then
        verify(adresseRepository).findAll();
    }

    @Test
    void getOne() throws Exception {
        // given
        Long id = anyLong();
        // when
        when(adresseRepository.findById(id))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> underTest.getOne(id))
                .isInstanceOf(Exception.class)
                .hasMessageContaining(" Adresse Not found");

        verify(adresseRepository).findById(id);
    }
}