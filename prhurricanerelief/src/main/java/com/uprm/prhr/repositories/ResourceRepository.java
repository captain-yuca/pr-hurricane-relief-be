package com.uprm.prhr.repositories;

import com.uprm.prhr.models.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ResourceRepository extends CrudRepository<Resource, Long>{
    Resource findByName(@Param("name") String name);
}
