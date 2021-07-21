package com.magesty.backend.resource;

import com.magesty.backend.models.dto.CentreInteretDto;
import com.magesty.backend.service.CentreInteretService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/interest/")
public class CentreInteretResource {
    private final CentreInteretService centreInteretService;

    @PostMapping(value = "add", produces = {"application/json", "application/xml"}
            ,consumes = {"application/x-www-form-urlencoded"})
    public ResponseEntity<CentreInteretDto> addCentreInteret(final CentreInteretDto centreInteretDto){
        return new ResponseEntity<>(this.centreInteretService.addCentreInteret(centreInteretDto), OK);
    }

    @GetMapping(value = "all")
    public ResponseEntity<List<CentreInteretDto>> getAll(){
        return new ResponseEntity<>(this.centreInteretService.getAll(), OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CentreInteretDto> getOne(@PathVariable final Long id) throws Exception {
        return new ResponseEntity<>(this.centreInteretService.getOne(id), OK);
    }
}
