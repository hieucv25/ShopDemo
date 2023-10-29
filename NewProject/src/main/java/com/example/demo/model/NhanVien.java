package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Generated;

import java.sql.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="nhan_vien")
public class NhanVien {
    @Id
    @Column(name="id",unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="ma",unique = true,length = 20)
    private String ma;

    @Column(name="ten",length = 30)
    private String ten;

    @Column(name="ten_dem",length = 30)
    private String tenDem;

    @Column(name="ho",length = 30)
    private String ho;

    @Column(name="gioi_tinh",length = 10)
    private String gioiTinh;

    @Column(name="ngay_sinh")
    private Date ngaySinh;

    @Column(name="dia_chi",length = 100)
    private String diaChi;

    @Column(name="sdt",length = 30)
    private String sdt;

    @Column(name="mat_khau")
    private String matKhau;

    @Column(name="trang_thai")
    private int trangThai;

    @ManyToOne
    @JoinColumn(name="id_cv",nullable = false)
    private ChucVu cv;
    @OneToOne
    @JoinColumn(name="id_ch")
    private CuaHang ch;
}
