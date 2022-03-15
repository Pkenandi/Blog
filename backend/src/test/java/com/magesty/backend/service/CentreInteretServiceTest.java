package com.magesty.backend.service;

import com.magesty.backend.models.CentreInteret;
import com.magesty.backend.models.dto.CentreInteretDto;
import com.magesty.backend.repository.CentreInteretRepository;
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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CentreInteretServiceTest {
    @Mock private CentreInteretRepository centreInteretRepository;
    @Autowired private CentreInteretService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CentreInteretService(centreInteretRepository);
    }

    @AfterEach
    void tearDown() {
        underTest = null;
    }

    @Test
    void addCentreInteret() {
        // given
        CentreInteret expected = new CentreInteret();
        expected.setName("interest");
        expected.setDescription("an interest");
        expected.set_id(anyLong());

        // when
        underTest.addCentreInteret(CentreInteretDto.from(expected));

        // then
        ArgumentCaptor<CentreInteret> centreInteretArgumentCaptor = ArgumentCaptor.forClass(CentreInteret.class);
        verify(centreInteretRepository).save(centreInteretArgumentCaptor.capture());
        CentreInteret capturedValue = centreInteretArgumentCaptor.getValue();

        assertThat(capturedValue).isEqualTo(expected);
    }

    @Test
    void getAll() {
        // given
        underTest.getAll();
        // then
        verify(centreInteretRepository).findAll();
    }

    @Test
    void getOne() throws Exception {
        // given
        Long id = anyLong();
        // when
        when(centreInteretRepository.findById(id))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> underTest.getOne(id))
                .isInstanceOf(Exception.class)
                .hasMessageContaining(" Not found");

        verify(centreInteretRepository).findById(id);
    }
}