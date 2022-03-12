package com.magesty.backend.repository;

import com.magesty.backend.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
    @Query("Select case when count(admin)> 0 then true else false end " +
            "from Admin admin where lower(admin.username) like lower(:username)")
    boolean existByUsername(String username);
}
