package com.example.projectcourse.controller;

import com.example.projectcourse.model.Admin;
import com.example.projectcourse.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/all")
    public List<Admin> displayAllAdmins(){
        return adminService.getAllAdmins();
    }

    @GetMapping("/id/{id}")
    public Admin displayAdmin(@PathVariable long id){
        return adminService.getAdminById(id);
    }

    @GetMapping("/username/{username}")
    public Admin displayAdmin(@PathVariable String username){
        return adminService.getAdminByUsername(username);
    }

    @PostMapping("/create")
    public void createAdmin(@RequestBody @Valid Admin admin){
        adminService.addAdmin(admin);
    }

    @DeleteMapping("/id/{id}")
    public void deleteAdmin(@PathVariable long id){
        Admin admin=adminService.getAdminById(id);
        adminService.deleteAdmin(admin);
    }

    @PutMapping("/update")
    public void updateAdmin(@RequestBody Admin admin){
        adminService.deleteAdmin(admin);
    }

}
