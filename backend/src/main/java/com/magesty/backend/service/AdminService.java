package com.magesty.backend.service;

import com.magesty.backend.models.*;
import com.magesty.backend.models.dto.*;
import com.magesty.backend.models.plainDto.PlainAdminDto;
import com.magesty.backend.models.plainDto.PlainSocialMediaDto;
import com.magesty.backend.repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

import static com.magesty.backend.models.dto.AdminDto.*;
import static java.util.Objects.*;

@AllArgsConstructor
@Service
@Transactional
public class AdminService {
    private final AdminRepository adminRepository;

    private final AdresseService adresseService;
    private final EducationService educationService;
    private final CentreInteretService centreInteretService;
    private final CompetenceService competenceService;
    private final ExperienceService experienceService;
    private final LangueService langueService;
    private final ProjetService projetService;
    private final ProfileService profileService;
    private final SocialMediaService socialMediaService;

    // Login and Register
    public AdminDto register(AdminDto administrator) throws Exception {
        if(isNull(administrator)){
            throw new Exception(" Null Object");
        }else{
            return from(this.adminRepository.save(requireNonNull(Admin.from(administrator))));
        }
    }

    public AdminDto login(LoginDto loginDto) throws Exception {
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

    public AdminDto findByUsername(final String username) throws Exception {
        Admin admin = this.adminRepository.findByUsername(username);
        if(Objects.nonNull(admin)){
            return AdminDto.from(admin);
        }else{
            throw new Exception("Null Admin");
        }
    }

                    // Operations
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