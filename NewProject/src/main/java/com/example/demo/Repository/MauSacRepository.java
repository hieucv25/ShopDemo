package com.example.demo.Repository;

import com.example.demo.model.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface MauSacRepository extends JpaRepository<MauSac, UUID> {
    @Override
    List<MauSac> findAll();

    @Override
    <S extends MauSac> S saveAndFlush(S entity);

    @Override
    MauSac getOne(UUID uuid);

    @Override
    <S extends MauSac> S save(S entity);

    @Override
    void deleteById(UUID uuid);
}
