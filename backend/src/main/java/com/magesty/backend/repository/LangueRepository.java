package com.magesty.backend.repository;

import com.magesty.backend.models.Langue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LangueRepository extends JpaRepository<Langue, UUID> {
}
