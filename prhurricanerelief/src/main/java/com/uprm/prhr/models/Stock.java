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

    protected Stock(){};

    public Stock(Long supplierId, Long resourceId, Integer qtySum, Double pricePerItem) {
        this.stockId = new StockID(supplierId,resourceId);
        this.qtySum = qtySum;
        this.pricePerItem = pricePerItem;
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
                '}';
    }
}
