package com.example.demo.Service;

import com.example.demo.model.NhanVien;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface ServiceNhanVien {
    ArrayList<NhanVien> getAll();
    void save(NhanVien nv);
    void delete(UUID id);
    NhanVien getById(UUID id);
    void update(NhanVien nv);
    List<NhanVien> search(String keyword);
}
