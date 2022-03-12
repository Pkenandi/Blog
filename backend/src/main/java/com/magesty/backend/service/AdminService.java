package com.magesty.backend.service;

import com.magesty.backend.models.*;
import com.magesty.backend.models.dto.*;
import com.magesty.backend.repository.AdminRepository;
import com.magesty.backend.repository.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

import static com.magesty.backend.models.dto.AdminDto.*;
import static java.util.Objects.*;

@AllArgsConstructor
@Service
@Transactional
public class AdminService implements UserDetailsService {
    private AdminRepository adminRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    private AdresseService adresseService;
    private EducationService educationService;
    private CentreInteretService centreInteretService;
    private CompetenceService competenceService;
    private ExperienceService experienceService;
    private LangueService langueService;
    private ProjetService projetService;
    private ProfileService profileService;
    private SocialMediaService socialMediaService;

    public AdminService( AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    // Login and Register
    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminDto adminDto = this.findByUsername(username);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        adminDto.getRoles()
                .forEach(role -> authorities
                        .add(new SimpleGrantedAuthority(role.getName())));

        return new User(
                adminDto.getUsername(),
                adminDto.getPassword(),
                true,
                true,
                true,
                true,
               authorities);
    }

    public AdminDto login(LoginRequest loginDto) throws Exception {
        Admin admin = this.adminRepository.findByUsername(loginDto.getUsername());

        if(isNull(admin)){
            return null;
        }else{
            if(loginDto.getPassword().equals(admin.getPassword()) &&
                    loginDto.getUsername().equals(admin.getUsername())){
                return from(admin);
            }else{
                throw new Exception(" Data not found");
            }
        }
    }

    public AdminDto register(AdminDto administrator) throws Exception {
        if(isNull(administrator)){
            throw new Exception(" Admin Is Null");
        }else{
            String encodedPassword = new BCryptPasswordEncoder().encode(administrator.getPassword());

            administrator.setPassword(encodedPassword);
            return from(this.adminRepository.save(requireNonNull(Admin.from(administrator))));
        }
    }

    public AdminDto findByUsername(String username) throws Exception {
        Admin admin = this.adminRepository.findByUsername(username);
        if(nonNull(admin)){
            return AdminDto.from(admin);
        }else{
            throw new Exception("Null Admin");
        }
    }

                    // Operations

    public Role saveRole(Role role){
        return this.roleRepository.save(role);
    }

    public void addRoleToAdmin( String username, String roleName) throws Exception {
        Admin admin = Admin.from(this.findByUsername(username));
        Role role = this.roleRepository.findByName(roleName);

        if(nonNull(admin) && nonNull(role)){
            admin.addRole(role);
        }else {
            throw new Exception(" One of those object is null");
        }
    }

    public AdminDto addAdresse(String username, Long adrId) throws Exception {
        Admin admin = Admin.from(this.findByUsername(username));
        Adresse adresse = Adresse.from(this.adresseService.getOne(adrId));

        if(nonNull(admin) && nonNull(adresse)){
            admin.addAdresse(adresse);
            adresse.setAdmin(admin);
            this.adminRepository.save(admin);

            return from(admin);
        } else{
            throw new Exception(" Adresse is Null ");
        }



    }

    public AdminDto addEducation(String username, Long eduId) throws Exception {
        Admin admin = Admin.from(this.findByUsername(username));
        Education education = Education.from(this.educationService.getOne(eduId));

        if(nonNull(admin) && nonNull(education)){
            admin.addEducation(education);
            education.setAdmin(admin);
            this.adminRepository.save(admin);

            return from(admin);
        }else {
            throw new Exception(" Education is Null ");
        }
    }

    public AdminDto addCentreInteret(String username, Long id) throws Exception {
        Admin admin = Admin.from(this.findByUsername(username));
        CentreInteret centreInteret = CentreInteret.from(this.centreInteretService.getOne(id));

        if(nonNull(admin) && nonNull(centreInteret)){
            admin.addCentreInteret(centreInteret);
            centreInteret.setAdmin(admin);
            this.adminRepository.save(admin);

            return from(admin);
        }else {
            throw new Exception(" Centre d'interet is Null ");
        }
    }

    public AdminDto addCompetence(String username, Long compId) throws Exception {
        Admin admin = Admin.from(this.findByUsername(username));
        Competence competence = Competence.from(this.competenceService.getOne(compId));

        if(nonNull(admin) && nonNull(competence)){
            admin.addCompetence(competence);
            competence.setAdmin(admin);
            this.adminRepository.save(admin);

            return from(admin);
        }else {
            throw new Exception(" Competence is Null ");
        }
    }

    public AdminDto addExperience(String username, Long id) throws Exception {
        Admin admin = Admin.from(this.findByUsername(username));
        Experience experience = Experience.from(this.experienceService.getOne(id));

        if(nonNull(admin) && nonNull(experience)){
            admin.addExperience(experience);
            experience.setAdmin(admin);
            this.adminRepository.save(admin);

            return from(admin);
        }else {
            throw new Exception(" Experience is Null ");
        }
    }

    public AdminDto addLangue(String username, Long id) throws Exception {
        Admin admin = Admin.from(this.findByUsername(username));
        Langue langue = Langue.from(this.langueService.getOne(id));

        if(nonNull(admin) && nonNull(langue)){
            admin.addLangue(langue);
            langue.setAdmin(admin);
            this.adminRepository.save(admin);

            return from(admin);
        }else {
            throw new Exception(" Langue is Null ");
        }
    }

    public AdminDto addProfile(String username, Long id) throws Exception {
        Admin admin = Admin.from(this.findByUsername(username));
        Profile profile = Profile.from(this.profileService.getOne(id));

        if(nonNull(admin) && nonNull(profile)){
            admin.setProfile(profile);
            profile.setAdmin(admin);
            this.adminRepository.save(admin);

            return from(admin);
        }else {
            throw new Exception(" Profile is Null ");
        }
    }

    public AdminDto addProjet(String username, Long id) throws Exception {
        Admin admin = Admin.from(this.findByUsername(username));
        Projet projet = Projet.from(this.projetService.getOne(id));

        if(nonNull(admin) && nonNull(projet)){
            admin.addProjet(projet);
            projet.setAdmin(admin);
            this.adminRepository.save(admin);

            return from(admin);
        }else {
            throw new Exception(" Projet is Null ");
        }
    }

    public AdminDto addMedia(String username, Long id) throws Exception {
        Admin admin = Admin.from(this.findByUsername(username));
        SocialMedia socialMedia = SocialMedia.from(this.socialMediaService.getOne(id));

        if(nonNull(admin) && nonNull(socialMedia)){
            admin.addMedia(socialMedia);
            socialMedia.setAdmin(admin);
            this.adminRepository.save(admin);

            return from(admin);
        }else{
            throw new Exception(" Media not found");
        }
    }
}