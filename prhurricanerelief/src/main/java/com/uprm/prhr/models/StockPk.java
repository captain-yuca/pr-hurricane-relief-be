package com.uprm.prhr.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StockPk implements Serializable {
    @ManyToOne
    private Supplier supplier;
    @ManyToOne
    private Resource resource;

    protected StockPk(){}

    public StockPk(Supplier supplier, Resource resource) {
        this.supplier = supplier;
        this.resource = resource;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockPk stockID = (StockPk) o;
        return Objects.equals(supplier, stockID.supplier) &&
                Objects.equals(resource, stockID.resource);
    }

    @Override
    public int hashCode() {

        return Objects.hash(supplier, resource);
    }

    @Override
    public String toString() {
        return "StockPk{" +
                "supplier=" + supplier +
                ", resource=" + resource +
                '}';
    }
}
