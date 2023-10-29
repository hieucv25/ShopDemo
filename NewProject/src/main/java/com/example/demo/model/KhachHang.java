package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name="khach_hang")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KhachHang {
    @Id
    @Column(name="id",nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name="ma",unique = true,length = 20)
    private String ma;

    @Column(name="ten",length = 30)
    private String ten;

    @Column(name="ten_dem",length = 30)
    private String tenDem;

    @Column(name="ho",length = 30)
    private String ho;

    @Column(name="ngay_sinh")
    private Date ngaySinh;

    @Column(name="dia_chi",length = 100)
    private String diaChi;

    @Column(name="sdt",length = 30)
    private String sdt;

    @Column(name="thanh_pho",length = 30)
    private String thanhPho;

    @Column(name="quoc_gia",length = 30)
    private String quocGia;

    @Column(name="mat_khau",length = 30)
    private String matKhau;
}
