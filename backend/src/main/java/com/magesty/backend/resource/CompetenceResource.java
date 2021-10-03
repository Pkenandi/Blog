package com.magesty.backend.resource;

import com.magesty.backend.models.dto.CompetenceDto;
import com.magesty.backend.service.CompetenceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/competence/")
public class CompetenceResource {
    private final CompetenceService competenceService;

    @PostMapping(value = "add")
    public ResponseEntity<CompetenceDto> addCompetence(@RequestBody final CompetenceDto competenceDto){
        return new ResponseEntity<>(this.competenceService.addCompetence(competenceDto), HttpStatus.OK);
    }

    @GetMapping(value = "all")
    public ResponseEntity<List<CompetenceDto>> getAll(){
        return new ResponseEntity<>(this.competenceService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CompetenceDto> getOne(@PathVariable final Long id) throws Exception {
        return new ResponseEntity<>(this.competenceService.getOne(id), HttpStatus.OK);
    }

}
