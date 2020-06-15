package com.rodja.demo.dao;

import com.rodja.demo.entity.Assembly;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssemblyRepository extends JpaRepository<Assembly, String> {
}
