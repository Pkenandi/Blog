package com.magesty.backend.repository;

import com.magesty.backend.models.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SocialMediaRepository extends JpaRepository<SocialMedia, UUID> {
}
