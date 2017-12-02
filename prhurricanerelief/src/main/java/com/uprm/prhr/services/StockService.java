package com.uprm.prhr.services;

import com.uprm.prhr.models.Stock;
import com.uprm.prhr.models.StockID;
import com.uprm.prhr.models.User;
import com.uprm.prhr.repositories.StockRepository;
import com.uprm.prhr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService
{
    private StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Stock createStock(Long supplierID, Long resourceID, Double pricePerItem, Integer qty)
    {
        return stockRepository.save(new Stock(supplierID, resourceID, qty, pricePerItem));
    }

    public Iterable<Stock> lookup() {return stockRepository.findAll(); }
    public long total() {return stockRepository.count();}
}
