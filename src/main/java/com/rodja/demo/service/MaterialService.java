package com.rodja.demo.service;

import com.rodja.demo.entity.Material;

import java.util.List;

public interface MaterialService {

    public List<Material> getMaterials();
    public Material getMaterial(String id);
    public void saveMaterial(Material material);
    public void deleteMaterial(String id);
    
}
