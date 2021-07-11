package com.magesty.backend.repository;

import com.magesty.backend.models.CentreInteret;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CentreInteretRepository extends JpaRepository<CentreInteret, UUID> {
}
