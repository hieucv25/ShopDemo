package com.example.demo.Service;

import com.example.demo.model.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ServiceHoaDon {
    List<HoaDon> getAll();
    HoaDon getById(UUID id);
    void save(HoaDon hd);
    void update(HoaDon hd);
    void delete(UUID id);
    boolean existById(UUID id);
    int countById(UUID id);
    List<HoaDon> searchByMa(String ma);
    Page<HoaDon> findAll(Pageable pageable);
    HoaDon getByMa(String ma);
    void deleteEntity(HoaDon hd);
}
