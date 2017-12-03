package com.uprm.prhr.services;

import com.uprm.prhr.models.Resource;
import com.uprm.prhr.models.ResourceTransaction;
import com.uprm.prhr.models.Supplier;
import com.uprm.prhr.models.User;
import com.uprm.prhr.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ResourceTransactionService
{
    private ResourceTransactionRepository resourceTransactionRepository;
    private UserRepository userRepository;
    private ResourceRepository resourceRepository;
    private SupplierRepository supplierRepository;

    @Autowired
    public ResourceTransactionService(ResourceTransactionRepository resourceTransactionRepository, UserRepository userRepository, ResourceRepository resourceRepository, SupplierRepository supplierRepository)
    {
        this.resourceTransactionRepository = resourceTransactionRepository;
        this.resourceRepository = resourceRepository;
        this.userRepository = userRepository;
        this.supplierRepository = supplierRepository;

    }

    public ResourceTransaction createResourceTransaction(Long uID, Long sID, Date date, String resourceName, Integer qty)
    {
        Resource resource = this.resourceRepository.findByName(resourceName);
        User user = this.userRepository.findOne(uID);
        Supplier supplier = this.supplierRepository.findOne(sID);


        if(resource == null)
        {
            throw new RuntimeException("Resource Does Not Exist: " + resourceName);
        }
        if(user == null)
        {
            throw new RuntimeException("User ID does not exist: " + uID);
        }
        if(supplier ==null)
        {
            throw new RuntimeException("Supplier ID does not exist: " + sID);
        }
        return resourceTransactionRepository.save(new ResourceTransaction(user, supplier, date, resource, qty));
    }

    public Iterable<ResourceTransaction> lookup() { return resourceTransactionRepository.findAll();}
    public long total() {return resourceTransactionRepository.count();}
}
