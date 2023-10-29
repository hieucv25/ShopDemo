package com.example.demo.Service.Impl;

import com.example.demo.Repository.GHCTRepository;
import com.example.demo.Service.ServiceGHCT;
import com.example.demo.model.GioHangChiTiet;
import com.example.demo.model.IdGioHangChiTiet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceGHCTImpl implements ServiceGHCT {
    @Autowired
    GHCTRepository ghctrp;
    @Override
    public List<GioHangChiTiet> getAll() {
        return ghctrp.findAll();
    }

    @Override
    public GioHangChiTiet getById(IdGioHangChiTiet id) {
        return ghctrp.getOne(id);
    }

    @Override
    public void delete(IdGioHangChiTiet id) {
        ghctrp.deleteById(id);
    }

    @Override
    public void save(GioHangChiTiet ghct) {
        ghctrp.saveAndFlush(ghct);
    }

    @Override
    public void update(GioHangChiTiet ghct) {
        ghctrp.save(ghct);
    }
}
