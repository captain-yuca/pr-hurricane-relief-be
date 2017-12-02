package com.uprm.prhr.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ResourceRequest implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private java.util.Date date;

    @OneToMany
    private Set<ResourceRequestDetail> resourceRequestDetails;

//    Represents the requester
//    @Column
//    private Requester requester;


    public ResourceRequest(java.util.Date date, Set<ResourceRequestDetail> resourceRequestDetails) {
        this.date = date;
        this.resourceRequestDetails = resourceRequestDetails;
    }
    protected ResourceRequest() {}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<ResourceRequestDetail> getResourceRequestDetails() {
        return resourceRequestDetails;
    }

    public void setResourceRequestDetails(HashSet<ResourceRequestDetail> resourceRequestDetails) {
        this.resourceRequestDetails = resourceRequestDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResourceRequest that = (ResourceRequest) o;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "ResourceRequest{" +
                "id=" + id +
                ", date=" + date +
                ", resourceRequestDetails=" + resourceRequestDetails +
                '}';
    }
}
