package com.example.demo.Repository;

import com.example.demo.model.HDCT;
import com.example.demo.model.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {
    @Override
    <S extends HoaDon> S saveAndFlush(S entity);

    @Override
    HoaDon getOne(UUID uuid);

    @Override
    List<HoaDon> findAll();

    @Override
    <S extends HoaDon> S save(S entity);

    @Override
    void deleteById(UUID uuid);

    @Override
    void delete(HoaDon entity);

    @Override
    boolean existsById(UUID uuid);

    @Query("select count(hd.kh.id) from HoaDon hd where hd.kh.id = ?1")
    int countById(UUID id);

    @Query("select hd from HoaDon hd where hd.ma like ?1")
    List<HoaDon> searchByMa(String ma);

    @Override
    Page<HoaDon> findAll(Pageable pageable);
    @Query("select hd from HoaDon hd where hd.ma=?1")
    HoaDon getHDByMa(String ma);
}
