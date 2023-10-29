package com.example.demo.Repository;

import com.example.demo.model.GioHangChiTiet;
import com.example.demo.model.IdGioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GHCTRepository extends JpaRepository<GioHangChiTiet, IdGioHangChiTiet> {
    @Override
    <S extends GioHangChiTiet> S saveAndFlush(S entity);

    @Override
    GioHangChiTiet getOne(IdGioHangChiTiet idGioHangChiTiet);

    @Override
    List<GioHangChiTiet> findAll();

    @Override
    <S extends GioHangChiTiet> S save(S entity);

    @Override
    void deleteById(IdGioHangChiTiet idGioHangChiTiet);
}
