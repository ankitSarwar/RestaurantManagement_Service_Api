package com.example.Restaurant.management.service.API.service;

import com.example.Restaurant.management.service.API.model.Admin;
import com.example.Restaurant.management.service.API.model.User;
import com.example.Restaurant.management.service.API.repository.IAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    IAdminRepository adminRepository;

    @Autowired
    UserService userService;

    public List<User> getAllUser() {

        return  userService.AllUser();
    }

    public List<Admin> getAllAdmin() {
      return adminRepository.findAll();
    }

    public Admin addAdmin(Admin admin) {
       return adminRepository.save(admin);
    }
}
