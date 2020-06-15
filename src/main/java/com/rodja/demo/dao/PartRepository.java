package com.rodja.demo.dao;

import com.rodja.demo.entity.Assembly;
import com.rodja.demo.entity.Part;
import com.rodja.demo.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartRepository extends JpaRepository<Part, String> {

    public List<Part> getPartsByAssembly(Assembly assembly);

    public List<Part> getPartsBySupplier(Supplier supplier);
    
}
