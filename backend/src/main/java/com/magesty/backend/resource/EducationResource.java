package com.magesty.backend.resource;

import com.magesty.backend.models.dto.EducationDto;
import com.magesty.backend.service.EducationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/edu/")
public class EducationResource {
    private final EducationService educationService;

    @PostMapping(value = "add")
    public ResponseEntity<EducationDto> addEducation(@RequestBody final EducationDto educationDto){
        return new ResponseEntity<>(this.educationService.addEducation(educationDto), HttpStatus.OK);
    }

    @GetMapping(value = "all")
    public ResponseEntity<List<EducationDto>> getAll(){
        return new ResponseEntity<>(this.educationService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<EducationDto> getOne(@PathVariable final Long id) throws Exception {
        return new ResponseEntity<>(this.educationService.getOne(id), HttpStatus.OK);
    }

}
