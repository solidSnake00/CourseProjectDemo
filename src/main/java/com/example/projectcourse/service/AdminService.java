package com.example.projectcourse.service;

import com.example.projectcourse.model.Admin;
import com.example.projectcourse.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    public final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAllAdmins(){
        return adminRepository.findAll();
    }

    public Admin getAdminById(long id){
        Optional<Admin> admin=adminRepository.findById(id);

        return admin.get();
    }

    public Admin getAdminByUsername(String userName){
        Optional<Admin> admin=adminRepository.findAdminByUserName(userName);

        return admin.get();
    }

    public void addAdmin(Admin admin){
        adminRepository.save(admin);
    }
}
