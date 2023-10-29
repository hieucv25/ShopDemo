package com.example.demo.Service.Impl;

import com.example.demo.Repository.NsxRepository;
import com.example.demo.Service.ServiceNsx;
import com.example.demo.model.Nsx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class ServiceNsxImpl implements ServiceNsx {
    @Autowired
    NsxRepository nrp;
    @Override
    public ArrayList<Nsx> getAll() {
        return (ArrayList<Nsx>) nrp.findAll();
    }

    @Override
    public void save(Nsx nsx) {
        nrp.saveAndFlush(nsx);
    }

    @Override
    public void update(Nsx nsx) {
        nrp.save(nsx);
    }

    @Override
    public void delete(UUID id) {
        nrp.deleteById(id);
    }

    @Override
    public Nsx getById(UUID id) {
        return nrp.getOne(id);
    }
}
