package com.magesty.backend.repository;

import com.magesty.backend.models.Role;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RoleRepositoryTest {
    @Autowired
    private RoleRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @ParameterizedTest
    @CsvSource({"ADMIN, ADMIN", "USER, USER", "SUPER-ADMIN, ADMIN"})
    void existByName(String givenRole, String expected) {
        // given
        Role role1 = new Role();
        role1.setName(givenRole);
        role1.setId(1L);
        underTest.save(role1);

        // when
        Role roleByName = underTest.findByName(givenRole);

        // then
        assertThat(roleByName.getName()).isEqualTo(expected);
    }
}