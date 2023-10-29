package com.example.demo.controller;

import com.example.demo.Service.ServiceHDCT;
import com.example.demo.Service.ServiceHoaDon;
import com.example.demo.Service.ServiceSPCT;
import com.example.demo.model.HDCT;
import com.example.demo.model.IdHoaDonChiTiet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@Controller
@RequestMapping("/hdct")
public class HDCTController {
    @Autowired
    ServiceHDCT svhdct;
    @Autowired
    ServiceSPCT svspct;
    @Autowired
    ServiceHoaDon svhd;
    @GetMapping("/index")
    public String view(Model model){
        model.addAttribute("list",svhdct.getAll());
        model.addAttribute("view","HDCT/index.jsp");
        return "layout";
    }
    @GetMapping("/detail")
    public String detail(Model model,
                         @RequestParam("idCTSP") String idCTSP,
                         @RequestParam("idHD") String idHD
                         ){
        model.addAttribute("hdct",
                svhdct.getById(new IdHoaDonChiTiet(svhd.getById(UUID.fromString(idHD))
                        ,svspct.getOne(UUID.fromString(idCTSP)  ))));
        model.addAttribute("list",svhdct.getAll());
        model.addAttribute("view","HDCT/index.jsp");
        return "layout";
    }
    @PostMapping("/update")
    public String update(Model model,
                         @RequestParam("idCTSP") String idCTSP,
                         @RequestParam("idHD") String idHD,
                         @RequestParam("soLuong") String soLuong,
                         @RequestParam("donGia") String donGia
    ){
        HDCT hdct = svhdct.getById(new IdHoaDonChiTiet(svhd.getById(UUID.fromString(idHD)),svspct.getOne(UUID.fromString(idCTSP))));
        Double donGiaD = Double.parseDouble(donGia);
        hdct.setDonGia(BigDecimal.valueOf(donGiaD));
        hdct.setSoLuong(Integer.valueOf(soLuong));
        svhdct.update(hdct);
        model.addAttribute("list",svhdct.getAll());
        model.addAttribute("view","HDCT/index.jsp");
        return "layout";
    }
}
