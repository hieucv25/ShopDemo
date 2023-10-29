package com.example.demo.Service;

import com.example.demo.model.HDCT;
import com.example.demo.model.IdHoaDonChiTiet;

import java.util.List;
import java.util.UUID;

public interface ServiceHDCT {
    List<HDCT> getAll();
    HDCT getById(IdHoaDonChiTiet id);
    void delete(IdHoaDonChiTiet id);
    void save(HDCT hdct);
    void update(HDCT hdct);
    Boolean existById(IdHoaDonChiTiet id);
    void deleteByIdHD(UUID id);
    List<HDCT> findByIDHD(UUID id);
}
