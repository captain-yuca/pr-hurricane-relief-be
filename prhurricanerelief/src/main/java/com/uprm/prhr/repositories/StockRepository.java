package com.uprm.prhr.repositories;

import com.uprm.prhr.helpers.Region;
import com.uprm.prhr.models.Stock;
import com.uprm.prhr.models.StockID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface StockRepository extends CrudRepository<Stock, Long>
{
    List<Stock> findByPricePerItem(@Param("price") Double price);
    List<Stock> findByQtySum(@Param("qty") Integer qty);
    List<Stock> findByResourceName(@Param("resource") String resource);
    List<Stock> findBySupplierName(@Param("name") String name);

    @RestResource(rel="findByCategory", path="findByCategory")
    List<Stock> findByResource_Category_Name(@Param("category") String category);
    List<Stock> findBySupplierRegion(@Param("region") Region region);
    List<Stock> findBySupplierFName(@Param("fname") String fname);
    List<Stock> findBySupplierLName(@Param("lname") String lname);


    //TODO: Add more search queries if possible and necessary
}
