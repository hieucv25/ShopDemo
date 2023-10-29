package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name="gio_hang_chi_tiet")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class GioHangChiTiet {
    @EmbeddedId
    private IdGioHangChiTiet id;

    @Column(name="so_luong")
    private Integer soLuong;

    @Column(name="don_gia")
    private BigDecimal donGia;

    @Column(name="don_gia_khi_giam")
    private BigDecimal donGiaKhiGiam;

}
