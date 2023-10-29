package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name="cua_hang")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class CuaHang {
    @Id
    @Column(name="id",unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name="ma",unique = true)
    private String ma;
    @Column(name="ten")
    private String ten;
    @Column(name="dia_chi")
    private String diaChi;
    @Column(name="thanh_pho")
    private String thanhPho;
    @Column(name="quoc_gia")
    private String quocGia;
}
