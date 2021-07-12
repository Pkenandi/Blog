package com.magesty.backend.repository;

import com.magesty.backend.models.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Long> {
}
