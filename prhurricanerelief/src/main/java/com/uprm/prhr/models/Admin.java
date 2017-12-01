package com.uprm.prhr.models;

import java.io.Serializable;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
public class Admin extends User implements Serializable{
    @Id
    @GeneratedValue
    private Long admin_ID;

    public Admin() {

    }

    //protected Admin(){}


    public Long getAdmin_ID() {
        return admin_ID;
    }

    public void setAdmin_ID(Long admin_ID) {
        this.admin_ID = admin_ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin)) return false;
        if (!super.equals(o)) return false;
        Admin admin = (Admin) o;
        return Objects.equals(getAdmin_ID(), admin.getAdmin_ID());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getAdmin_ID());
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_ID=" + admin_ID +
                '}';
    }
}
