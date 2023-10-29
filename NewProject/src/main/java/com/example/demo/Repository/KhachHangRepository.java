package com.example.demo.Repository;

import com.example.demo.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {
    @Override
    <S extends KhachHang> S saveAndFlush(S entity);

    @Override
    KhachHang getOne(UUID uuid);

    @Override
    List<KhachHang> findAll();

    @Override
    <S extends KhachHang> S save(S entity);

    @Override
    void deleteById(UUID uuid);

    @Query("select kh from KhachHang kh where kh.ten like ?1% or kh.ho like ?1% or kh.tenDem like ?1%")
    List<KhachHang> search(String keyword);
}
