package com.magesty.backend.resource;

import com.magesty.backend.models.SocialMedia;
import com.magesty.backend.models.dto.AdresseDto;
import com.magesty.backend.service.AdresseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/adresse/")
public class AdresseResource {
    private final AdresseService adresseService;

    @PostMapping(value = "add")
    public ResponseEntity<AdresseDto> addAdresse(@RequestBody final AdresseDto adresseDto){
        return new ResponseEntity<>(this.adresseService.addAdresse(adresseDto), HttpStatus.OK);
    }

    @GetMapping(value = "all")
    public ResponseEntity<List<AdresseDto>> getAll(){
        return new ResponseEntity<>(this.adresseService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AdresseDto> getOne(@PathVariable final Long id) throws Exception {
        return new ResponseEntity<>(this.adresseService.getOne(id), HttpStatus.OK);
    }

}
