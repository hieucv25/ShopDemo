package com.example.demo.Service.Impl;

import com.example.demo.Repository.NhanVienRepository;
import com.example.demo.Service.ServiceNhanVien;
import com.example.demo.model.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ServiceNhanVienImpl implements ServiceNhanVien {
    @Autowired
    NhanVienRepository nvrp;
    @Override
    public ArrayList<NhanVien> getAll() {
        Sort sort = Sort.by(Sort.Direction.DESC,"ngaySinh");
        return (ArrayList<NhanVien>) nvrp.findAll(sort);
    }

    @Override
    public void delete(UUID id) {
        nvrp.deleteById(id);
    }

    @Override
    public NhanVien getById(UUID id) {
        return nvrp.getOne(id);
    }

    @Override
    public void update(NhanVien nv) {
        nvrp.save(nv);
    }

    @Override
    public void save(NhanVien nv) {
        nvrp.saveAndFlush(nv);
    }

    @Override
    public List<NhanVien> search(String keyword) {
        return nvrp.search(keyword);
    }
}
