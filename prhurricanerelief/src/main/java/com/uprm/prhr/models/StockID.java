package com.uprm.prhr.models;

import java.io.Serializable;
import java.util.Objects;

public class StockID implements Serializable {
    private Long supplierId;
    private Long resourceId;

    public StockID(Long supplierId, Long resourceId)
    {
        this.resourceId = resourceId;
        this.supplierId = supplierId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockID stockID = (StockID) o;
        return Objects.equals(supplierId, stockID.supplierId) &&
                Objects.equals(resourceId, stockID.resourceId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(supplierId, resourceId);
    }

    @Override
    public String toString() {
        return "StockID{" +
                "supplierId=" + supplierId +
                ", resourceId=" + resourceId +
                '}';
    }
}
