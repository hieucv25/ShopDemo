package com.example.demo.Service.Impl;

import com.example.demo.Repository.HDCTRepository;
import com.example.demo.Service.ServiceHDCT;
import com.example.demo.model.HDCT;
import com.example.demo.model.IdHoaDonChiTiet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceHDCTImpl implements ServiceHDCT {
    @Autowired
    HDCTRepository hdctrp;
    @Override
    public List<HDCT> getAll() {
        return hdctrp.findAll();
    }

    @Override
    public HDCT getById(IdHoaDonChiTiet id) {
        return hdctrp.getOne(id);
    }

    @Override
    public void delete(IdHoaDonChiTiet id) {
        hdctrp.deleteById(id);
    }

    @Override
    public void save(HDCT hdct) {
        hdctrp.saveAndFlush(hdct);
    }

    @Override
    public void update(HDCT hdct) {
        hdctrp.save(hdct);
    }

    @Override
    public Boolean existById(IdHoaDonChiTiet id) {
        return hdctrp.existsById(id);
    }

    @Override
    public void deleteByIdHD(UUID id) {
        hdctrp.deleteByIdHD(id);
    }

    @Override
    public List<HDCT> findByIDHD(UUID id) {
        return hdctrp.getHDCTByIDHD(id);
    }
}
