package com.magesty.backend.repository;

import com.magesty.backend.models.Admin;
import com.magesty.backend.models.dto.AdminDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class AdminRepositoryTest {

    private final AdminRepository underTest;

    @Autowired
    AdminRepositoryTest(AdminRepository underTest) {
        this.underTest = underTest;
    }

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @ParameterizedTest
    @CsvSource({"adminTest, true", "adminTests, true"})
    void ifAdminExistsByUsername(final String username, boolean exist) {
        // given
        AdminDto admin = new AdminDto();

        admin.setUsername(username);
        admin.setId(1L);
        admin.setEmail("admin@gmail.com");
        admin.setPassword("admin777");
        underTest.save(Admin.from(admin));

        // when
        Admin byUsername = underTest.findByUsername(username);

        // then
        assertThat(byUsername.getUsername()).isEqualTo(Admin.from(admin).getUsername());
    }

    @ParameterizedTest
    @CsvSource({"adminTest, true", "adminTests, false"})
    void existByUsername(String username, boolean exist) {
        // given
        AdminDto admin = new AdminDto();

        admin.setUsername(username);
        admin.setId(1L);
        admin.setEmail("admin@gmail.com");
        admin.setPassword("admin777");
        underTest.save(Admin.from(admin));

        // when
        boolean ifExist = underTest.existByUsername(username);

        // then
        assertThat(ifExist).isEqualTo(exist);
    }
}