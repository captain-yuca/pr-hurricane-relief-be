package com.uprm.prhr.models;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = Resource.class)
public interface ResourceProjection {

    public Long getId();
    public String getName();
    public Category getCategory();

}
