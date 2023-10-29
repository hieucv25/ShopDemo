package com.example.demo.Repository;

import com.example.demo.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {
    @Override
    List<SanPham> findAll();

    @Override
    <S extends SanPham> S save(S entity);

    @Override
    <S extends SanPham> S saveAndFlush(S entity);

    @Override
    SanPham getOne(UUID uuid);

    @Override
    void deleteById(UUID uuid);

    @Override
    void delete(SanPham entity);
}
