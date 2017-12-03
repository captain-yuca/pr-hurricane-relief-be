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
    @GeneratedValue
    private Long stockId; //TODO: Get rid of this id, figure the compound id out

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
        this.qtySum = qtySum;
        this.pricePerItem = pricePerItem;
        this.supplier = supplier;
        this.resource = resource;
    }

    public Long getStockId() {
        return stockId;
    }

    public Long getSupplierID()
    {
        return supplier.getId();
    }

    public Long getResourceID()
    {
        return resource.getId();
    }

    public User getSupplier(){return supplier;}

    public Resource getResource(){return resource;}


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
