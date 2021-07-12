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

                    // Operations
    public AdminDto addAdresse(String username, Long adrId){
        Admin admin = this.adminRepository.findByUsername(username);
        AdresseDto adressedto = this.adresseService.getOne(adrId);

        if(isNull(admin) && isNull(adressedto)){
            throw new RuntimeException("Null PointerException");
        }else {
            admin.addAdresse(Adresse
                    .from(adressedto));
            adressedto.setPlainAdminDto(PlainAdminDto
                    .from(admin));

            return from(admin);
        }
    }

    public AdminDto addEducation(String username, Long eduId){
        Admin admin = this.adminRepository.findByUsername(username);
        EducationDto educationDto = this.educationService.getOne(eduId);

        if(isNull(admin) && isNull(educationDto)){
            throw new RuntimeException("Null Point Exception");
        }else {
            admin.addEducation(Education.from(educationDto));
            educationDto.setAdminDto(PlainAdminDto.from(admin));

            return from(admin);
        }
    }

    public AdminDto addCentreInteret(String username, Long id){
        Admin admin = this.adminRepository.findByUsername(username);
        CentreInteretDto centreInteretDto = this.centreInteretService.getOne(id);

        if(isNull(admin) && isNull(centreInteretDto)){
            throw new RuntimeException("Null Point Exception");
        }else {
            admin.addCentreInteret(CentreInteret.from(centreInteretDto));
            centreInteretDto.setAdminDto(PlainAdminDto.from(admin));

            return from(admin);
        }
    }

    public AdminDto addCompetence(String username, Long compId){
        Admin admin = this.adminRepository.findByUsername(username);
        CompetenceDto competenceDto = this.competenceService.getOne(compId);

        if(isNull(admin) && isNull(competenceDto)){
            throw new RuntimeException("Null Point Exception");
        }else {
            admin.addCompetence(Competence.from(competenceDto));
            competenceDto.setAdminDto(PlainAdminDto.from(admin));

            return from(admin);
        }
    }

    public AdminDto addExperience(String username, Long id){
        Admin admin = this.adminRepository.findByUsername(username);
        ExperienceDto experienceDto = this.experienceService.getOne(id);

        if(isNull(admin) && isNull(experienceDto)){
            throw new RuntimeException("Null Point Exception");
        }else {
            admin.addExperience(Experience.from(experienceDto));
            experienceDto.setAdminDto(PlainAdminDto.from(admin));

            return from(admin);
        }
    }

    public AdminDto addLangue(String username, Long id){
        Admin admin = this.adminRepository.findByUsername(username);
        LangueDto langueDto = this.langueService.getOne(id);

        if(isNull(admin) && isNull(langueDto)){
            throw new RuntimeException("Null Point Exception");
        }else {
            admin.addLangue(Langue.from(langueDto));
            langueDto.setAdminDto(PlainAdminDto.from(admin));

            return from(admin);
        }
    }

    public AdminDto addProfile(String username, Long id){
        Admin admin = this.adminRepository.findByUsername(username);
        ProfileDto profileDto = this.profileService.getOne(id);

        if(isNull(admin) && isNull(profileDto)){
            throw new RuntimeException("Null Point Exception");
        }else {
            admin.setProfile(Profile.from(profileDto));
            profileDto.setAdminDto(PlainAdminDto.from(admin));

            return from(admin);
        }
    }

    public AdminDto addProjet(String username, Long id){
        Admin admin = this.adminRepository.findByUsername(username);
        ProjetDto projetDto = this.projetService.getOne(id);

        if(isNull(admin) && isNull(projetDto)){
            throw new RuntimeException("Null Point Exception");
        }else {
            admin.addProjet(Projet.from(projetDto));
            projetDto.setAdminDto(PlainAdminDto.from(admin));

            return from(admin);
        }
    }

//    public AdminDto addSocialMedia(Long adrId, Long mediaId){
//        AdresseDto adresseDto = this.adresseService.getOne(adrId);
//        SocialMediaDto socialMediaDto = this.socialMediaService.getOne(mediaId);
//
//        if(isNull(adresseDto) && isNull(socialMediaDto)){
//            throw new RuntimeException("Null Point Exception");
//        }else {
//
//            adresseDto.setPlainSocialMediaDtos(PlainSocialMediaDto.from());
//            socialMediaDto
//
//            return from(admin);
//        }
//    }

}