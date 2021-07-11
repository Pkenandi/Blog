package com.magesty.backend.repository;

import com.magesty.backend.models.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EducationRepository extends JpaRepository<Education, UUID> {
}
