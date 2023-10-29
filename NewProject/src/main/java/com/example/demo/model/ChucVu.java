package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name="chuc_vu")
@Table(name="chuc_vu")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChucVu {
    @Id
    @Column(name="id",unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name="ma",unique = true)
    private String ma;
    @Column(name="ten")
    private String ten;
}
