package com.example.demo.Repository;

import com.example.demo.model.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CuaHangRepository extends JpaRepository<CuaHang, UUID> {
    @Override
    <S extends CuaHang> S saveAndFlush(S entity);

    @Override
    CuaHang getOne(UUID uuid);

    @Override
    List<CuaHang> findAll();

    @Override
    <S extends CuaHang> S save(S entity);

    @Override
    void deleteById(UUID uuid);
}
