package com.example.demo.Service;

import com.example.demo.model.GioHang;

import java.util.List;
import java.util.UUID;

public interface ServiceGH {
    List<GioHang> getAll();

    GioHang getById(UUID id);

    void delete(UUID id);

    void update(GioHang gh);

    void save(GioHang gh);
}
