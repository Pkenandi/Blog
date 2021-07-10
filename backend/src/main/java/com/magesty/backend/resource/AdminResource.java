package com.magesty.backend.resource;

import com.magesty.backend.models.Admin;
import com.magesty.backend.models.dto.LoginDto;
import com.magesty.backend.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/")
public class AdminResource {
    private final AdminService adminService;

    @PostMapping("admin/register")
    public Admin register(@RequestBody final Admin administrator) throws Exception {
        return this.adminService.register(administrator);
    }

    @PostMapping("admin/login")
    public Admin login(@RequestBody final LoginDto loginDto) throws Exception {
        return this.adminService.login(loginDto);
    }
}
