package com.uprm.prhr.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class AvailabilityAnnouncementItem implements Serializable{
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Resource resource;

    @Column
    private Long quantity;

    public AvailabilityAnnouncementItem(Resource resource, Long quantity) {
        this.resource = resource;
        this.quantity = quantity;
    }

    protected AvailabilityAnnouncementItem(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AvailabilityAnnouncementItem that = (AvailabilityAnnouncementItem) o;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "AvailabilityAnnouncementItem{" +
                "id=" + id +
                ", resource=" + resource +
                ", quantity=" + quantity +
                '}';
    }
}
