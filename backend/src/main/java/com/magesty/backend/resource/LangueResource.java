package com.magesty.backend.resource;

import com.magesty.backend.models.Langue;
import com.magesty.backend.models.dto.LangueDto;
import com.magesty.backend.service.LangueService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/langue/")
public class LangueResource {
    private final LangueService langueService;

    @PostMapping(value = "add", produces = {"application/json", "application/xml"}
            ,consumes = {"application/x-www-form-urlencoded"})
    public ResponseEntity<LangueDto> addLangue(final LangueDto langueDto){
        return new ResponseEntity<>(this.langueService.addLangue(langueDto), OK);
    }

    @GetMapping(value = "all")
    public ResponseEntity<List<LangueDto>> getAll(){
        return new ResponseEntity<>(this.langueService.getAll(), OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<LangueDto> getOne(@PathVariable final Long id) throws Exception {
        return new ResponseEntity<>(this.langueService.getOne(id), OK);
    }
}
