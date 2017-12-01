package com.uprm.prhr.models;

import java.io.Serializable;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class User implements Serializable{
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String password; //pretty sure this is not super safe, but hey, what the hell

    //will probably have to implement data type specific to region to prevent form entering illegal value,
    //or at least a method that verifies the legality of a region name.
    // or should we actually make it an entity? ehhh....
    @Column
    private String region;



    public User(String name, String password, String region) {
        this.name = name;
        this.password = password;
        this.region = region;
    }

    protected User(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", region='" + region + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!getId().equals(user.getId())) return false;
        if (!getName().equals(user.getName())) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        if (!getRegion().equals(user.getRegion())) return false;
        else return true;

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getRegion().hashCode();

        return result;
    }
}