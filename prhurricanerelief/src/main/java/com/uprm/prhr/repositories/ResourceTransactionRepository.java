package com.uprm.prhr.repositories;

import com.uprm.prhr.helpers.Region;
import com.uprm.prhr.models.ResourceTransaction;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

public interface ResourceTransactionRepository extends CrudRepository<ResourceTransaction, Long>
{
    List<ResourceTransaction> findByDate(@DateTimeFormat(pattern = "dd/MM/yyyy") @Param("date") Date date);
    List<ResourceTransaction> findByQty(@Param("qty") Integer qty);
    List<ResourceTransaction> findByDateAfter(@DateTimeFormat(pattern = "dd/MM/yyyy") @Param("date") Date date);
    List<ResourceTransaction> findByDateBefore(@DateTimeFormat(pattern = "dd/MM/yyyy") @Param("date") Date date);
    List<ResourceTransaction> findByDateBetween(@Param("date1") Date date1, @Param("date2") Date date2);
    @RestResource(rel="findBySupplierName", path="findBySupplierName")
    List<ResourceTransaction> findBySupplier_User_Name(@Param("name") String name);
    @RestResource(rel="findBySupplierRegion", path="findBySupplierRegion")
    List<ResourceTransaction> findBySupplier_User_Region(@Param("region") Region region);
    @RestResource(rel="findBySupplierFName", path="findBySupplierFName")
    List<ResourceTransaction> findBySupplier_User_FName(@Param("fname") String fname);
    @RestResource(rel="findBySupplierLName", path="findBySupplierLName")
    List<ResourceTransaction> findBySupplier_User_LName(@Param("lname") String lname);
    List<ResourceTransaction> findByUserName(@Param("name") String name);
    List<ResourceTransaction> findByUserRegion(@Param("region") Region region);
    List<ResourceTransaction> findByUserFName(@Param("fname") String fname);
    List<ResourceTransaction> findByUserLName(@Param("lname") String lname);
    @RestResource(rel="findByCategory", path="findByCategory")
    List<ResourceTransaction> findByResource_Category_Name(@Param("category") String Category);
}
