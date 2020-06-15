package com.rodja.demo.service;

import com.rodja.demo.dao.AssemblyRepository;
import com.rodja.demo.dao.PartRepository;
import com.rodja.demo.dao.SupplierRepository;
import com.rodja.demo.entity.Assembly;
import com.rodja.demo.entity.Part;
import com.rodja.demo.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PartServiceImpl implements PartService {

    @Autowired
    private PartRepository partRepository;

    @Autowired
    private AssemblyRepository assemblyRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    @Transactional
    public List<Part> getParts() {
        return partRepository.findAll();
    }

    @Override
    @Transactional
    public Part getPart(String id) {
        return partRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void savePart(Part part) {
        partRepository.save(part);
    }

    @Override
    @Transactional
    public void deletePart(String id) {
        partRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Part> getPartsByAssembly(String assemblyId) {
        Assembly assembly = assemblyRepository.findById(assemblyId).orElse(null);
        if(assembly != null) {
            return partRepository.getPartsByAssembly(assembly);
        }
        return null;
    }

    @Override
    @Transactional
    public List<Part> getPartsBySupplier(String supplierId) {
        Supplier supplier = supplierRepository.findById(supplierId).orElse(null);
        if(supplier != null) {
            return partRepository.getPartsBySupplier(supplier);
        }
        return null;
    }

}
