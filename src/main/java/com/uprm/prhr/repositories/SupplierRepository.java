package com.uprm.prhr.repositories;

import com.uprm.prhr.helpers.Region;
import com.uprm.prhr.models.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SupplierRepository extends CrudRepository<Supplier, Long>{
    Supplier findByUser_Name(@Param("name") String name);
    List<Supplier> findByUser_Region(@Param("region") Region region);
    Supplier findByUser_RegionAndUser_Name(@Param("region") Region region, @Param("name")  String name);

    List<Supplier> findByUser_FName(@Param("fName") String fName);
    List<Supplier> findByUser_LName(@Param("lName") String lName);
    List<Supplier> findByUser_FNameAndUser_LName(@Param("fName") String fName, @Param("lName")  String lName);

    List<Supplier> findByUser_RegionAndUser_FName(@Param("region") Region region, @Param("fName")  String fName);
    List<Supplier> findByUser_RegionAndUser_LName(@Param("region") Region region, @Param("lName")  String lName);
    List<Supplier> findByUser_RegionAndUser_FNameAndUser_LName(@Param("region") Region region, @Param("fName")  String fName, @Param("lName") String lName);


}