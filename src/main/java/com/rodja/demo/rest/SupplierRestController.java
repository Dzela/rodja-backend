package com.rodja.demo.rest;

import com.rodja.demo.entity.Supplier;
import com.rodja.demo.service.SupplierService;
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
@RequestMapping(value = "/api/suppliers")
public class SupplierRestController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/")
    public List<Supplier> getSuppliers() {
        return supplierService.getSuppliers();
    }

    @GetMapping("/{id}")
    public Supplier getSupplier(@PathVariable String id) {
        return supplierService.getSupplier(id);
    }

    @PostMapping("/")
    public String saveSupplier(@RequestBody Supplier supplier) {
        supplierService.saveSupplier(supplier);
        return "Saved supplier with id: " + supplier.getId();
    }

    @DeleteMapping("/{id}")
    public String deleteSupplier(@PathVariable String id) {
        supplierService.deleteSupplier(id);
        return "Deleted supplier with id: " + id;
    }
}
