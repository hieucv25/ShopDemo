package com.example.demo.ViewModel;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Items {
    private String tenKH;
    private String tenSP;
    private String mauSac;
    private Date ngayTao;
    private UUID idCTSP;
    private Integer soLuong;
    private BigDecimal donGia;
}
