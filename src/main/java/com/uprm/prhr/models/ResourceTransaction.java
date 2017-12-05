package com.uprm.prhr.models;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class ResourceTransaction implements Serializable {
    @Id
    @GeneratedValue
    private Long tID;

    @ManyToOne
    private User user;

    @ManyToOne
    private Supplier supplier;

    @Column
    private Date date;

    @ManyToOne
    private Resource resource;

    @Column
    private Integer qty;

    protected ResourceTransaction() {}

    public ResourceTransaction(User user, Supplier supplier, Date date, Resource resource, Integer qty) {
        this.user = user;
        this.supplier = supplier;
        this.date = date;
        this.resource = resource;
        this.qty = qty;
    }

    public Long gettID() {
        return tID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Integer getQty() {
        return qty;
    }

    public void setPurchasePrice(Integer qty) {
        this.qty = qty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceTransaction that = (ResourceTransaction) o;
        return Objects.equals(tID, that.tID);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tID);
    }

    @Override
    public String toString() {
        return "ResourceTransaction{" +
                "tID=" + tID +
                ", user=" + user +
                ", supplier=" + supplier +
                ", date=" + date +
                ", resource=" + resource +
                ", qty=" + qty +
                '}';
    }
}