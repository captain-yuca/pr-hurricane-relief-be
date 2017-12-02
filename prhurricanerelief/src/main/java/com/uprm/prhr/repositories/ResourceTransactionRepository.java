package com.uprm.prhr.repositories;

import com.uprm.prhr.models.ResourceTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResourceTransactionRepository extends CrudRepository<ResourceTransaction, Long>
{
    List<ResourceTransaction> findByPurchase_Price(@Param("purchasePrice") Double purchasePrice);
    List<ResourceTransaction> findByDate(@Param("date") String date);
}
