package com.magesty.backend.repository;

import com.magesty.backend.models.Admin;
import com.magesty.backend.models.Profile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyString;

@DataJpaTest
class ProfileRepositoryTest {
    @Autowired ProfileRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void canFindProfileByAdminUsername() {
        // given
        Profile expected = new Profile();

        expected.setId(1L);
        expected.setContent("content");
        expected.setAdmin(null);
        underTest.save(expected);


        // when
        Optional<Profile> profileByAdminUsername = underTest.findProfileByAdminUsername(anyString());

        // then
        assertThat(profileByAdminUsername).isEqualTo(expected);
    }
}