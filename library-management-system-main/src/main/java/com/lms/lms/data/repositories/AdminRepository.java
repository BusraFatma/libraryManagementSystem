package com.lms.lms.data.repositories;

import com.lms.lms.data.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findAdminByEmail(String email);

    void deleteAdminByEmail(String email);


}
