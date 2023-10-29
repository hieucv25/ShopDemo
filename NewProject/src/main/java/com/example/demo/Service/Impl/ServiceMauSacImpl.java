package com.example.demo.Service.Impl;

import com.example.demo.Repository.MauSacRepository;
import com.example.demo.Service.ServiceMauSac;
import com.example.demo.model.MauSac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class ServiceMauSacImpl implements ServiceMauSac {
    @Autowired
    MauSacRepository msrp;
    @Override
    public ArrayList<MauSac> getAll() {
        return (ArrayList<MauSac>) msrp.findAll();
    }

    @Override
    public void save(MauSac ms) {
        msrp.saveAndFlush(ms);
    }

    @Override
    public void update(MauSac ms) {
        msrp.save(ms);
    }

    @Override
    public void delete(UUID id) {
        msrp.deleteById(id);
    }

    @Override
    public MauSac getById(UUID id) {
        return msrp.getOne(id);
    }
}
