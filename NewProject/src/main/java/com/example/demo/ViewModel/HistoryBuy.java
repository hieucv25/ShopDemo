package com.example.demo.ViewModel;

import com.example.demo.model.IdHoaDonChiTiet;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Getter
@Setter
public class HistoryBuy {
    private Date dateTime;
    private Integer status;
    private String maHD;
}
