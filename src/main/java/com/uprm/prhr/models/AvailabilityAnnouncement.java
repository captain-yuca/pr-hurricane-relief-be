package com.uprm.prhr.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class AvailabilityAnnouncement implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Date date;

    @ManyToOne
    private Supplier supplier;

    @OneToMany
    private Set<AvailabilityAnnouncementItem> availabilityAnnouncementItems;

    public AvailabilityAnnouncement(Date date, Set<AvailabilityAnnouncementItem> availabilityAnnouncementItems, Supplier supplier) {
        this.date = date;
        this.availabilityAnnouncementItems = availabilityAnnouncementItems;
        this.supplier = supplier;
    }

    protected AvailabilityAnnouncement(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Set<AvailabilityAnnouncementItem> getAvailabilityAnnouncementItems() {
        return availabilityAnnouncementItems;
    }

    public void setAvailabilityAnnouncementItems(Set<AvailabilityAnnouncementItem> availabilityAnnouncementItems) {
        this.availabilityAnnouncementItems = availabilityAnnouncementItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AvailabilityAnnouncement that = (AvailabilityAnnouncement) o;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "AvailabilityAnnouncement{" +
                "id=" + id +
                ", date=" + date +
                ", supplier=" + supplier +
                ", availabilityAnnouncementItems=" + availabilityAnnouncementItems +
                '}';
    }
}
