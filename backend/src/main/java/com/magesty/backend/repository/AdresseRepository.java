package com.magesty.backend.repository;

import com.magesty.backend.models.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdresseRepository extends JpaRepository<Adresse, UUID> {
}
