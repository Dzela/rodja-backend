package com.rodja.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "assembly")
public class Assembly {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "number_of_parts")
    private int numberOfParts;

    @OneToMany(mappedBy = "assembly", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonIgnore
    private List<Part> parts;

    public Assembly() {
    }

    public Assembly(String id, String name, int numberOfParts) {
        this.id = id;
        this.name = name;
        this.numberOfParts = numberOfParts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfParts() {
        return numberOfParts;
    }

    public void setNumberOfParts(int numberOfParts) {
        this.numberOfParts = numberOfParts;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public void add(Part part) {
        if (parts.isEmpty()) {
            parts = new ArrayList<>();
        }
        parts.add(part);
        part.setAssembly(this);
    }

    @Override
    public String toString() {
        return "Assembly{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", numberOfParts=" + numberOfParts +
                '}';
    }
    
}
