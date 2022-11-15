package com.example.projectcourse.service;

import com.example.projectcourse.exceptions.AdminNotFoundException;
import com.example.projectcourse.exceptions.AllAdminNotFoundException;
import com.example.projectcourse.model.Admin;
import com.example.projectcourse.repository.AdminRepository;
import org.jetbrains.annotations.NotNull;
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
        try {
            return adminRepository.findAll();
        }catch (Exception e){
            throw new AllAdminNotFoundException();
        }
    }

    public Admin getAdminById(long id){

        try {
            Optional<Admin> admin=adminRepository.findById(id);
            return admin.get();
        }catch (Exception e){
            throw new AdminNotFoundException(id);
        }

    }

    public Admin getAdminByUsername(String userName){
        try {
            Optional<Admin> admin=adminRepository.findAdminByUserName(userName);
            return admin.get();
        }catch (Exception e){
            throw new AdminNotFoundException(userName);
        }

    }

    public void addAdmin(@NotNull Admin admin){
        adminRepository.save(admin);
    }

    public void updateAdmin(Admin admin){
        adminRepository.save(admin);
    }

    public void deleteAdmin(Admin admin){
        adminRepository.delete(admin);
    }
}