package com.uprm.prhr.repositories;

import com.uprm.prhr.models.Stock;
import com.uprm.prhr.models.StockID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StockRepository extends CrudRepository<Stock, StockID>
{
    List<Stock> findByPricePerItem(@Param("price") Double price);
    List<Stock> findByQtySum(@Param("qty") Integer qty);
    List<Stock> findByResourceName(@Param("resource") String resource);
    List<Stock> findBySupplierName(@Param("name") String name);
}
