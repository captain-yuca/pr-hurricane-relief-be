package com.uprm.prhr.repositories;

import com.uprm.prhr.models.Resource;
import com.uprm.prhr.models.ResourceProjection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = ResourceProjection.class)
public interface ResourceRepository extends CrudRepository<Resource, Long>{
    Resource findByName(@Param("name") String name);
    List<Resource> findByCategory_Name(@Param("name") String name);

}