package com.example.demo.Service;

import com.example.demo.model.GioHangChiTiet;
import com.example.demo.model.IdGioHangChiTiet;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;

public interface ServiceGHCT {
    List<GioHangChiTiet> getAll();

    GioHangChiTiet getById(IdGioHangChiTiet id);

    void delete(IdGioHangChiTiet id);

    void save(GioHangChiTiet ghct);

    void update(GioHangChiTiet ghct);
}
