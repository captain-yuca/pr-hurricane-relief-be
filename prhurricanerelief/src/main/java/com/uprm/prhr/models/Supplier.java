package com.uprm.prhr.models;
import java.io.Serializable;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Supplier implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private User user;



    public Supplier(User user) {
        this.user = user;
    }

    protected Supplier(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Supplier)) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(getId(), supplier.getId()) &&
                Objects.equals(getUser(), supplier.getUser());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getUser());
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", user=" + user.getName() +
                '}';
    }
}
