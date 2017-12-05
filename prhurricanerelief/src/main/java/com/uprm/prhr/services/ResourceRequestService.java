package com.uprm.prhr.services;

import com.uprm.prhr.exceptions.MissingParameterException;
import com.uprm.prhr.exceptions.ResourceNotFoundException;
import com.uprm.prhr.models.Resource;
import com.uprm.prhr.models.ResourceRequest;
import com.uprm.prhr.models.ResourceRequestDetail;
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
    private ResourceRequestDetailService resourceRequestDetailService;

    @Autowired
    public ResourceRequestService(ResourceRequestRepository resourceRequestRepository, ResourceRepository resourceRepository, ResourceRequestDetailService resourceRequestDetailService) {
        this.resourceRequestRepository = resourceRequestRepository;
        this.resourceRepository = resourceRepository;
        this.resourceRequestDetailService = resourceRequestDetailService;
    }



    //The resources hashtable key represents the resource id and the value represents the quantity of that resource
    public ResourceRequest createResourceRequest(Hashtable<Long, Long> resources){

        //No resources found, can't have a ResourceRequest without a ResourceRequestDetail
        if(resources.isEmpty())
            throw new MissingParameterException();

//        ResourceRequest resourceRequest = resourceRequestRepository.save(new ResourceRequest(new Date(), new HashSet()));
//        if(resourceRequest == null)
//            throw new RuntimeException("What");

        //HashSet to add to
        Set<ResourceRequestDetail> resourceRequestDetails = new HashSet<ResourceRequestDetail>();

        for(Long rid:resources.keySet()){
            Resource resource = this.resourceRepository.findOne(rid);
            if(resource == null)
                throw new ResourceNotFoundException("" + rid);
            ResourceRequestDetail rrd = this.resourceRequestDetailService.
                    createResourceRequestDetail(rid, resources.get(rid));
            resourceRequestDetails.add(rrd);
        }

        return resourceRequestRepository.save(new ResourceRequest(new Date(), resourceRequestDetails));
    }
}
