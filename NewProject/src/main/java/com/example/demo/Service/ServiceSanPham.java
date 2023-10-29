package com.example.demo.Service;

import com.example.demo.Repository.SanPhamRepository;
import com.example.demo.model.SanPham;

import java.util.ArrayList;
import java.util.UUID;

public interface ServiceSanPham {
    ArrayList<SanPham> getAll();

    void save(SanPham sp);
    void update(SanPham sp);
    void delete(SanPham sp);
    SanPham getById(UUID id);
}
