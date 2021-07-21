package com.magesty.backend.resource;

import com.magesty.backend.models.dto.ProfileDto;
import com.magesty.backend.service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static java.util.Objects.requireNonNull;
import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/profile/")
public class ProfileResource {
    private final ProfileService profileService;

    @PostMapping(value = "add", produces = {"application/json", "application/xml"}
            ,consumes = {"application/x-www-form-urlencoded"})
    public ResponseEntity<ProfileDto> addProfile(final ProfileDto profileDto) {
        return new ResponseEntity<>(this.profileService.addProfile(profileDto), OK);
    }

    @GetMapping(value = "all")
    public ResponseEntity<List<ProfileDto>> getAll(){
        return new ResponseEntity<>(this.profileService.getAll(), OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ProfileDto> getOne(@PathVariable final Long id) throws Exception {
        return new ResponseEntity<>(this.profileService.getOne(id), OK);
    }

    @GetMapping(value = "{username}/profile")
    public ResponseEntity<ProfileDto> getAdminProfile(@PathVariable final String username) throws Exception {
        return new ResponseEntity<>(this.profileService.getAdminProfile(username), OK);
    }
}
