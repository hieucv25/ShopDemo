package com.example.demo.Repository;

import com.example.demo.model.NhanVien;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {
    @Override
    List<NhanVien> findAll();

    @Override
    List<NhanVien> findAll(Sort sort);

    @Override
    void deleteById(UUID uuid);

    @Override
    NhanVien getOne(UUID uuid);

    @Override
    <S extends NhanVien> S save(S entity);

    @Override
    <S extends NhanVien> S saveAndFlush(S entity);

    @Query("select nv from NhanVien nv where nv.ten like ?1% or nv.ho like ?1% or nv.tenDem like ?1%")
    List<NhanVien> search(String keyword);
}
