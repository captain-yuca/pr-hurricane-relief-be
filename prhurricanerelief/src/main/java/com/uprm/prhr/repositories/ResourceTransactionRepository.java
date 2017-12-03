package com.uprm.prhr.repositories;

import com.uprm.prhr.models.ResourceTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResourceTransactionRepository extends CrudRepository<ResourceTransaction, Long>
{
    List<ResourceTransaction> findByDate(@Param("date") String date); //TODO: Make this work
    List<ResourceTransaction> findByQty(@Param("qty") Integer qty);
    //TODO: Add more search queries if possible and necessary
}
