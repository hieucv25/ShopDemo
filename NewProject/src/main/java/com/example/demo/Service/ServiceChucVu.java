package com.example.demo.Service;

import com.example.demo.model.ChucVu;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public interface ServiceChucVu {
    ArrayList<ChucVu> getAll();
    ChucVu findById(UUID id);
    void save(ChucVu cv);
    void delete(UUID id);
    void update(ChucVu cv);
}
