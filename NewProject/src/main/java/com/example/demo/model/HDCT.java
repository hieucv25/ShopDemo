package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="hoa_don_chi_tiet")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HDCT{

    @EmbeddedId
    private IdHoaDonChiTiet id;

    @Column(name="so_luong")
    private int soLuong;

    @Column(name="don_gia")
    private BigDecimal donGia;
}
