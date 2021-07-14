package com.magesty.backend.resource;

import com.magesty.backend.models.dto.ProjetDto;
import com.magesty.backend.service.ProjetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/projet/")
public class ProjetResource {
    private final ProjetService projetService;

    @PostMapping(value = "add")
    public ResponseEntity<ProjetDto> addProjet(@RequestBody final ProjetDto projetDto){
        return new ResponseEntity<>(this.projetService.addProjet(projetDto), HttpStatus.OK);
    }

    @GetMapping(value = "all")
    public ResponseEntity<List<ProjetDto>> getAll(){
        return new ResponseEntity<>(this.projetService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ProjetDto> getOne(@PathVariable final Long id) throws Exception {
        return new ResponseEntity<>(this.projetService.getOne(id), HttpStatus.OK);
    }
}
