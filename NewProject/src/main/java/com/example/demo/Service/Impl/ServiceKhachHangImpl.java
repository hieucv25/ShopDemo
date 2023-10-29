package com.example.demo.Service.Impl;

import com.example.demo.Repository.KhachHangRepository;
import com.example.demo.Service.ServiceKhachHang;
import com.example.demo.model.KhachHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceKhachHangImpl implements ServiceKhachHang {
    @Autowired
    KhachHangRepository khrp;
    @Override
    public List<KhachHang> getAll() {
        return khrp.findAll();
    }

    @Override
    public void save(KhachHang kh) {
        khrp.saveAndFlush(kh);
    }

    @Override
    public void update(KhachHang kh) {
        khrp.save(kh);
    }

    @Override
    public void delete(UUID id) {
        khrp.deleteById(id);
    }

    @Override
    public KhachHang getById(UUID id) {
        return khrp.getOne(id);
    }

    @Override
    public List<KhachHang> search(String keyword) {
        return khrp.search(keyword);
    }
}
