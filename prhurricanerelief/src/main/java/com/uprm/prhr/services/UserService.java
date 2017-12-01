package com.uprm.prhr.services;

import com.uprm.prhr.models.User;
import com.uprm.prhr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name, String password, String region){
        return userRepository.save(new User(name, password, region));
    }


    public Iterable<User> lookup(){
        return userRepository.findAll();
    }
    public long total(){
        return userRepository.count();
    }
}
