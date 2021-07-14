package com.magesty.backend.resource;

import com.magesty.backend.models.*;
import com.magesty.backend.models.dto.AdminDto;
import com.magesty.backend.models.dto.LoginDto;
import com.magesty.backend.service.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

import static java.util.Objects.*;
import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/admin/")
public class AdminResource {

    private final AdminService adminService;

    // Login and Register

    @PostMapping("register")
    public ResponseEntity<AdminDto> register(@RequestBody final AdminDto administrator) throws Exception {
        try {
            return new ResponseEntity<>(this.adminService.register(administrator), OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("login")
    public ResponseEntity<AdminDto> login(@RequestBody final LoginDto loginDto) {
        try {
            return new ResponseEntity<>(this.adminService.login(loginDto), OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Operations

    @GetMapping(value = "{username}")
    public ResponseEntity<AdminDto> findByUsername(@PathVariable final String username) throws Exception {
        return new ResponseEntity<>(this.adminService.findByUsername(username), OK);
    }

    @GetMapping(value = "{username}/{adrId}/addAdresse")
    public ResponseEntity<AdminDto> addAdresse(@PathVariable final String username,
                                               @PathVariable final Long adrId) throws Exception {
        return new ResponseEntity<>(this.adminService.addAdresse(username, adrId), OK);
    }

    @GetMapping(value = "{username}/{interestId}/addInterest")
    public ResponseEntity<AdminDto> addCentreInteret(@PathVariable final String username,
                                                     @PathVariable final Long interestId) throws Exception {
        return new ResponseEntity<>(this.adminService.addCentreInteret(username, interestId), OK);
    }

    @GetMapping(value = "{username}/{eduId}/addEducation")
    public ResponseEntity<AdminDto> addEducation(@PathVariable final String username,
                                                 @PathVariable final Long eduId) throws Exception {
        return new ResponseEntity<>(this.adminService.addEducation(username, eduId), OK);
    }

    @GetMapping(value = "{username}/{exId}/addExperience")
    public ResponseEntity<AdminDto> addExperience(@PathVariable final String username,
                                                  @PathVariable final Long exId) throws Exception {
        return new ResponseEntity<>(this.adminService.addExperience(username, exId), OK);
    }

    @GetMapping(value = "{username}/{compId}/addCompetence")
    public ResponseEntity<AdminDto> addCompetence(@PathVariable final String username,
                                                  @PathVariable final Long compId) throws Exception {
        return new ResponseEntity<>(this.adminService.addCompetence(username, compId), OK);
    }

    @GetMapping(value = "{username}/{langueId}/addLangue")
    public ResponseEntity<AdminDto> addLangue(@PathVariable final String username,
                                              @PathVariable final Long langueId) throws Exception {
        return new ResponseEntity<>(this.adminService.addLangue(username, langueId), OK);

    }

    @GetMapping(value = "{username}/{profileId}/addProfile")
    public ResponseEntity<AdminDto> addProfile(@PathVariable final String username,
                                               @PathVariable final Long profileId) throws Exception {
       return new ResponseEntity<>(this.adminService.addProfile(username,profileId), OK);
    }

    @GetMapping(value = "{username}/{projetId}/addProjet")
    public ResponseEntity<AdminDto> addProjet(@PathVariable final String username,
                                              @PathVariable final Long projetId) throws Exception {
        return new ResponseEntity<>(this.adminService.addProjet(username, projetId), OK);

    }

    @GetMapping(value = "{username}/{mediaId}/addMedia")
    public ResponseEntity<AdminDto> addMedia(@PathVariable final String username,
                                             @PathVariable final Long mediaId) throws Exception {
        return new ResponseEntity<>(this.adminService.addMedia(username,mediaId), OK);
    }
}