package com.uprm.prhr.services;

import com.uprm.prhr.models.User;
import com.uprm.prhr.models.Admin;
import com.uprm.prhr.repositories.UserRepository;
import com.uprm.prhr.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class AdminService{
    private UserRepository userRepository;
    private AdminRepository adminRepository;

    @Autowired
    public AdminService(UserRepository userRepository, AdminRepository adminRepository) {
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
    }

    public Admin createAdmin(String userName){
        User user = userRepository.findByName(userName);
        if(user == null) {
            throw new RuntimeException("User does not exist: " + userName);
        }
        return adminRepository.save(new Admin(user));
    }

    public Iterable<Admin> lookup(){
        return adminRepository.findAll();
    }
    public long total() {
        return adminRepository.count();
    }
}
