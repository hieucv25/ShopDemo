package com.example.demo.Service;
import com.example.demo.model.CuaHang;

import java.util.List;
import java.util.UUID;

public interface ServiceCuaHang {
    List<CuaHang> getAll();

    CuaHang getById(UUID id);

    void save(CuaHang ch);

    void delete(UUID id);

    void update(CuaHang ch);

}
