package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="dong_sp")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class DongSP {
    @Id
    @Column(name="id",nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="ma",unique = true)
    private String ma;

    @Column(name="ten")
    private String ten;

}
