package com.magesty.backend.repository;

import com.magesty.backend.models.Competence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompetenceRepository extends JpaRepository<Competence, UUID> {
}
