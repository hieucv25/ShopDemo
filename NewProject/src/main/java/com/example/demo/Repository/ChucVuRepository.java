package com.example.demo.Repository;

import com.example.demo.model.ChucVu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, UUID> {
    @Override
    List<ChucVu> findAll();

    @Override
    ChucVu getOne(UUID uuid);

    @Override
    <S extends ChucVu> S saveAndFlush(S entity);

    @Override
    void deleteById(UUID uuid);

    @Override
    <S extends ChucVu> S save(S entity);


}
