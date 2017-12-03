package com.uprm.prhr.repositories;

import com.uprm.prhr.models.Resource;
import com.uprm.prhr.models.ResourceProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = ResourceProjection.class)
public interface ResourceRepository extends CrudRepository<Resource, Long>{
    Resource findByName(@Param("name") String name);

    @Query("SELECT r FROM Resource r WHERE r.id in (SELECT r FROM Resource r LEFT JOIN r.category c WHERE c.name like %?1) or  r.id in (SELECT r FROM Resource r LEFT JOIN r.category c WHERE c.parent IS NOT NULL AND c.parent.name like %?1)")
//    @Query("SELECT r FROM Resource r LEFT JOIN r.category c WHERE c.parent IS NOT NULL AND c.parent.name like %?1")
    List<Resource> findByCategory(@Param("name") String name);

}