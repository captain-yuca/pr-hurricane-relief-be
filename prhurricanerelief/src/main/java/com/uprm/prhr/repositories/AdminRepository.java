package com.uprm.prhr.repositories;

import com.uprm.prhr.models.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminRepository extends CrudRepository<Admin, Long>{
    Admin findByUser_Name(@Param("name") String name);
    List<Admin> findByUser_Region(@Param("region") String region);
    List<Admin> findByUser_RegionAndUser_Name(@Param("region") String region, @Param("name")  String name);
}