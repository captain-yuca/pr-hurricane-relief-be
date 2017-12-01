package com.uprm.prhr.models;
import java.io.Serializable;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Resource implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @ManyToOne
    private Category category;

    public Resource(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    protected Resource(){

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resource resource = (Resource) o;

        if (getId() != null ? !getId().equals(resource.getId()) : resource.getId() != null) return false;
        if (getName() != null ? !getName().equals(resource.getName()) : resource.getName() != null) return false;
        return getCategory() != null ? getCategory().equals(resource.getCategory()) : resource.getCategory() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
        return result;
    }
}
