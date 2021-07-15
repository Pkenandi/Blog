package com.magesty.backend.service;

import com.magesty.backend.models.Profile;
import com.magesty.backend.models.dto.ProfileDto;
import com.magesty.backend.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

@AllArgsConstructor
@Service
@Transactional
public class ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileDto addProfile(ProfileDto profileDto){
        return ProfileDto.from(this.profileRepository
                .save(requireNonNull(Profile.from(profileDto))));
    }

    public List<ProfileDto> getAll(){
        return this.profileRepository.findAll()
                .stream().map(ProfileDto::from)
                .collect(Collectors.toList());
    }

    public ProfileDto getOne(final Long id) throws Exception {
        return ProfileDto.from(this.profileRepository.findById(id)
                .orElseThrow(() -> new Exception("Profile Not found")));
    }

    public ProfileDto getAdminProfile(final String username) throws Exception {
        return ProfileDto.from(this.profileRepository.findByAdminUsername(username)
                .orElseThrow(() -> new Exception(" Admin profile not found")));
    }
}
