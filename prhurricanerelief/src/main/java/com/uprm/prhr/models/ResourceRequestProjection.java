package com.uprm.prhr.models;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;
import java.util.Set;

@Projection(types=ResourceRequest.class)
public interface ResourceRequestProjection {
    public Long getId();
    public Date getDate();
    public Set<ResourceRequestItem> getResourceRequestDetails();
    public Requester getRequester();
}
