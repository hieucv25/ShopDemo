package com.example.demo.Service.Impl;

import com.example.demo.Repository.ChucVuRepository;
import com.example.demo.Service.ServiceChucVu;
import com.example.demo.model.ChucVu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceChuVuImpl implements ServiceChucVu {
    @Autowired
    ChucVuRepository cvrp;
    @Override
    public ArrayList<ChucVu> getAll() {
        return (ArrayList<ChucVu>) cvrp.findAll();
    }

    @Override
    public ChucVu findById(UUID id) {
        return cvrp.getOne(id);
    }

    @Override
    public void save(ChucVu cv) {
        cvrp.saveAndFlush(cv);
    }

    @Override
    public void delete(UUID id) {
        cvrp.deleteById(id);
    }

    @Override
    public void update(ChucVu cv) {
        cvrp.save(cv);
    }
}
