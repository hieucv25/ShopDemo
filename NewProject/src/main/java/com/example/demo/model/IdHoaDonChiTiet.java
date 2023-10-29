package com.example.demo.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdHoaDonChiTiet implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_hoa_don")
    @NotFound(action = NotFoundAction.IGNORE)
    private HoaDon hd;

    @ManyToOne
    @JoinColumn(name="id_chi_tiet_sp")
    private SanPhamChiTiet spct;
}
