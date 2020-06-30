package com.rodja.demo.rest;

import com.rodja.demo.entity.Material;
import com.rodja.demo.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/materials")
public class MaterialRestController {

    @Autowired
    private MaterialService materialService;

    @GetMapping("/")
    public List<Material> getMaterials() {
        return materialService.getMaterials();
    }

    @GetMapping("/{id}")
    public Material getMaterial(@PathVariable String id) {
        return materialService.getMaterial(id);
    }

    @PostMapping("/")
    public String saveMaterial(@RequestBody Material material) {
        materialService.saveMaterial(material);
        return "Saved material with id: " + material.getId();
    }

    @DeleteMapping("/{id}")
    public String deleteMaterial(@PathVariable String id)  {
        materialService.deleteMaterial(id);
        return "Deleted material with id: " + id;
    }
}
