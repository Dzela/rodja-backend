package com.rodja.demo.rest;

import com.rodja.demo.entity.Part;
import com.rodja.demo.service.PartService;
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
@RequestMapping(value = "/api/parts")
public class PartRestController {

    @Autowired
    private PartService partService;

    @GetMapping("/")
    public List<Part> getParts() {
        return partService.getParts();
    }

    @GetMapping("/{id}")
    public Part getPart(@PathVariable String id)  {
        return partService.getPart(id);
    }

    @PostMapping("/")
    public String savePart(@RequestBody Part part) {
        partService.savePart(part);
        return "Saved part with id: " + part.getId();
    }

    @DeleteMapping("/{id}")
    public String deletePart(@PathVariable String id) {
        partService.deletePart(id);
        return "Deleted part with id: " + id;
    }

    @GetMapping("/assembly/{assemblyId}")
    public List<Part> getPartsByAssembly(@PathVariable String assemblyId) {
        return partService.getPartsByAssembly(assemblyId);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<Part> getPartsBySupplier(@PathVariable String supplierId) {
        return partService.getPartsBySupplier(supplierId);
    }

    @GetMapping("/material/{materialId}")
    public List<Part> getPartsByMaterial(@PathVariable String materialId) {
        return partService.getPartsByMaterial(materialId);
    }

    @GetMapping("/machine/{machineId}")
    public List<Part> getPartsByMachine(@PathVariable String machineId) {
        return partService.getPartsByMachine(machineId);
    }

}
