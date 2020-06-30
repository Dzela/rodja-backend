package com.rodja.demo.service;

import com.rodja.demo.dao.MaterialRepository;
import com.rodja.demo.entity.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Override
    @Transactional
    public List<Material> getMaterials() {
        return materialRepository.findAll();
    }

    @Override
    @Transactional
    public Material getMaterial(String id) {
        return materialRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void saveMaterial(Material material) {
        materialRepository.save(material);
    }

    @Override
    @Transactional
    public void deleteMaterial(String id) {
        materialRepository.deleteById(id);
    }
}
