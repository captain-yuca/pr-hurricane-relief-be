package com.uprm.prhr.repositories;

import com.uprm.prhr.models.AvailabilityAnnouncement;
import com.uprm.prhr.models.AvailabilityAnnouncement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "announcements", path = "announcements")
public interface AvailabilityAnnouncementRepository extends CrudRepository<AvailabilityAnnouncement, Long>{
    AvailabilityAnnouncement findById(@Param("id") Long id);

//    TODO: Find By User
//    List<AvailabilityAnnouncement> findByUser(@Param("username") String username);

//    TODO: Find By Region

    @RestResource(rel = "findByCategory", path = "findByCategory")
    List<AvailabilityAnnouncement> findByAvailabilityAnnouncementItems_Resource_Category_Name(@Param("category") String category);

    @RestResource(rel = "findByResourceId",path = "findByResourceId")
    List<AvailabilityAnnouncement> findByAvailabilityAnnouncementItems_Resource_Id(@Param("id") Long id);
}
