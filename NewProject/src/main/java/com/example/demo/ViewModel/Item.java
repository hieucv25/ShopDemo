package com.example.demo.ViewModel;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Item {
    private UUID idCTSP;
    private String tenSanPham;
    private Integer soLuong;
    private String mauSac;
    private BigDecimal giaBan;
}
