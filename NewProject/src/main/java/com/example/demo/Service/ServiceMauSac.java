package com.example.demo.Service;

import com.example.demo.model.MauSac;

import java.util.ArrayList;
import java.util.UUID;

public interface ServiceMauSac {
    ArrayList<MauSac> getAll();

    void save(MauSac ms);

    void update(MauSac ms);

    void delete(UUID id);

    MauSac getById(UUID id);
}
