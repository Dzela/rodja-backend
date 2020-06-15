package com.rodja.demo.rest;

import com.rodja.demo.entity.Assembly;
import com.rodja.demo.service.AssemblyService;
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
@RequestMapping(value = "/api/assemblies")
public class AssemblyRestController {

    @Autowired
    private AssemblyService assemblyService;

    @GetMapping("/")
    public List<Assembly> getAssemblies() {
        return assemblyService.getAssemblies();
    }

    @GetMapping("/{id}")
    public Assembly getAssembly(@PathVariable String id) {
        return assemblyService.getAssembly(id);
    }

    @PostMapping("/")
    public String saveAssembly(@RequestBody Assembly assembly) {
        assemblyService.saveAssembly(assembly);
        return "Saved assembly with id: " + assembly.getId();
    }

    @DeleteMapping("/{id}")
    public String deleteAssembly(@PathVariable String id)  {
        assemblyService.deleteAssembly(id);
        return "Deleted assembly with id: " + id;
    }
}
