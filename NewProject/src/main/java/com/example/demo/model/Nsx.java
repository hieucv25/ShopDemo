package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="nxs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Nsx {
    @Id
    @Column(name="id",nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="ma",unique = true)
    private String ma;

    @Column(name="ten")
    private String ten;

}
