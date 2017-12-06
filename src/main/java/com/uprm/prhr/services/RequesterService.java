package com.uprm.prhr.services;

import com.uprm.prhr.exceptions.UserNotFoundException;
import com.uprm.prhr.models.User;
import com.uprm.prhr.models.Requester;
import com.uprm.prhr.repositories.UserRepository;
import com.uprm.prhr.repositories.RequesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class RequesterService{
    private UserRepository userRepository;
    private RequesterRepository requesterRepository;

    @Autowired
    public RequesterService(UserRepository userRepository, RequesterRepository requesterRepository) {
        this.userRepository = userRepository;
        this.requesterRepository = requesterRepository;
    }

    public Requester createRequester(String userName){
        User user = userRepository.findByName(userName);
        if(user == null) {
            throw new UserNotFoundException(userName);
        }
        return requesterRepository.save(new Requester(user));
    }

    public Iterable<Requester> lookup(){
        return requesterRepository.findAll();
    }
    public long total() {
        return requesterRepository.count();
    }
}
