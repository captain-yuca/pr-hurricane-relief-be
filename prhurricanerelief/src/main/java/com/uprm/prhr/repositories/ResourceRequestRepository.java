package com.uprm.prhr.repositories;

import com.uprm.prhr.models.ResourceRequest;
import com.uprm.prhr.models.ResourceRequestProjection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "requests", path = "requests", excerptProjection = ResourceRequestProjection.class)
public interface ResourceRequestRepository extends CrudRepository<ResourceRequest, Long>{
    ResourceRequest findById(@Param("id") Long id);

    @RestResource(rel = "findByUsername", path = "findByUsername")
    List<ResourceRequest> findByRequester_User_Name(@Param("username") String username);

    @RestResource(rel = "findByCategory", path = "findByCategory")
    List<ResourceRequest> findByResourceRequestDetails_Resource_Category_Name(@Param("category") String category);

    @RestResource(rel = "findByResourceId",path = "findByResourceId")
    List<ResourceRequest> findByResourceRequestDetails_Resource_Id(@Param("id") Long id);
}
