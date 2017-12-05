package com.uprm.prhr.services;

import com.uprm.prhr.exceptions.UserNotFoundException;
import com.uprm.prhr.models.User;
import com.uprm.prhr.models.Supplier;
import com.uprm.prhr.repositories.UserRepository;
import com.uprm.prhr.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class SupplierService{
    private UserRepository userRepository;
    private SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(UserRepository userRepository, SupplierRepository supplierRepository) {
        this.userRepository = userRepository;
        this.supplierRepository = supplierRepository;
    }

    public Supplier createSupplier(String userName){
        User user = userRepository.findByName(userName);
        if(user == null) {
            throw new UserNotFoundException(userName);
        }
        return supplierRepository.save(new Supplier(user));
    }

    public Iterable<Supplier> lookup(){
        return supplierRepository.findAll();
    }
    public long total() {
        return supplierRepository.count();
    }
}
