package com.rodja.demo.service;

import com.rodja.demo.dao.AssemblyRepository;
import com.rodja.demo.entity.Assembly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AssemblyServiceImpl implements AssemblyService {

    @Autowired
    private AssemblyRepository assemblyRepository;

    @Override
    @Transactional
    public List<Assembly> getAssemblies() {
        return assemblyRepository.findAll();
    }

    @Override
    @Transactional
    public Assembly getAssembly(String id) {
        return assemblyRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void saveAssembly(Assembly assembly) {
        assemblyRepository.save(assembly);
    }

    @Override
    @Transactional
    public void deleteAssembly(String id) {
        assemblyRepository.deleteById(id);
    }
}
