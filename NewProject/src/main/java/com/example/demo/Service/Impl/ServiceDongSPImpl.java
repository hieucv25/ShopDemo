package com.example.demo.Service.Impl;

import com.example.demo.Repository.DongSPRepository;
import com.example.demo.Service.ServiceDongSP;
import com.example.demo.model.DongSP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class ServiceDongSPImpl implements ServiceDongSP {
    @Autowired
    DongSPRepository drp;
    @Override
    public ArrayList<DongSP> getAll() {
        return (ArrayList<DongSP>) drp.findAll();
    }

    @Override
    public void save(DongSP dsp) {
        drp.saveAndFlush(dsp);
    }

    @Override
    public void update(DongSP dsp) {
        drp.save(dsp);
    }

    @Override
    public void delete(UUID id) {
        drp.deleteById(id);
    }

    @Override
    public DongSP getById(UUID id) {
        return drp.getOne(id);
    }
}
