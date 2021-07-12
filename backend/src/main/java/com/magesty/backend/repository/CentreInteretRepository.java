package com.magesty.backend.repository;

import com.magesty.backend.models.CentreInteret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CentreInteretRepository extends JpaRepository<CentreInteret, Long> {
}
