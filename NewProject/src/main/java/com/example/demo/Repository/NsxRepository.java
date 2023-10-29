package com.example.demo.Repository;

import com.example.demo.model.Nsx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface NsxRepository extends JpaRepository<Nsx, UUID> {
    @Override
    List<Nsx> findAll();

    @Override
    <S extends Nsx> S saveAndFlush(S entity);

    @Override
    Nsx getOne(UUID uuid);

    @Override
    <S extends Nsx> S save(S entity);

    @Override
    void deleteById(UUID uuid);
}
