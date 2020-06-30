package com.rodja.demo.service;

import com.rodja.demo.dao.AssemblyRepository;
import com.rodja.demo.dao.MachineRepository;
import com.rodja.demo.dao.MaterialRepository;
import com.rodja.demo.dao.PartRepository;
import com.rodja.demo.dao.SupplierRepository;
import com.rodja.demo.entity.Assembly;
import com.rodja.demo.entity.Machine;
import com.rodja.demo.entity.Material;
import com.rodja.demo.entity.Part;
import com.rodja.demo.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartServiceImpl implements PartService {

    @Autowired
    private PartRepository partRepository;

    @Autowired
    private AssemblyRepository assemblyRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private MachineRepository machineRepository;

    @Autowired
    private MaterialRepository materialRepository;

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
        if (assembly != null) {
            return partRepository.getPartsByAssembly(assembly);
        }
        return null;
    }

    @Override
    @Transactional
    public List<Part> getPartsBySupplier(String supplierId) {
        Supplier supplier = supplierRepository.findById(supplierId).orElse(null);
        if (supplier != null) {
            return partRepository.getPartsBySupplier(supplier);
        }
        return null;
    }

    @Override
    @Transactional
    public List<Part> getPartsByMachine(String machineId) {
        List<Part> result = new ArrayList<>();
        Machine machine = machineRepository.findById(machineId).orElse(null);
        if (machine != null) {
            result.addAll(partRepository.getPartsByMachine(machine));
        }
        List<Assembly> assemblies = assemblyRepository.getAssembliesByMachine(machine);
        for(Assembly assebly : assemblies) {
            result.addAll(partRepository.getPartsByAssembly(assebly));
        }
        return result;
    }

    @Override
    @Transactional
    public List<Part> getPartsByMaterial(String materialId) {
        Material material = materialRepository.findById(materialId).orElse(null);
        if (material != null) {
            return partRepository.getPartsByMaterial(material);
        }
        return null;
    }

}
