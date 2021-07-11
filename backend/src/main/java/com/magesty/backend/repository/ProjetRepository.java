package com.magesty.backend.repository;

import com.magesty.backend.models.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjetRepository extends JpaRepository<Projet, UUID> {
}
