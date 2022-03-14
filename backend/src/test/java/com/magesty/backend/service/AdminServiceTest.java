package com.magesty.backend.service;

import com.magesty.backend.models.Admin;
import com.magesty.backend.models.Role;
import com.magesty.backend.models.dto.AdminDto;
import com.magesty.backend.repository.AdminRepository;
import com.magesty.backend.repository.RoleRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AdminServiceTest {

    @Mock private AdminRepository adminRepository;
    @Mock private RoleRepository roleRepository;
    private AdminService underTest;

    @BeforeEach
    void setUp() {
        this.underTest = new AdminService(adminRepository, roleRepository);
    }

    @AfterEach
    void tearDown() {
        underTest = null;
    }

    @Test
    void canRegister() throws Exception {
        // given
        AdminDto admin = new AdminDto();
        admin.setUsername("adminTest");
        admin.setId(1L);
        admin.setEmail("admin@gmail.com");
        admin.setPassword("admin777");

        // when
        underTest.register(admin);

        // then
        // verify if the repo was call with "save" and argument of type "Admin"
        ArgumentCaptor<Admin> adminArgumentCaptor = ArgumentCaptor.forClass(Admin.class);
        verify(adminRepository).save(adminArgumentCaptor.capture());

        Admin capturedValue = adminArgumentCaptor.getValue();

        assertThat(capturedValue).isEqualTo(Admin.from(admin));
    }

    @Test
    void willThrowWhenAdminIsNull() throws Exception {
        // given
        AdminDto admin = null;

        // when & then
        assertThatThrownBy(() -> underTest.register(admin)) // throw exception if admin is Null
                .isInstanceOf(Exception.class)
                .hasMessageContaining("Admin Is Null");

        verify(adminRepository, never())
                .save(any());
    }

    @Test
    void canSaveRole() {
        // given
        Role role1 = new Role();
        role1.setId(1L);
        role1.setName("ADMIN");

        // when
        underTest.saveRole(role1);

        // then
        ArgumentCaptor<Role> roleArgumentCaptor = ArgumentCaptor.forClass(Role.class);
        verify(roleRepository).save(roleArgumentCaptor.capture());

        Role capturedRole = roleArgumentCaptor.getValue();
        assertThat(capturedRole).isInstanceOf(Role.class);
    }

    @Test
    @Disabled
    void addLangue() {
    }

    @Test
    @Disabled
    void login() {
    }

    @Test
    @Disabled
    void findByUsername() {
    }

    @Test
    @Disabled
    void addRoleToAdmin() {
    }

    @Test
    @Disabled
    void addAdresse() {
    }

    @Test
    @Disabled
    void addEducation() {
    }

    @Test
    @Disabled
    void addCentreInteret() {
    }

    @Test
    @Disabled
    void addCompetence() {
    }

    @Test
    @Disabled
    void addExperience() {
    }

    @Test
    @Disabled
    void testAddLangue() {
    }

    @Test
    @Disabled
    void addProfile() {
    }

    @Test
    @Disabled
    void addProjet() {
    }

    @Test
    @Disabled
    void addMedia() {
    }
}