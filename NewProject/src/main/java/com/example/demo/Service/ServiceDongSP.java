package com.example.demo.Service;

import com.example.demo.model.DongSP;

import java.util.ArrayList;
import java.util.UUID;

public interface ServiceDongSP {
    ArrayList<DongSP> getAll();

    void save(DongSP dsp);
    void update(DongSP dsp);
    void delete(UUID id);
    DongSP getById(UUID id);
}
