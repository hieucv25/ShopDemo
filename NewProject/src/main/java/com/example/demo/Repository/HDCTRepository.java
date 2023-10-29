package com.example.demo.Repository;

import com.example.demo.model.HDCT;
import com.example.demo.model.IdHoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HDCTRepository extends JpaRepository<HDCT, IdHoaDonChiTiet> {
    @Override
    <S extends HDCT> S saveAndFlush(S entity);

    @Override
    HDCT getOne(IdHoaDonChiTiet idHoaDonChiTiet);

    @Override
    List<HDCT> findAll();

    @Override
    <S extends HDCT> S save(S entity);

    @Override
    void deleteById(IdHoaDonChiTiet idHoaDonChiTiet);

    @Override
    boolean existsById(IdHoaDonChiTiet idHoaDonChiTiet);

    @Query("delete from HDCT hdct where hdct.id.hd.id = ?1")
    void deleteByIdHD(UUID id);

    @Query("select hdct from HDCT hdct where hdct.id.hd.id=?1")
    List<HDCT> getHDCTByIDHD(UUID id);
}
