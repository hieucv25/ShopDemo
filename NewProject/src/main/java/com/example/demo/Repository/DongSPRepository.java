package com.example.demo.Repository;

import com.example.demo.model.DongSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface DongSPRepository extends JpaRepository<DongSP, UUID> {
    @Override
    List<DongSP> findAll();

    @Override
    <S extends DongSP> S saveAndFlush(S entity);

    @Override
    DongSP getOne(UUID uuid);

    @Override
    <S extends DongSP> S save(S entity);

    @Override
    void deleteById(UUID uuid);
}
