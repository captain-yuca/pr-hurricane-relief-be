package com.uprm.prhr.services;

import com.uprm.prhr.models.*;
import com.uprm.prhr.repositories.AvailabilityAnnouncementRepository;
import com.uprm.prhr.repositories.ResourceRepository;
import com.uprm.prhr.repositories.ResourceRequestRepository;
import com.uprm.prhr.repositories.SupplierRepository;
import org.hibernate.dialect.identity.IdentityColumnSupportImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

@Service
public class AvailabilityAnnouncementService {

    private AvailabilityAnnouncementRepository availabilityAnnouncementRepository;
    private ResourceRepository resourceRepository;
    private SupplierRepository supplierRepository;
    private AvailabilityAnnouncementItemService availabilityAnnouncementItemService;

    @Autowired
    public AvailabilityAnnouncementService(AvailabilityAnnouncementRepository availabilityAnnouncementRepository, ResourceRepository resourceRepository, SupplierRepository supplierRepository, AvailabilityAnnouncementItemService availabilityAnnouncementItemService) {
        this.availabilityAnnouncementRepository = availabilityAnnouncementRepository;
        this.resourceRepository = resourceRepository;
        this.supplierRepository = supplierRepository;
        this.availabilityAnnouncementItemService = availabilityAnnouncementItemService;
    }



    //The resources hashtable key represents the resource id and the value represents the quantity of that resource
    public AvailabilityAnnouncement createAvailabilityAnnouncement(Hashtable<Long, Long> resources, String supplierUsername){

        Supplier supplier = supplierRepository.findByUser_Name(supplierUsername);
        if(supplier == null)
            throw new RuntimeException("User does not exist: " + supplierUsername);

        //No resources found, can't have a ResourceRequest without a ResourceRequestDetail
        if(resources.isEmpty())
            throw new RuntimeException("No resources are given as a parameter.");

//        ResourceRequest resourceRequest = resourceRequestRepository.save(new ResourceRequest(new Date(), new HashSet()));
//        if(resourceRequest == null)
//            throw new RuntimeException("What");

        //HashSet to add to
        Set<AvailabilityAnnouncementItem> availabilityAnnouncementItems = new HashSet<AvailabilityAnnouncementItem>();

        for(Long rid:resources.keySet()){
            Resource resource = this.resourceRepository.findOne(rid);
            if(resource == null)
                throw new RuntimeException("Resource does not exist with given Id: " + rid);
            AvailabilityAnnouncementItem rrd = this.availabilityAnnouncementItemService.
                    createAvailabilityAnnouncementItem(rid, resources.get(rid));
            availabilityAnnouncementItems.add(rrd);
        }

        return availabilityAnnouncementRepository.save(new AvailabilityAnnouncement(new Date(), availabilityAnnouncementItems, supplier));
    }
}
