package com.example.projectcourse.repository;

import com.example.projectcourse.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    public Optional<Admin> findAdminByUserName(String userName);
}