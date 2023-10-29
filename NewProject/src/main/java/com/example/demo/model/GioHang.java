package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name="gio_hang")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class GioHang {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name="ma",unique = true)
    private String ma;
    @ManyToOne
    @JoinColumn(name="id_kh",nullable = false)
    private KhachHang kh;
    @Column(name="ngay_tao")
    private Date ngayTao;

}
