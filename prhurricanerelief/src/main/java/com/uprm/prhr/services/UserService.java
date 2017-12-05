package com.uprm.prhr.services;
import com.uprm.prhr.exceptions.RegionNotFoundException;
import com.uprm.prhr.exceptions.UserNotFoundException;
import com.uprm.prhr.models.User;
import com.uprm.prhr.helpers.Region;
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

    public User createUser(String name, String password, String regionName, String fName, String lName){
        if(userRepository.findByName(name)!=null){
            throw new UserNotFoundException(name);
        }
        Region region = Region.findByLabel(regionName);
        if(region==null){
            throw new RegionNotFoundException(regionName);
        }
        return userRepository.save(new User(name, password, region, fName, lName));
    }


    public Iterable<User> lookup(){
        return userRepository.findAll();
    }
    public long total(){
        return userRepository.count();
    }
}