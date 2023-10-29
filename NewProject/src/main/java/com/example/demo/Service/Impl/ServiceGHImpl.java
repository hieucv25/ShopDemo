package com.example.demo.Service.Impl;

import com.example.demo.Repository.GioHangRepository;
import com.example.demo.Service.ServiceGH;
import com.example.demo.model.GioHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceGHImpl implements ServiceGH {
    @Autowired
    GioHangRepository ghrp;
    @Override
    public List<GioHang> getAll() {
        return ghrp.findAll();
    }

    @Override
    public GioHang getById(UUID id) {
        return ghrp.getOne(id);
    }

    @Override
    public void delete(UUID id) {
        ghrp.deleteById(id);
    }

    @Override
    public void update(GioHang gh) {
        ghrp.save(gh);
    }

    @Override
    public void save(GioHang gh) {
        ghrp.saveAndFlush(gh);
    }
}
