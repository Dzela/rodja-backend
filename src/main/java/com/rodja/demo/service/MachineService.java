package com.rodja.demo.service;

import com.rodja.demo.entity.Machine;

import java.util.List;

public interface MachineService {

    public List<Machine> getMachines();
    public Machine getMachine(String id);
    public void saveMachine(Machine machine);
    public void deleteMachine(String id);

}
