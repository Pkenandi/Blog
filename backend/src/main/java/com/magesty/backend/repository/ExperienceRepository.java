package com.magesty.backend.repository;

import com.magesty.backend.models.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExperienceRepository extends JpaRepository<Experience, UUID> {
}
