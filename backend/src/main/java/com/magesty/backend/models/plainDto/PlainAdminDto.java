package com.magesty.backend.models.plainDto;

import com.magesty.backend.models.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlainAdminDto {
    private Long id;
    private String username;
    private String email;
    private String password;

    public static PlainAdminDto from(Admin admin){
        PlainAdminDto adminDto = new PlainAdminDto();

        if(Objects.isNull(admin)){
            return null;
        }else{
            adminDto.setId(admin.getId());
            adminDto.setEmail(admin.getEmail());
            adminDto.setPassword(admin.getPassword());
            adminDto.setUsername(admin.getUsername());

            return adminDto;
        }
    }
}
