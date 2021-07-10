package com.magesty.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "admin")
@Data
public class Admin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, unique = true, nullable = false)
    private Long id;
    @Column(nullable = false, unique = true, updatable = false)
    private String adminId;
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


    private List<Adresse> adresseList = new ArrayList<>();
    private List<Competence> competenceList = new ArrayList<>();
    private List<Projet> projetList = new ArrayList<>();
    private List<Langue> langueList = new ArrayList<>();
    private List<Experience> experienceList = new ArrayList<>();
    private List<CentreInteret> centreInteretList = new ArrayList<>();
    private List<Education> educationList = new ArrayList<>();

}
