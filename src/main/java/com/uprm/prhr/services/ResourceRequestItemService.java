package com.uprm.prhr.services;

        import com.uprm.prhr.models.Resource;
        import com.uprm.prhr.models.ResourceRequestItem;
        import com.uprm.prhr.repositories.ResourceRepository;
        import com.uprm.prhr.repositories.ResourceRequestItemRepository;
        import com.uprm.prhr.repositories.ResourceRequestRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

@Service
public class ResourceRequestItemService {
    private ResourceRequestItemRepository resourceRequestItemRepository;
    private ResourceRequestRepository resourceRequestRepository;
    private ResourceRepository resourceRepository;

    @Autowired
    public ResourceRequestItemService(ResourceRequestItemRepository resourceRequestItemRepository, ResourceRequestRepository resourceRequestRepository, ResourceRepository resourceRepository) {
        this.resourceRequestItemRepository = resourceRequestItemRepository;
        this.resourceRequestRepository = resourceRequestRepository;
        this.resourceRepository = resourceRepository;
    }

    public ResourceRequestItem createResourceRequestItem(Long resourceId, Long qty){
        Resource resource = this.resourceRepository.findOne(resourceId);
        if(resource == null)
            throw new RuntimeException("Resource id not found: " + resourceId);

//        ResourceRequest resourceRequest = this.resourceRequestRepository.findOne(resourceRequestId);
//        if(resourceRequest == null)
//            throw new RuntimeException("ResourceRequest id not found: " + resourceRequestId);

        return resourceRequestItemRepository.save(new ResourceRequestItem(resource, qty));
    }
}
