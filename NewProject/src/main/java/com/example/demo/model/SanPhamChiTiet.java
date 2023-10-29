package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Transactional
@Entity
@Table(name="chi_tiet_sp")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class SanPhamChiTiet {
    @Id
    @Column(name="id",nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="nam_bh")
    private int namBH;

    @Column(name="mo_ta")
    private String moTa;

    @Column(name="so_luong_ton")
    private int slt;

    @Column(name="gia_nhap")
    private BigDecimal giaNhap;

    @Column(name="gia_ban")
    private BigDecimal giaBan;

    @ManyToOne
    @JoinColumn(name="id_sp")
    private SanPham sp;

    @ManyToOne
    @JoinColumn(name="id_mau_sac")
    private MauSac ms;

    @ManyToOne
    @JoinColumn(name="id_nsx")
    private Nsx nsx;

    @ManyToOne
    @JoinColumn(name="id_dong_sp")
    private DongSP dsp;
}
