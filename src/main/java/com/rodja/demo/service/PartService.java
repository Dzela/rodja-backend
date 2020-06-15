package com.rodja.demo.service;

import com.rodja.demo.entity.Part;

import java.util.List;

public interface PartService {

    public List<Part> getParts();
    public Part getPart(String id);
    public void savePart(Part part);
    public void deletePart(String id);
    public List<Part> getPartsByAssembly(String assemblyId);
    public List<Part> getPartsBySupplier(String supplierId);

}
