package com.uprm.prhr.repositories;

import com.uprm.prhr.models.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SupplierRepository extends CrudRepository<Supplier, Long>{
    Supplier findByUser_Name(@Param("name") String name);
    Supplier findByUser_Region(@Param("region") String region);
    Supplier findByUser_RegionAndUser_Name(@Param("region") String region, @Param("name")  String name);
}