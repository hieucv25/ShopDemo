package com.example.demo.Service.Impl;

import com.example.demo.Repository.SanPhamChiTietRepository;
import com.example.demo.Service.ServiceSPCT;
import com.example.demo.model.SanPhamChiTiet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class ServiceSPCTImpl implements ServiceSPCT {
    @Autowired
    SanPhamChiTietRepository spctrp;
    @Override
    public ArrayList<SanPhamChiTiet> getAll() {
        return (ArrayList<SanPhamChiTiet>) spctrp.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        spctrp.deleteById(id);
    }

    @Override
    public SanPhamChiTiet getOne(UUID id) {
        return spctrp.getOne(id);
    }

    @Override
    public void save(SanPhamChiTiet cpct) {
        spctrp.saveAndFlush(cpct);
    }

    @Override
    public void update(SanPhamChiTiet scpt) {
        spctrp.save(scpt);
    }
}
