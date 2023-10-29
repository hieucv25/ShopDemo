package com.example.demo.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class IdGioHangChiTiet implements Serializable {
    @ManyToOne
    @JoinColumn(name="id_gio_hang")
    private GioHang gh;

    @ManyToOne
    @JoinColumn(name="id_chi_tiet_sp")
    private SanPhamChiTiet spct;
}
