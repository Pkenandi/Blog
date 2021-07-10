package com.magesty.backend.service;

import com.magesty.backend.models.Admin;
import com.magesty.backend.models.dto.LoginDto;
import com.magesty.backend.repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@AllArgsConstructor
@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public Admin register(Admin administrator) throws Exception {
        if(Objects.isNull(administrator)){
            throw new Exception(" Null Object");
        }else{
            return this.adminRepository.save(administrator);
        }
    }

    public Admin login(LoginDto loginDto) throws Exception {
        Admin admin = this.adminRepository.findByUsername(loginDto.getUsername());

        if(Objects.isNull(admin)){
            return null;
        }else{
            if(loginDto.getPassword().equals(admin.getPassword()) &&
                    loginDto.getUsername().equals(admin.getUsername())){
                    return admin;
            }else{
                throw new Exception(" Data not found");
            }
        }
    }

}
