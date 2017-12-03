package com.uprm.prhr.repositories;

import com.uprm.prhr.helpers.Region;
import com.uprm.prhr.models.Stock;
import com.uprm.prhr.models.StockPk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface StockRepository extends CrudRepository<Stock, StockPk>
{
    List<Stock> findByPricePerItem(@Param("price") Double price);
    List<Stock> findByQtySum(@Param("qty") Integer qty);
    @RestResource(rel="findBySupplierName", path="findBySupplierName")
    List<Stock> findByPk_Supplier_User_Name(@Param("name") String name);
    @RestResource(rel="findByResourceName", path="findByResourceName")
    List<Stock> findByPk_Resource_Name(@Param("resource") String resource);
    List<Stock> findByPkSupplierId(@Param("id") Integer id);
    List<Stock> findByPkResourceId(@Param("id") Integer id);

    @RestResource(rel="findByCategory", path="findByCategory")
    List<Stock> findByPk_Resource_Category_Name(@Param("category") String category);
    @RestResource(rel="findBySupplierRegion", path="findBySupplierRegion")
    List<Stock> findByPk_Supplier_User_Region(@Param("region") Region region);
    @RestResource(rel="findBySupplierFName", path="findBySupplierFName")
    List<Stock> findByPk_Supplier_User_FName(@Param("fname") String fname);
    @RestResource(rel="findBySupplierLName", path="findBySupplierLName")
    List<Stock> findByPk_Supplier_User_LName(@Param("lname") String lname);


    //TODO: Add more search queries if possible and necessary
}
