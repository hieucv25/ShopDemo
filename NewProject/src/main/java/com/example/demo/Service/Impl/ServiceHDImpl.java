package com.example.demo.Service.Impl;

import com.example.demo.Repository.HoaDonRepository;
import com.example.demo.Service.ServiceHoaDon;
import com.example.demo.model.HoaDon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class ServiceHDImpl implements ServiceHoaDon {
    @Autowired
    HoaDonRepository hdrp;
    @Override
    public List<HoaDon> getAll() {
        return hdrp.findAll();
    }

    @Override
    public HoaDon getById(UUID id) {
        return hdrp.getOne(id);
    }

    @Override
    public void save(HoaDon hd) {
        hdrp.saveAndFlush(hd);
    }

    @Override
    public void update(HoaDon hd) {
        hdrp.save(hd);
    }

    @Override
    public void delete(UUID id) {
        hdrp.deleteById(id);
    }

    @Override
    public boolean existById(UUID id) {
        return hdrp.existsById(id);
    }

    @Override
    public int countById(UUID id) {
        return hdrp.countById(id);
    }

    @Override
    public List<HoaDon> searchByMa(String ma) {
        return hdrp.searchByMa(ma);
    }

    @Override
    public Page<HoaDon> findAll(Pageable pageable) {
        return hdrp.findAll(pageable);
    }

    @Override
    public HoaDon getByMa(String ma) {
        return hdrp.getHDByMa(ma);
    }

    @Override
    public void deleteEntity(HoaDon hd) {
        hdrp.delete(hd);
    }

}
