package com.magesty.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.magesty.backend.models.dto.AdminDto;
import com.magesty.backend.models.dto.CentreInteretDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Admin implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, updatable = false)
    private String username;
    @Column(nullable = false, updatable = false, unique = true)
    private String email;
    private String password;

    /* Relationships */
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(cascade = ALL,fetch = LAZY)
    @JoinColumn(name = "admin_Id")
    private List<CentreInteret> centreInteretList = new ArrayList<>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(cascade = ALL,fetch = LAZY)
    @JoinColumn(name = "profile_Id")
    private Profile profile;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(cascade = ALL,fetch = LAZY)
    @JoinColumn(name = "admin_Id")
    private List<Adresse> adresseList = new ArrayList<>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(cascade = ALL,fetch = LAZY)
    @JoinColumn(name = "admin_Id")
    private List<Competence> competenceList = new ArrayList<>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(cascade = ALL,fetch = LAZY)
    @JoinColumn(name = "admin_Id")
    private List<Projet> projetList = new ArrayList<>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(cascade = ALL,fetch = LAZY)
    @JoinColumn(name = "admin_Id")
    private List<Langue> langueList = new ArrayList<>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(cascade = ALL,fetch = LAZY)
    @JoinColumn(name = "admin_Id")
    private List<Experience> experienceList = new ArrayList<>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(cascade = ALL,fetch = LAZY)
    @JoinColumn(name = "admin_Id")
    private List<Education> educationList = new ArrayList<>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(cascade = ALL,fetch = LAZY)
    @JoinColumn(name = "admin_Id")
    private List<SocialMedia> socialMediaList = new ArrayList<>();


    // Methods
    public static Admin from(AdminDto adminDto) {
        Admin admin = new Admin();

        if (Objects.isNull(adminDto)) {
            return null;
        } else {
            admin.setId(adminDto.getId());
            admin.setEmail(adminDto.getEmail());
            admin.setUsername(adminDto.getUsername());
            admin.setPassword(adminDto.getPassword());
            admin.setProfile(Profile.from(adminDto.getProfileDto()));
            admin.setAdresseList(adminDto.getAdresseDtoList().stream().map(Adresse::from).collect(Collectors.toList()));
            admin.setCentreInteretList(adminDto.getCentreInteretDtoList().stream().map(CentreInteret::from).collect(Collectors.toList()));
            admin.setCompetenceList(adminDto.getCompetenceDtoList().stream().map(Competence::from).collect(Collectors.toList()));
            admin.setEducationList(adminDto.getEducationDtoList().stream().map(Education::from).collect(Collectors.toList()));
            admin.setExperienceList(adminDto.getExperienceDtoList().stream().map(Experience::from).collect(Collectors.toList()));
            admin.setProjetList(adminDto.getProjetDtoList().stream().map(Projet::from).collect(Collectors.toList()));
            admin.setLangueList(adminDto.getLangueDtoList().stream().map(Langue::from).collect(Collectors.toList()));
            admin.setSocialMediaList(adminDto.getSocialMediaDtoList().stream().map(SocialMedia::from).collect(Collectors.toList()));

            return admin;
        }
    }

    public void addEducation(Education education) {
        this.educationList.add(education);
    }

    public void addCentreInteret(CentreInteret centreInteret) {
        this.centreInteretList.add(centreInteret);
    }

    public void addExperience(Experience experience) {
        this.experienceList.add(experience);
    }

    public void addLangue(Langue langue) {
        this.langueList.add(langue);
    }

    public void addProjet(Projet projet) {
        this.projetList.add(projet);
    }

    public void addCompetence(Competence competence) {
        this.competenceList.add(competence);
    }

    public void addAdresse(Adresse adresse) {
        this.adresseList.add(adresse);
    }

    public void addMedia(SocialMedia socialMedia){
        this.socialMediaList.add(socialMedia);
    }

}