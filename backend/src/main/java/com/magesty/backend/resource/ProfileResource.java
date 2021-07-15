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

@AllArgsConstructor
@RestController
@RequestMapping("/api/profile/")
public class ProfileResource {
    private final ProfileService profileService;
    public static final String DIRECTORY = System.getProperty("user.home") + ("/Documents/Mes_Projets/Blog/frontend-ng/src/assets/image/");

    @PostMapping(value = "add")
    public ResponseEntity<ProfileDto> addProfile(@RequestBody final ProfileDto profileDto) {
        return new ResponseEntity<>(this.profileService.addProfile(profileDto), HttpStatus.OK);
    }

    @GetMapping(value = "all")
    public ResponseEntity<List<ProfileDto>> getAll(){
        return new ResponseEntity<>(this.profileService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ProfileDto> getOne(@PathVariable final Long id) throws Exception {
        return new ResponseEntity<>(this.profileService.getOne(id), HttpStatus.OK);
    }

    @GetMapping(value = "{username}/profile")
    public ResponseEntity<ProfileDto> getAdminProfile(@PathVariable final String username) throws Exception {
        return new ResponseEntity<>(this.profileService.getAdminProfile(username), HttpStatus.OK);
    }

    @GetMapping(value = "{id}/imgUrl")
    public ResponseEntity<ProfileDto> setProfilePicture(@PathVariable final Long id,
                                                        @RequestParam("files")List<MultipartFile> multipartFiles) throws Exception {
        List<String> fileNames = new ArrayList<>();
        ProfileDto profileDto = this.profileService.getOne(id);

        for(MultipartFile file: multipartFiles){
            String filename = StringUtils.cleanPath(requireNonNull(file.getOriginalFilename()));
            Path fileStorage = get(DIRECTORY, filename)
                    .toAbsolutePath()
                    .normalize();
            copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
            fileNames.add(filename);
        }

        profileDto.setImgUrl(fileNames.get((0)));
        return new ResponseEntity<>(this.profileService.addProfile(profileDto), HttpStatus.OK);
    }
}
