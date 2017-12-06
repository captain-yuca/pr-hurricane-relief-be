package com.uprm.prhr.services;

import com.uprm.prhr.models.ResourceRequestItem;
import com.uprm.prhr.exceptions.MissingParameterException;
import com.uprm.prhr.exceptions.ResourceNotFoundException;
import com.uprm.prhr.models.Requester;
import com.uprm.prhr.models.Resource;
import com.uprm.prhr.models.ResourceRequest;
import com.uprm.prhr.models.ResourceRequestItem;
import com.uprm.prhr.repositories.RequesterRepository;
import com.uprm.prhr.repositories.ResourceRepository;
import com.uprm.prhr.repositories.ResourceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

@Service
public class ResourceRequestService {
    private ResourceRequestRepository resourceRequestRepository;
    private ResourceRepository resourceRepository;
    private RequesterRepository requesterRepository;
    private ResourceRequestItemService resourceRequestItemService;

    @Autowired
    public ResourceRequestService(ResourceRequestRepository resourceRequestRepository, ResourceRepository resourceRepository, ResourceRequestItemService resourceRequestItemService, RequesterRepository requesterRepository) {
        this.resourceRequestRepository = resourceRequestRepository;
        this.resourceRepository = resourceRepository;
        this.resourceRequestItemService = resourceRequestItemService;
        this.requesterRepository = requesterRepository;
    }



    //The resources hashtable key represents the resource id and the value represents the quantity of that resource
    public ResourceRequest createResourceRequest(Hashtable<Long, Long> resources, String requesterUsername){

        Requester requester = this.requesterRepository.findByUser_Name(requesterUsername);
        if(requester == null)
            throw new RuntimeException("Requester not found: " + requesterUsername);
        //No resources found, can't have a ResourceRequest without a ResourceRequestItem
        if(resources.isEmpty())
            throw new MissingParameterException();

//        ResourceRequest resourceRequest = resourceRequestRepository.save(new ResourceRequest(new Date(), new HashSet()));
//        if(resourceRequest == null)
//            throw new RuntimeException("What");

        //HashSet to add to
        Set<ResourceRequestItem> resourceRequestItems = new HashSet<ResourceRequestItem>();

        for(Long rid:resources.keySet()){
            Resource resource = this.resourceRepository.findOne(rid);
            if(resource == null)
                throw new ResourceNotFoundException("" + rid);
            ResourceRequestItem rrd = this.resourceRequestItemService.
                    createResourceRequestItem(rid, resources.get(rid));
            resourceRequestItems.add(rrd);
        }

        return resourceRequestRepository.save(new ResourceRequest(new Date(), resourceRequestItems, requester));
    }
}
