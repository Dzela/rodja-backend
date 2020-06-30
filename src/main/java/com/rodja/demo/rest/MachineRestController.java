package com.rodja.demo.rest;

import com.rodja.demo.entity.Machine;
import com.rodja.demo.service.MachineService;
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
@RequestMapping(value = "/api/machines")
public class MachineRestController {

    @Autowired
    private MachineService machineService;

    @GetMapping("/")
    public List<Machine> getMachines() {
        return machineService.getMachines();
    }

    @GetMapping("/{id}")
    public Machine getMachine(@PathVariable String id) {
        return machineService.getMachine(id);
    }

    @PostMapping("/")
    public String saveMachine(@RequestBody Machine machine) {
        machineService.saveMachine(machine);
        return "Saved machine with id: " + machine.getId();
    }

    @DeleteMapping("/{id}")
    public String deleteMachine(@PathVariable String id)  {
        machineService.deleteMachine(id);
        return "Deleted machine with id: " + id;
    }
}
