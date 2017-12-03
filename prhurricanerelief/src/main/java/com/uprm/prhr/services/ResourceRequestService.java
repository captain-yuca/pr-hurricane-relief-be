package com.uprm.prhr.services;

import com.uprm.prhr.models.Requester;
import com.uprm.prhr.models.Resource;
import com.uprm.prhr.models.ResourceRequest;
import com.uprm.prhr.models.ResourceRequestDetail;
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
    private ResourceRequestDetailService resourceRequestDetailService;

    @Autowired
    public ResourceRequestService(ResourceRequestRepository resourceRequestRepository, ResourceRepository resourceRepository, ResourceRequestDetailService resourceRequestDetailService, RequesterRepository requesterRepository) {
        this.resourceRequestRepository = resourceRequestRepository;
        this.resourceRepository = resourceRepository;
        this.resourceRequestDetailService = resourceRequestDetailService;
        this.requesterRepository = requesterRepository;
    }



    //The resources hashtable key represents the resource id and the value represents the quantity of that resource
    public ResourceRequest createResourceRequest(Hashtable<Long, Long> resources, String requesterUsername){

        Requester requester = this.requesterRepository.findByUser_Name(requesterUsername);
        if(requester == null)
            throw new RuntimeException("Requester not found: " + requesterUsername);
        //No resources found, can't have a ResourceRequest without a ResourceRequestDetail
        if(resources.isEmpty())
            throw new RuntimeException("No resources are given as a parameter.");

//        ResourceRequest resourceRequest = resourceRequestRepository.save(new ResourceRequest(new Date(), new HashSet()));
//        if(resourceRequest == null)
//            throw new RuntimeException("What");

        //HashSet to add to
        Set<ResourceRequestDetail> resourceRequestDetails = new HashSet<ResourceRequestDetail>();

        for(Long rid:resources.keySet()){
            Resource resource = this.resourceRepository.findOne(rid);
            if(resource == null)
                throw new RuntimeException("Resource does not exist with given Id: " + rid);
            ResourceRequestDetail rrd = this.resourceRequestDetailService.
                    createResourceRequestDetail(rid, resources.get(rid));
            resourceRequestDetails.add(rrd);
        }

        return resourceRequestRepository.save(new ResourceRequest(new Date(), resourceRequestDetails, requester));
    }
}
