package com.magesty.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.magesty.backend.models.dto.AdminDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "admin")
@Data
public class Admin implements Serializable {
    @Id
    @Column(updatable = false, unique = true, nullable = false)
    @GeneratedValue
    private UUID id;
    @Column(nullable = false, unique = true, updatable = false)
    private String username;
    @Column(nullable = false, updatable = false, unique = true)
    private String email;
    private String password;

    /* Relationships */
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn( name = "profile_Id")
    private Profile profile;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "admin_Id")
    private List<Adresse> adresseList = new ArrayList<>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "admin_Id")
    private List<Competence> competenceList = new ArrayList<>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "admin_Id")
    private List<Projet> projetList = new ArrayList<>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "admin_Id")
    private List<Langue> langueList = new ArrayList<>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "admin_Id")
    private List<Experience> experienceList = new ArrayList<>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "admin_Id")
    private List<CentreInteret> centreInteretList = new ArrayList<>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "admin_Id")
    private List<Education> educationList = new ArrayList<>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "admin_Id")
    private List<SocialMedia> socialMediaList = new ArrayList<>();

    // Methods
    public static Admin from(AdminDto adminDto){
        Admin admin = new Admin();

        if(Objects.isNull(adminDto)){
            return null;
        }else{
            admin.setId(adminDto.getId());
            admin.setEmail(adminDto.getEmail());
            admin.setUsername(adminDto.getUsername());
            admin.setPassword(adminDto.getPassword());

            return admin;
        }
    }

    public void addSocialMedia(SocialMedia socialMedia){
        this.socialMediaList.add(socialMedia);
    }
    public void addEducation(Education education){
        this.educationList.add(education);
    }
    public void addCentreInteret(CentreInteret centreInteret){
        this.centreInteretList.add(centreInteret);
    }
    public void addExperience(Experience experience){
        this.experienceList.add(experience);
    }
    public void addLangue(Langue langue){
        this.langueList.add(langue);
    }
    public void addProjet(Projet projet){
        this.projetList.add(projet);
    }
    public void addCompetence(Competence competence){
        this.competenceList.add(competence);
    }
    public void addAdresse(Adresse adresse){
        this.adresseList.add(adresse);
    }

}
