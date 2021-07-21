package com.magesty.backend.resource;

import com.magesty.backend.models.dto.ProjetDto;
import com.magesty.backend.service.ProjetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/projet/")
public class ProjetResource {
    private final ProjetService projetService;

    @PostMapping(value = "add", produces = {"application/json", "application/xml"}
            ,consumes = {"application/x-www-form-urlencoded"})
    public ResponseEntity<ProjetDto> addProjet(final ProjetDto projetDto){
        return new ResponseEntity<>(this.projetService.addProjet(projetDto), OK);
    }

    @GetMapping(value = "all")
    public ResponseEntity<List<ProjetDto>> getAll(){
        return new ResponseEntity<>(this.projetService.getAll(), OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ProjetDto> getOne(@PathVariable final Long id) throws Exception {
        return new ResponseEntity<>(this.projetService.getOne(id), OK);
    }
}
