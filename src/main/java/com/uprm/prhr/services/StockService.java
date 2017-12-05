package com.uprm.prhr.services;

import com.uprm.prhr.models.*;
import com.uprm.prhr.repositories.ResourceRepository;
import com.uprm.prhr.repositories.StockRepository;
import com.uprm.prhr.repositories.SupplierRepository;
import com.uprm.prhr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService
{
    private StockRepository stockRepository;
    private SupplierRepository supplierRepository;
    private ResourceRepository resourceRepository;

    @Autowired
    public StockService(StockRepository stockRepository, SupplierRepository supplierRepository, ResourceRepository resourceRepository)
    {
        this.stockRepository = stockRepository;
        this.resourceRepository = resourceRepository;
        this.supplierRepository = supplierRepository;
    }

    public Stock createStock(Long supplierID, String resourceName, Double pricePerItem, Integer qty)
    {
        Resource resource = this.resourceRepository.findByName(resourceName);
        Supplier supplier = this.supplierRepository.findOne(supplierID);
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
