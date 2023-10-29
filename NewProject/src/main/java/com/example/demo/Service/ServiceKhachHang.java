package com.example.demo.Service;

import com.example.demo.model.KhachHang;

import java.util.List;
import java.util.UUID;

public interface ServiceKhachHang {
    List<KhachHang> getAll();
    void save(KhachHang kh);
    void update(KhachHang kh);
    void delete(UUID id);
    KhachHang getById(UUID id);
    List<KhachHang> search(String keyword);
}
