package com.magesty.backend.service;

import com.magesty.backend.models.Langue;
import com.magesty.backend.models.Profile;
import com.magesty.backend.models.dto.ProfileDto;
import com.magesty.backend.repository.ProfileRepository;
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
class ProfileServiceTest {
    @Autowired private ProfileService underTest;
    @Mock private ProfileRepository profileRepository;

    @BeforeEach
    void setUp() {
        underTest = new ProfileService(profileRepository);
    }

    @AfterEach
    void tearDown() {
        underTest = null;
    }

    @Test
    void canAddProfile() {
        // given
        Profile expected = new Profile();
        expected.setId(1L);
        expected.setContent("content");

            // when
            underTest.addProfile(ProfileDto.from(expected));

            // then
            ArgumentCaptor<Profile> profileArgumentCaptor = ArgumentCaptor.forClass(Profile.class);
            verify(profileRepository).save(profileArgumentCaptor.capture());
            Profile captorValue = profileArgumentCaptor.getValue();

            assertThat(captorValue).isEqualTo(expected);
    }

    @Test
    void canGetAll() {
        // when
        underTest.getAll();
        // then
        verify(profileRepository).findAll();
    }

    @Test
    void canGetOne() {
        // given
        Long id = anyLong();
        // when
        when(profileRepository.findById(id))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> underTest.getOne(id))
                .isInstanceOf(Exception.class)
                .hasMessageContaining("Profile Not found");

        verify(profileRepository).findById(id);
    }

    @Test
    void canGetAdminProfile() {
        // given
        String username = anyString();

        // when
        when(profileRepository.findProfileByAdminUsername(username))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> underTest.getAdminProfile(username))
                .isInstanceOf(Exception.class)
                .hasMessageContaining(" Admin profile not found ");

        verify(profileRepository).findProfileByAdminUsername(username);

    }
}