package com.example.demo.Service;

import com.example.demo.model.SanPhamChiTiet;

import java.util.ArrayList;
import java.util.UUID;

public interface ServiceSPCT {
    ArrayList<SanPhamChiTiet> getAll();

    void deleteById(UUID id);

    SanPhamChiTiet getOne(UUID id);

    void save(SanPhamChiTiet cpct);

    void update(SanPhamChiTiet scpt);
}
