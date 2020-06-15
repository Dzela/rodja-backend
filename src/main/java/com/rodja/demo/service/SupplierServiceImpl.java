package com.rodja.demo.service;

import com.rodja.demo.dao.SupplierRepository;
import com.rodja.demo.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    @Transactional
    public List<Supplier> getSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    @Transactional
    public Supplier getSupplier(String id) {
        return supplierRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void saveSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    @Transactional
    public void deleteSupplier(String id) {
        supplierRepository.deleteById(id);
    }
}
