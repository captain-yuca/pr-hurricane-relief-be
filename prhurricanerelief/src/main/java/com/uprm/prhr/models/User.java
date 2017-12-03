package com.uprm.prhr.models;

import com.uprm.prhr.helpers.Region;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Objects;

@Entity
public class User implements Serializable{
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;



    @Column
    private String password; /**pretty sure this is not super safe, but hey, what the hell*/

    /**will probably have to implement data type specific to region to prevent form entering illegal value,
    //or at least a method that verifies the legality of a region name.
    // or should we actually make it an entity? ehhh....*/
    @Column
    private Region region;

    @Column
    private String fName;

    @Column
    private String lName;



    public User(String name, String password, Region region, String fName, String lName) {
        this.name = name;
        this.password = password;
        this.region = region;
        this.fName = fName;
        this.lName = lName;
    }

    protected User(){}

    public Long getId() {
        return id;
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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) &&
                Objects.equals(getName(), user.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", region='" + region.toString() + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }

}
