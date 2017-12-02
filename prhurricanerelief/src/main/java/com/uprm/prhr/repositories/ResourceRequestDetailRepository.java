package com.uprm.prhr.repositories;

import com.uprm.prhr.models.Resource;
import com.uprm.prhr.models.ResourceRequestDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface ResourceRequestDetailRepository extends CrudRepository<ResourceRequestDetail, Long>{}
