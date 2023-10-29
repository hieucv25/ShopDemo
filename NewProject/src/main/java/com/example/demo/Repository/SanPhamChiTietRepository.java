package com.example.demo.Repository;

import com.example.demo.model.SanPhamChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface SanPhamChiTietRepository extends JpaRepository<SanPhamChiTiet, UUID> {
    @Override
    List<SanPhamChiTiet> findAll();

    @Override
    void deleteById(UUID uuid);

    @Override
    SanPhamChiTiet getOne(UUID uuid);

    @Override
    <S extends SanPhamChiTiet> S saveAndFlush(S entity);

    @Override
    <S extends SanPhamChiTiet> S save(S entity);
}
