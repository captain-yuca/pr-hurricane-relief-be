package com.uprm.prhr.models;

import java.io.Serializable;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Stock
{
    @Id
    private StockID stockId;

    @Column
    private Integer qtySum;


    @Column
    private Double pricePerItem;

    @ManyToOne
    private User supplier;

    @ManyToOne
    private Resource resource;

    protected Stock(){};

    public Stock(User supplier, Resource resource, Integer qtySum, Double pricePerItem) {
        this.stockId = new StockID(supplier.getId(),resource.getId());
        this.qtySum = qtySum;
        this.pricePerItem = pricePerItem;
        this.supplier = supplier;
        this.resource = resource;
    }

    public StockID getStockId() {
        return stockId;
    }

    public Long getSupplierID()
    {
        return stockId.getSupplierId();
    }

    public Long getResourceID()
    {
        return stockId.getResourceId();
    }

    public User getSupplier(){return supplier;}

    public Resource getResource(){return resource;}

    public void setStockId(StockID stockId) {
        this.stockId = stockId;
    }

    public void setSupplierID(Long supplierID)
    {
        this.stockId.setSupplierId(supplierID);
    }

    public void setResourceID(Long resourceID)
    {
        this.stockId.setResourceId(resourceID);
    }

    public Integer getQtySum() {
        return qtySum;
    }

    public void setQtySum(Integer qtySum) {
        this.qtySum = qtySum;
    }


    public Double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(Double pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    public void setSupplier(User supplier)
    {
        this.supplier = supplier;
    }

    public void setResource(Resource resource)
    {
        this.resource=resource;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Objects.equals(stockId, stock.stockId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(stockId);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockId=" + stockId +
                ", qtySum=" + qtySum +
                ", pricePerItem=" + pricePerItem +
                ", supplier=" + supplier +
                ", resource=" + resource +
                '}';
    }
}
