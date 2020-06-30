package com.rodja.demo.service;

import com.rodja.demo.dao.MachineRepository;
import com.rodja.demo.entity.Machine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MachineServiceImpl implements MachineService {

    @Autowired
    private MachineRepository machineRepository;

    @Override
    @Transactional
    public List<Machine> getMachines() {
        return machineRepository.findAll();
    }

    @Override
    @Transactional
    public Machine getMachine(String id) {
        return machineRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void saveMachine(Machine machine) {
        machineRepository.save(machine);
    }

    @Override
    @Transactional
    public void deleteMachine(String id) {
        machineRepository.deleteById(id);
    }
}
