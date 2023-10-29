package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name="hoa_don")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class HoaDon {
    @Id
    @Column(name="id",nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name="id_nv",nullable = false)
    private NhanVien nv;

    @ManyToOne
    @JoinColumn(name="id_kh",nullable = false)
    private KhachHang kh;

    @Column(name="ma",nullable = false,unique = true)
    private String ma;

    @Column(name="ngay_tao")
    private Date ngayTao;

    @Column(name="ngay_thanh_toan")
    private Date ngayThanhToan;

    @Column(name="ngay_ship")
    private Date ngayShip;

    @Column(name="ngay_nhan")
    private Date ngayNhan;

    @Column(name="tinh_trang")
    private int tinhTrang;

    @Column(name="ten_nguoi_nhan")
    private String tenNguoiNhan;

    @Column(name="dia_chi")
    private String diaChi;

    @Column(name="sdt")
    private String sdt;
}
