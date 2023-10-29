package com.example.demo.Service.Impl;

import com.example.demo.Repository.SanPhamRepository;
import com.example.demo.Service.ServiceSanPham;
import com.example.demo.model.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class ServiceSanPhamImpl implements ServiceSanPham {
    @Autowired
    SanPhamRepository sprp;
    @Override
    public ArrayList<SanPham> getAll() {
        return (ArrayList<SanPham>) sprp.findAll();
    }

    @Override
    public void save(SanPham sp) {
        sprp.saveAndFlush(sp);
    }

    @Override
    public void update(SanPham sp) {
        sprp.save(sp);
    }

    @Override
    public void delete(SanPham sp) {
        sprp.delete(sp);
    }

    @Override
    public SanPham getById(UUID id) {
        return sprp.getOne(id);
    }
}
