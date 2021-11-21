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

@NoArgsConstructor
@AllArgsConstructor
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
    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();

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

        return Optional.ofNullable(adminDto)
                .map( admins -> {
                    admin.setId(admins.getId());
                    admin.setEmail(admins.getEmail());
                    admin.setUsername(admins.getUsername());
                    admin.setPassword(admins.getPassword());
                    admin.setProfile(Profile.from(admins.getProfileDto()));
                    admin.setRoles(admins.getRoles());
                    admin.setAdresseList(admins.getAdresseDtoList().stream().map(Adresse::from).collect(Collectors.toList()));
                    admin.setCentreInteretList(admins.getCentreInteretDtoList().stream().map(CentreInteret::from).collect(Collectors.toList()));
                    admin.setCompetenceList(admins.getCompetenceDtoList().stream().map(Competence::from).collect(Collectors.toList()));
                    admin.setEducationList(admins.getEducationDtoList().stream().map(Education::from).collect(Collectors.toList()));
                    admin.setExperienceList(admins.getExperienceDtoList().stream().map(Experience::from).collect(Collectors.toList()));
                    admin.setProjetList(admins.getProjetDtoList().stream().map(Projet::from).collect(Collectors.toList()));
                    admin.setLangueList(admins.getLangueDtoList().stream().map(Langue::from).collect(Collectors.toList()));
                    admin.setSocialMediaList(admins.getSocialMediaDtoList().stream().map(SocialMedia::from).collect(Collectors.toList()));

                    return admin;
                }).orElse( null);
    }

    public void addRole(Role role){
        this.roles.add(role);
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