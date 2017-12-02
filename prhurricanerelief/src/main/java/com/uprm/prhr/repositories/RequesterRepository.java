package com.uprm.prhr.repositories;

import com.uprm.prhr.models.Requester;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RequesterRepository extends CrudRepository<Requester, Long>{
    Requester findByUser_Name(@Param("name") String name);
}