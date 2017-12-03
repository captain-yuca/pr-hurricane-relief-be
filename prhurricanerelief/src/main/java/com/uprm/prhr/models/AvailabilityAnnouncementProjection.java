package com.uprm.prhr.models;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;
import java.util.Set;

@Projection(name = "availabilityAnnouncement", types = AvailabilityAnnouncement.class)
public interface AvailabilityAnnouncementProjection {
    public Long getId();
    public Supplier getSupplier();
    public Date getDate();
    public Set<AvailabilityAnnouncementItem> getAvailabilityAnnouncementItems();
}
