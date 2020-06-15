package com.rodja.demo.service;

import com.rodja.demo.entity.Assembly;

import java.util.List;

public interface AssemblyService {

    public List<Assembly> getAssemblies();
    public Assembly getAssembly(String id);
    public void saveAssembly(Assembly assembly);
    public void deleteAssembly(String id);

}
