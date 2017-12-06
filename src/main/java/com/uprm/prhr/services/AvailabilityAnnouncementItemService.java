package com.uprm.prhr.services;

import com.uprm.prhr.exceptions.ResourceNotFoundException;
import com.uprm.prhr.models.Resource;
import com.uprm.prhr.models.AvailabilityAnnouncement;
import com.uprm.prhr.models.AvailabilityAnnouncementItem;
import com.uprm.prhr.repositories.ResourceRepository;
import com.uprm.prhr.repositories.AvailabilityAnnouncementItemRepository;
import com.uprm.prhr.repositories.AvailabilityAnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityAnnouncementItemService {
    private AvailabilityAnnouncementItemRepository availabilityAnnouncementItemRepository;
    private AvailabilityAnnouncementRepository availabilityAnnouncementRepository;
    private ResourceRepository resourceRepository;

    @Autowired
    public AvailabilityAnnouncementItemService(AvailabilityAnnouncementItemRepository availabilityAnnouncementItemRepository, AvailabilityAnnouncementRepository availabilityAnnouncementRepository, ResourceRepository resourceRepository) {
        this.availabilityAnnouncementItemRepository = availabilityAnnouncementItemRepository;
        this.availabilityAnnouncementRepository = availabilityAnnouncementRepository;
        this.resourceRepository = resourceRepository;
    }

    public AvailabilityAnnouncementItem createAvailabilityAnnouncementItem(Long resourceId, Long qty){
        Resource resource = this.resourceRepository.findOne(resourceId);
        if(resource == null)
            throw new ResourceNotFoundException("" + resourceId);

//        AvailabilityAnnouncement AvailabilityAnnouncement = this.AvailabilityAnnouncementRepository.findOne(AvailabilityAnnouncementId);
//        if(AvailabilityAnnouncement == null)
//            throw new RuntimeException("AvailabilityAnnouncement id not found: " + AvailabilityAnnouncementId);

        return availabilityAnnouncementItemRepository.save(new AvailabilityAnnouncementItem(resource, qty));
    }
}
