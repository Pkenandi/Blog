package com.magesty.backend.resource;

import com.magesty.backend.models.dto.ProfileDto;
import com.magesty.backend.service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/profile/")
public class ProfileResource {
    private final ProfileService profileService;

    @PostMapping(value = "add")
    public ResponseEntity<ProfileDto> addProfile(@RequestBody final ProfileDto profileDto){
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
}
