package com.uprm.prhr.models;
import java.io.Serializable;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Admin implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private User user;



    public Admin(User user) {
       this.user = user;
    }

    protected Admin(){

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
        if (!(o instanceof Admin)) return false;
        Admin admin = (Admin) o;
        return Objects.equals(getId(), admin.getId()) &&
                Objects.equals(getUser(), admin.getUser());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getUser());
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", user=" + user.getName() +
                '}';
    }
}
