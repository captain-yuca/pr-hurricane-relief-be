package com.uprm.prhr.repositories;

import com.uprm.prhr.models.AvailabilityAnnouncementItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface AvailabilityAnnouncementItemRepository extends CrudRepository<AvailabilityAnnouncementItem, Long>{
}
