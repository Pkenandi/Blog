package com.magesty.backend.service;

import com.magesty.backend.models.SocialMedia;
import com.magesty.backend.models.dto.SocialMediaDto;
import com.magesty.backend.repository.SocialMediaRepository;
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
class SocialMediaServiceTest {
    @Autowired private SocialMediaService underTest;
    @Mock private SocialMediaRepository socialMediaRepository;

    @BeforeEach
    void setUp() {
        underTest = new SocialMediaService(socialMediaRepository);
    }

    @AfterEach
    void tearDown() {
        underTest = null;
    }

    @Test
    void canAddSocialMedia() {
        // given
        SocialMedia expected = new SocialMedia();
        expected.setId(1L);
        expected.setMediaName("media");
        expected.setSocialUrl("URL");

        // when
        underTest.addSocialMedia(SocialMediaDto.from(expected));

        // then
        ArgumentCaptor<SocialMedia> socialMediaArgumentCaptor = ArgumentCaptor.forClass(SocialMedia.class);
        verify(socialMediaRepository).save(socialMediaArgumentCaptor.capture());
        SocialMedia captorValue = socialMediaArgumentCaptor.getValue();

        assertThat(captorValue).isEqualTo(expected);
    }

    @Test
    void canGetAll() {
        // when
        underTest.getAll();
        // then
        verify(socialMediaRepository).findAll();
    }

    @Test
    void canGetOne() {
        // given
        Long id = anyLong();
        // when
        when(socialMediaRepository.findById(id))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> underTest.getOne(id))
                .isInstanceOf(Exception.class)
                .hasMessageContaining("Media Not found");

        verify(socialMediaRepository).findById(id);
    }
}