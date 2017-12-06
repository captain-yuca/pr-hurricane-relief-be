package com.uprm.prhr.repositories;

import com.uprm.prhr.models.ResourceRequestItem;
import com.uprm.prhr.models.ResourceRequestItemProjection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false, excerptProjection = ResourceRequestItemProjection.class)
public interface ResourceRequestItemRepository extends CrudRepository<ResourceRequestItem, Long>{}
