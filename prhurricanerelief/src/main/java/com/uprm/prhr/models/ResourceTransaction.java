package com.uprm.prhr.models;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class ResourceTransaction implements Serializable
{
   @Id
   @GeneratedValue
   private Long tID;

   @Column
    private Long uID;

   @Column
    private Long sID;

   @Column
    private Date date;

   @Column
    private Long rID;

   @Column
    private Long annID;

   @Column
    private Long reqID;

   @Column
    private Double purchasePrice;

    public ResourceTransaction(Long uID, Long sID, Date date, Long rID, Long annID, Long reqID, Double purchasePrice) {
        this.uID = uID;
        this.sID = sID;
        this.date = date;
        this.rID = rID;
        this.annID = annID;
        this.reqID = reqID;
        this.purchasePrice = purchasePrice;
    }

    protected ResourceTransaction(){};

    public Long gettID() {
        return tID;
    }

    public Long getuID() {
        return uID;
    }

    public Long getsID() {
        return sID;
    }

    public Date getDate() {
        return date;
    }

    public Long getrID() {
        return rID;
    }

    public Long getAnnID() {
        return annID;
    }

    public Long getReqID() {
        return reqID;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setuID(Long uID) {
        this.uID = uID;
    }

    public void setsID(Long sID) {
        this.sID = sID;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setrID(Long rID) {
        this.rID = rID;
    }

    public void setAnnID(Long annID) {
        this.annID = annID;
    }

    public void setReqID(Long reqID) {
        this.reqID = reqID;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
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
                ", uID=" + uID +
                ", sID=" + sID +
                ", date=" + date +
                ", rID=" + rID +
                ", annID=" + annID +
                ", reqID=" + reqID +
                ", purchasePrice=" + purchasePrice +
                '}';
    }
}
