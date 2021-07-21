package com.magesty.backend.resource;

import com.magesty.backend.models.dto.SocialMediaDto;
import com.magesty.backend.service.SocialMediaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/media/")
public class SocialMediaResource {
    private final SocialMediaService socialMediaService;

    @PostMapping(value = "add", produces = {"application/json", "application/xml"}
            ,consumes = {"application/x-www-form-urlencoded"})
    public ResponseEntity<SocialMediaDto> addMedia(final SocialMediaDto socialMediaDto){
        return new ResponseEntity<>(this.socialMediaService.addSocialMedia(socialMediaDto), OK);
    }

    @GetMapping(value = "all")
    public ResponseEntity<List<SocialMediaDto>> getAll(){
        return new ResponseEntity<>(this.socialMediaService.getAll(), OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<SocialMediaDto> getOne(@PathVariable final Long id) throws Exception {
        return new ResponseEntity<>(this.socialMediaService.getOne(id), OK);
    }
}
