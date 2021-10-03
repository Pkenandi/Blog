package com.magesty.backend.resource;

import com.magesty.backend.models.dto.ExperienceDto;
import com.magesty.backend.service.ExperienceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/experience/")
public class ExperienceResource {
    private final ExperienceService experienceService;

    @PostMapping(value = "add")
    public ResponseEntity<ExperienceDto> addExperience(@RequestBody final ExperienceDto experienceDto){
        return new ResponseEntity<>(this.experienceService.addExperience(experienceDto), HttpStatus.OK);
    }

    @GetMapping(value = "all")
    public ResponseEntity<List<ExperienceDto>> getAll(){
        return new ResponseEntity<>(this.experienceService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ExperienceDto> getOne(@PathVariable final Long id) throws Exception {
        return new ResponseEntity<>(this.experienceService.getOne(id), HttpStatus.OK);
    }
}
