package com.example.demo.Repository;

import com.example.demo.model.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang,UUID> {
    @Override
    <S extends GioHang> S saveAndFlush(S entity);

    @Override
    GioHang getOne(UUID uuid);

    @Override
    List<GioHang> findAll();

    @Override
    <S extends GioHang> S save(S entity);

    @Override
    void deleteById(UUID uuid);
}
