package com.uprm.prhr.services;

import com.uprm.prhr.models.Resource;
import com.uprm.prhr.models.Stock;
import com.uprm.prhr.models.StockID;
import com.uprm.prhr.models.User;
import com.uprm.prhr.repositories.ResourceRepository;
import com.uprm.prhr.repositories.StockRepository;
import com.uprm.prhr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService
{
    private StockRepository stockRepository;
    private UserRepository userRepository;
    private ResourceRepository resourceRepository;

    @Autowired
    public StockService(StockRepository stockRepository, UserRepository userRepository, ResourceRepository resourceRepository)
    {
        this.stockRepository = stockRepository;
        this.resourceRepository = resourceRepository;
        this.userRepository = userRepository;
    }

    public Stock createStock(Long supplierID, String resourceName, Double pricePerItem, Integer qty)
    {
        Resource resource = this.resourceRepository.findByName(resourceName);
        User supplier = this.userRepository.findOne(supplierID);
        if(resource == null)
        {
            throw new RuntimeException("Resource does not exist: " + resourceName);
        }
        if(supplier == null)
        {
            throw new RuntimeException("User ID does not exist: " + supplierID);
        }
        return stockRepository.save(new Stock(supplier, resource, qty, pricePerItem));
    }

    public Iterable<Stock> lookup() {return stockRepository.findAll(); }
    public long total() {return stockRepository.count();}
}
