package com.rodja.demo.dao;

import com.rodja.demo.entity.Assembly;
import com.rodja.demo.entity.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssemblyRepository extends JpaRepository<Assembly, String> {

    public List<Assembly> getAssembliesByMachine(Machine machine);
}
