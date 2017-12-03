package com.uprm.prhr.repositories;

import com.uprm.prhr.models.ResourceTransaction;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

public interface ResourceTransactionRepository extends CrudRepository<ResourceTransaction, Long>
{
    List<ResourceTransaction> findByDate(@DateTimeFormat(pattern = "dd/MM/yyyy") @Param("date") Date date); //TODO: Make this work
    List<ResourceTransaction> findByQty(@Param("qty") Integer qty);
    List<ResourceTransaction> findByDateBetween(@Param("date1") Date date1, @Param("date2") Date date2);
    //TODO: Add more search queries if possible and necessary
}
