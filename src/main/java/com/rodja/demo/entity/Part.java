package com.rodja.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.Nullable;

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

    @Column(name = "height")
    private int height;

    @Column(name = "width")
    private int width;

    @Column(name = "code_for_supplier")
    private String codeForSupplier;

    @Column(name = "status")
    private String status;

    @Column(name = "count")
    private int count;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "material_id")
    @JsonIgnoreProperties({"parts"})
    private Material material;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "assembly_id")
    @JsonIgnoreProperties({"parts"})
    @Nullable
    private Assembly assembly;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "machine_id")
    @JsonIgnoreProperties({"parts"})
    @Nullable
    private Machine machine;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "supplier_id")
    @JsonIgnoreProperties({"parts"})
    private Supplier supplier;

    public Part() {
    }

    public Part(String id, String name, int height, int width, String codeForSupplier, String status, int count, Material material, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.width = width;
        this.codeForSupplier = codeForSupplier;
        this.status = status;
        this.count = count;
        this.material = material;
        this.supplier = supplier;
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

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Assembly getAssembly() {
        return assembly;
    }

    public void setAssembly(Assembly assembly) {
        this.assembly = assembly;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Part{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", codeForSupplier='" + codeForSupplier + '\'' +
                ", status='" + status + '\'' +
                ", count=" + count +
                ", material=" + material +
                ", supplier=" + supplier +
                '}';
    }
}
