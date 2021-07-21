package com.magesty.backend.resource;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.magesty.backend.filter.AuthenticationFilter;
import com.magesty.backend.models.Role;
import com.magesty.backend.models.dto.AdminDto;
import com.magesty.backend.models.dto.LoginRequest;
import com.magesty.backend.repository.RoleRepository;
import com.magesty.backend.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/")
public class AdminResource {

    private final AdminService adminService;
    private final RoleRepository roleRepository;

    // Login and Register

    @PostMapping(value = "op/register", produces = {"application/json", "application/xml"}
            ,consumes = {"application/x-www-form-urlencoded"})
    public ResponseEntity<AdminDto> register(final AdminDto administrator) {
        try {
            return new ResponseEntity<>(this.adminService.register(administrator), CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "op/addRole" , produces = {"application/json", "application/xml"}
            ,consumes = {"application/x-www-form-urlencoded"})
    public ResponseEntity<Role> saveRole(final Role role){
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/admin/addRole")
                .toUriString());
        return ResponseEntity.created(uri).body(this.adminService.saveRole(role));
    }

    @PostMapping(value = "op/{username}/{roleName}/addRole")
    public ResponseEntity<?> addRoleToUser(@PathVariable final String username,
                              @PathVariable final String roleName) throws Exception {
        this.adminService.addRoleToAdmin(username, roleName);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String secret = "TOTsu1V5mubEXPmAFVtysHzhlrRadCChslulhFBKWYEQuuSzOxnomIX3xiVpi@P_ik";
        String authorizationHeader = request.getHeader(AUTHORIZATION);

        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256(secret.getBytes());
                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                AdminDto adminDto = this.adminService.findByUsername(username);

                String access_token = JWT.create()
                        .withSubject(adminDto.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURI().toString())
                        .withClaim("roles", adminDto.getRoles()
                                .stream()
                                .map(Role::getName)
                                .collect(Collectors.toList()))
                        .sign(algorithm);

                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);

                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);

            }catch (Exception ex){

                response.setHeader("Erreur ", ex.getMessage());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", ex.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        }else {
            throw new Exception(" Refresh token is missing");
        }
    }

    // Operations

    @GetMapping(value = "op/admin/{username}")
    public ResponseEntity<AdminDto> findByUsername(@PathVariable final String username) throws Exception {
        return new ResponseEntity<>(this.adminService.findByUsername(username), OK);
    }

    @GetMapping(value = "op/role/{name}")
    public ResponseEntity<Role> findRoleByName(@PathVariable final String name){
        return ResponseEntity.ok().body(this.roleRepository.findByName(name));
    }

    @GetMapping(value = "admin/{username}/{adrId}/addAdresse")
    public ResponseEntity<AdminDto> addAdresse(@PathVariable final String username,
                                               @PathVariable final Long adrId) throws Exception {
        return new ResponseEntity<>(this.adminService.addAdresse(username, adrId), OK);
    }

    @GetMapping(value = "admin/{username}/{interestId}/addInterest")
    public ResponseEntity<AdminDto> addCentreInteret(@PathVariable final String username,
                                                     @PathVariable final Long interestId) throws Exception {
        return new ResponseEntity<>(this.adminService.addCentreInteret(username, interestId), OK);
    }

    @GetMapping(value = "admin/{username}/{eduId}/addEducation")
    public ResponseEntity<AdminDto> addEducation(@PathVariable final String username,
                                                 @PathVariable final Long eduId) throws Exception {
        return new ResponseEntity<>(this.adminService.addEducation(username, eduId), OK);
    }

    @GetMapping(value = "admin/{username}/{exId}/addExperience")
    public ResponseEntity<AdminDto> addExperience(@PathVariable final String username,
                                                  @PathVariable final Long exId) throws Exception {
        return new ResponseEntity<>(this.adminService.addExperience(username, exId), OK);
    }

    @GetMapping(value = "admin/{username}/{compId}/addCompetence")
    public ResponseEntity<AdminDto> addCompetence(@PathVariable final String username,
                                                  @PathVariable final Long compId) throws Exception {
        return new ResponseEntity<>(this.adminService.addCompetence(username, compId), OK);
    }

    @GetMapping(value = "admin/{username}/{langueId}/addLangue")
    public ResponseEntity<AdminDto> addLangue(@PathVariable final String username,
                                              @PathVariable final Long langueId) throws Exception {
        return new ResponseEntity<>(this.adminService.addLangue(username, langueId), OK);

    }

    @GetMapping(value = "admin/{username}/{profileId}/addProfile")
    public ResponseEntity<AdminDto> addProfile(@PathVariable final String username,
                                               @PathVariable final Long profileId) throws Exception {
       return new ResponseEntity<>(this.adminService.addProfile(username,profileId), OK);
    }

    @GetMapping(value = "admin/{username}/{projetId}/addProjet")
    public ResponseEntity<AdminDto> addProjet(@PathVariable final String username,
                                              @PathVariable final Long projetId) throws Exception {
        return new ResponseEntity<>(this.adminService.addProjet(username, projetId), OK);

    }

    @GetMapping(value = "admin/{username}/{mediaId}/addMedia")
    public ResponseEntity<AdminDto> addMedia(@PathVariable final String username,
                                             @PathVariable final Long mediaId) throws Exception {
        return new ResponseEntity<>(this.adminService.addMedia(username,mediaId), OK);
    }
}