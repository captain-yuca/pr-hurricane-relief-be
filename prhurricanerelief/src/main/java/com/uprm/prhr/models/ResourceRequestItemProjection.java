package com.uprm.prhr.models;

import org.springframework.data.rest.core.config.Projection;

@Projection(types=ResourceRequestItem.class)
public interface ResourceRequestItemProjection {

    public Long getId();
    public ResourceProjection getResource();
    public Long getQuantity();

}
