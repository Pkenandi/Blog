package com.magesty.backend.service;

import com.magesty.backend.models.Langue;
import com.magesty.backend.models.dto.LangueDto;
import com.magesty.backend.repository.LangueRepository;
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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LangueServiceTest {
    @Autowired private LangueService underTest;
    @Mock private LangueRepository langueRepository;

    @BeforeEach
    void setUp() {
        underTest = new LangueService(langueRepository);
    }

    @AfterEach
    void tearDown() {
        underTest = null;
    }

    @Test
    void addLangue() {
        // given
        Langue expected = new Langue();
        expected.setId(1L);
        expected.setLevel("level");
        expected.setName("name");

        // when
        underTest.addLangue(LangueDto.from(expected));

        // then
        ArgumentCaptor<Langue> langueArgumentCaptor = ArgumentCaptor.forClass(Langue.class);
        verify(langueRepository).save(langueArgumentCaptor.capture());
        Langue captorValue = langueArgumentCaptor.getValue();

        assertThat(captorValue).isEqualTo(expected);
    }

    @Test
    void getAll() {
        // when
        underTest.getAll();
        // then
        verify(langueRepository).findAll();
    }

    @Test
    void getOne() {
        // given
        Long id = anyLong();
        // when
        when(langueRepository.findById(id))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> underTest.getOne(id))
                .isInstanceOf(Exception.class)
                .hasMessageContaining("Langue Not found ");

        verify(langueRepository).findById(id);
    }
}