package com.example.demo.Service;

import com.example.demo.model.Nsx;

import java.util.ArrayList;
import java.util.UUID;

public interface ServiceNsx {
    ArrayList<Nsx> getAll();

    void save(Nsx nsx);
    void update(Nsx nsx);
    void delete(UUID id);
    Nsx getById(UUID id);
}
