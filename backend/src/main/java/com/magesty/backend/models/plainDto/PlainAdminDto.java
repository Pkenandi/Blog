package com.magesty.backend.models.plainDto;

import com.magesty.backend.models.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Optional;

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

        return Optional.ofNullable(admin)
            .map(admins -> {
                adminDto.setId(admins.getId());
                adminDto.setEmail(admins.getEmail());
                adminDto.setPassword(admins.getPassword());
                adminDto.setUsername(admins.getUsername());
                return adminDto;

        }).orElse(null);
    }
}
