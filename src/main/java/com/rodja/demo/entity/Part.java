package com.rodja.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "part")
public class Part {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "material")
    private String material;

    @Column(name = "height")
    private int height;

    @Column(name = "width")
    private int width;

    @Column(name = "depth")
    private int depth;

    @Column(name = "code_for_supplier")
    private String codeForSupplier;

    @Column(name = "count")
    private int count;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "assembly_id")
    @JsonIgnoreProperties({"parts"})
    private Assembly assembly;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "supplier_id")
    @JsonIgnoreProperties({"parts"})
    private Supplier supplier;

    public Part() {
    }

    public Part(String id, String name, String material, int height, int width, int depth, String codeForSupplier, int count) {
        this.id = id;
        this.name = name;
        this.material = material;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.codeForSupplier = codeForSupplier;
        this.count = count;
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getCodeForSupplier() {
        return codeForSupplier;
    }

    public void setCodeForSupplier(String codeForSupplier) {
        this.codeForSupplier = codeForSupplier;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Assembly getAssembly() {
        return assembly;
    }

    public void setAssembly(Assembly assembly) {
        this.assembly = assembly;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Part{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", material='" + material + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", depth=" + depth +
                ", codeForSupplier='" + codeForSupplier + '\'' +
                ", count=" + count +
                '}';
    }
    
}
