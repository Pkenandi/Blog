package com.magesty.backend.service;

import com.magesty.backend.models.Admin;
import com.magesty.backend.models.dto.AdminDto;
import com.magesty.backend.models.dto.LoginDto;
import com.magesty.backend.repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@Service
public class AdminService {
    private final AdminRepository adminRepository;

                // Login and Register
    public AdminDto register(AdminDto administrator) throws Exception {
        if(Objects.isNull(administrator)){
            throw new Exception(" Null Object");
        }else{
            return AdminDto.from(this.adminRepository.save(Objects.requireNonNull(Admin.from(administrator))));
        }
    }

    public AdminDto login(LoginDto loginDto) throws Exception {
        Admin admin = this.adminRepository.findByUsername(loginDto.getUsername());

        if(Objects.isNull(admin)){
            return null;
        }else{
            if(loginDto.getPassword().equals(admin.getPassword()) &&
                    loginDto.getUsername().equals(admin.getUsername())){
                    return AdminDto.from(admin);
            }else{
                throw new Exception(" Data not found");
            }
        }
    }

                    // Operations
    public AdminDto getOne(Long id){
        return AdminDto.from(this.adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(" Not found ")));
    }

}
