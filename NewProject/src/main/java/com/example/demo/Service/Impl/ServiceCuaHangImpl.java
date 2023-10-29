package com.example.demo.Service.Impl;

import com.example.demo.Repository.CuaHangRepository;
import com.example.demo.Service.ServiceCuaHang;
import com.example.demo.model.CuaHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceCuaHangImpl implements ServiceCuaHang {
    @Autowired
    CuaHangRepository chrp;
    @Override
    public List<CuaHang> getAll() {
        return chrp.findAll();
    }

    @Override
    public CuaHang getById(UUID id) {
        return chrp.getOne(id);
    }

    @Override
    public void save(CuaHang ch) {
        chrp.saveAndFlush(ch);
    }

    @Override
    public void delete(UUID id) {
        chrp.deleteById(id);
    }

    @Override
    public void update(CuaHang ch) {
        chrp.save(ch);
    }
}
