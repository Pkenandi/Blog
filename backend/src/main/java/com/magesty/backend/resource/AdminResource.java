package com.magesty.backend.resource;

import com.magesty.backend.models.Admin;
import com.magesty.backend.models.dto.AdminDto;
import com.magesty.backend.models.dto.LoginDto;
import com.magesty.backend.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/")
public class AdminResource {
    private final AdminService adminService;

                // Login and Register
    @PostMapping("admin/register")
    public ResponseEntity<AdminDto> register(@RequestBody final AdminDto administrator) throws Exception {
        try{
            return new ResponseEntity<>(this.adminService.register(administrator), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("admin/login")
    public ResponseEntity<AdminDto> login(@RequestBody final LoginDto loginDto) {
        try{
            return new ResponseEntity<>(this.adminService.login(loginDto), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

                // Operations



}
