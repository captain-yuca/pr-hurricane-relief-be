package com.uprm.prhr.services;

import com.uprm.prhr.models.ResourceTransaction;
import com.uprm.prhr.repositories.ResourceTransactionRepository;
import com.uprm.prhr.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ResourceTransactionService
{
    private ResourceTransactionRepository resourceTransactionRepository;
    private StockRepository stockRepository;

    @Autowired
    public ResourceTransactionService(StockRepository stockRepository, ResourceTransactionRepository resourceTransactionRepository)
    {
        this.stockRepository = stockRepository;
        this.resourceTransactionRepository = resourceTransactionRepository;
    }

    public ResourceTransaction createResourceTransaction(Long uID, Long sID, Date date, Long rID, Long annID, Long reqID, Double purchasePrice )
    {
        return resourceTransactionRepository.save(new ResourceTransaction(uID, sID, date, rID, annID, reqID, purchasePrice));
    }

    public Iterable<ResourceTransaction> lookup() { return resourceTransactionRepository.findAll();}
    public long total() {return resourceTransactionRepository.count();}
}
