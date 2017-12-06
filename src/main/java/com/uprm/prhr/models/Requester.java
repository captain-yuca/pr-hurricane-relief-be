package com.uprm.prhr.models;
import java.io.Serializable;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Requester implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private User user;



    public Requester(User user) {
        this.user = user;
    }

    protected Requester(){

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
        if (!(o instanceof Requester)) return false;
        Requester requester = (Requester) o;
        return Objects.equals(getId(), requester.getId()) &&
                Objects.equals(getUser(), requester.getUser());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getUser());
    }

    @Override
    public String toString() {
        return "Requester{" +
                "id=" + id +
                ", user=" + user.getName() +
                '}';
    }
}
