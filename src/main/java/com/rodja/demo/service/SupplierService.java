package com.rodja.demo.service;

import com.rodja.demo.entity.Supplier;

import java.util.List;

public interface SupplierService {

    public List<Supplier> getSuppliers();
    public Supplier getSupplier(String id);
    public void saveSupplier(Supplier supplier);
    public void deleteSupplier(String id);

}
