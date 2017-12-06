package com.uprm.prhr.models;

import java.io.Serializable;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Stock
{

    @EmbeddedId
    private StockPk pk;

    @Column
    private Integer qtySum;


    @Column
    private Double pricePerItem;


    protected Stock(){};

    public Stock(Supplier supplier, Resource resource, Integer qtySum, Double pricePerItem) {
        this.qtySum = qtySum;
        this.pricePerItem = pricePerItem;
        this.pk = new StockPk(supplier, resource);
    }

    public StockPk getStockId() {
        return pk;
    }

    public User getSupplier(){return pk.getSupplier();}

    public Resource getResource(){return pk.getResource();}


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockPk)) return false;
        StockPk that = (StockPk) o;
        return Objects.equals(pk.getSupplier(), that.getSupplier()) &&
                Objects.equals(pk.getResource(), that.getResource());
    }

    @Override
    public int hashCode() {
            return Objects.hash(pk.getSupplier(), pk.getResource());
        }

    @Override
    public String toString() {
        return "Stock{" +
                "stockPk=" + pk +
                ", qtySum=" + qtySum +
                ", pricePerItem=" + pricePerItem +
                '}';
    }
}
