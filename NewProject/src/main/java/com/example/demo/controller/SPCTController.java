package com.example.demo.controller;

import com.example.demo.Service.*;
import com.example.demo.model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.UUID;

@Controller
@RequestMapping("/spct")
public class SPCTController {
    @Autowired
    ServiceSanPham svsp;
    @Autowired
    ServiceMauSac svms;
    @Autowired
    ServiceNsx svnsx;
    @Autowired
    ServiceDongSP svdsp;
    @Autowired
    ServiceSPCT svspct;
    @GetMapping("/index")
    private String home(Model model){
        model.addAttribute("listSP",svsp.getAll());
        model.addAttribute("listMS",svms.getAll());
        model.addAttribute("listNSX",svnsx.getAll());
        model.addAttribute("listDSP",svdsp.getAll());
        model.addAttribute("listSPCT",svspct.getAll());
        model.addAttribute("view","SPCT/index.jsp");
        return "layout";
    }
    @GetMapping("/delete/{id}")
    private String delete(Model model, @PathVariable("id") String id){
        model.addAttribute("listSP",svsp.getAll());
        model.addAttribute("listMS",svms.getAll());
        model.addAttribute("listNSX",svnsx.getAll());
        model.addAttribute("listDSP",svdsp.getAll());
        model.addAttribute("listSPCT",svspct.getAll());
        model.addAttribute("view","SPCT/index.jsp");
        UUID uuid = UUID.fromString(id);
        svspct.deleteById(uuid);
        return "layout";
    }
    @PostMapping("/save")
    private String save(Model model, @RequestParam(value = "sp",required = false) String id_sp,
                        @RequestParam(value = "ms",required = false) String id_ms,
                        @RequestParam(value = "nsx",required = false) String id_nsx,
                        @RequestParam(value = "dsp",required = false) String id_dsp,
                        @RequestParam("namBH") String namBH,
                        @RequestParam("moTa") String moTa,
                        @RequestParam("giaNhap") String giaNhap,
                        @RequestParam("giaBan") String giaBan,
                        @RequestParam("slt") String slt) {

        SanPhamChiTiet spct = new SanPhamChiTiet();
        if(id_sp.equals("null")){
            model.addAttribute("message","Product is not selected!");
            model.addAttribute("listSP",svsp.getAll());
            model.addAttribute("listMS",svms.getAll());
            model.addAttribute("listNSX",svnsx.getAll());
            model.addAttribute("listDSP",svdsp.getAll());
            model.addAttribute("listSPCT",svspct.getAll());
            model.addAttribute("view","SPCT/index.jsp");
            model.addAttribute("spct",spct);
            return "layout";
        }
        SanPham sp = svsp.getById(UUID.fromString(id_sp));
        spct.setSp(sp);
        if(id_nsx.equals("null")){
            model.addAttribute("message","Category is not selected!");
            model.addAttribute("listSP",svsp.getAll());
            model.addAttribute("listMS",svms.getAll());
            model.addAttribute("listNSX",svnsx.getAll());
            model.addAttribute("listDSP",svdsp.getAll());
            model.addAttribute("listSPCT",svspct.getAll());
            model.addAttribute("view","SPCT/index.jsp");
            model.addAttribute("spct",spct);
            return "layout";
        }
        Nsx nsx = svnsx.getById(UUID.fromString(id_nsx));
        spct.setNsx(nsx);
        if(id_dsp.equals("null")){
            model.addAttribute("message","Product Line is not selected!");
            model.addAttribute("listSP",svsp.getAll());
            model.addAttribute("listMS",svms.getAll());
            model.addAttribute("listNSX",svnsx.getAll());
            model.addAttribute("listDSP",svdsp.getAll());
            model.addAttribute("listSPCT",svspct.getAll());
            model.addAttribute("view","SPCT/index.jsp");
            model.addAttribute("spct",spct);
            return "layout";
        }
        DongSP dsp = svdsp.getById(UUID.fromString(id_dsp));
        spct.setDsp(dsp);
        if(id_ms.equals("null")){
            model.addAttribute("message","Color is not selected!");
            model.addAttribute("listSP",svsp.getAll());
            model.addAttribute("listMS",svms.getAll());
            model.addAttribute("listNSX",svnsx.getAll());
            model.addAttribute("listDSP",svdsp.getAll());
            model.addAttribute("listSPCT",svspct.getAll());
            model.addAttribute("view","SPCT/index.jsp");
            model.addAttribute("spct",spct);
            return "layout";
        }
        MauSac ms = svms.getById(UUID.fromString(id_ms));
        spct.setMs(ms);
        if(namBH.isEmpty()){
            model.addAttribute("validateNamBH","Warranty year has not been entered!");
            model.addAttribute("listSP",svsp.getAll());
            model.addAttribute("listMS",svms.getAll());
            model.addAttribute("listNSX",svnsx.getAll());
            model.addAttribute("listDSP",svdsp.getAll());
            model.addAttribute("listSPCT",svspct.getAll());
            model.addAttribute("view","SPCT/index.jsp");
            model.addAttribute("spct",spct);
            return "layout";
        }
        if(!namBH.matches("[0-9]+")){
            model.addAttribute("validateNamBH","Warranty year must be number!");
            model.addAttribute("listSP",svsp.getAll());
            model.addAttribute("listMS",svms.getAll());
            model.addAttribute("listNSX",svnsx.getAll());
            model.addAttribute("listDSP",svdsp.getAll());
            model.addAttribute("listSPCT",svspct.getAll());
            model.addAttribute("spct",spct);
            model.addAttribute("view","SPCT/index.jsp");
            return "layout";
        }
        spct.setNamBH(Integer.valueOf(namBH));
        if(moTa.isEmpty()){
            model.addAttribute("validateMoTa","Describe has not been entered!");
            model.addAttribute("listSP",svsp.getAll());
            model.addAttribute("listMS",svms.getAll());
            model.addAttribute("listNSX",svnsx.getAll());
            model.addAttribute("listDSP",svdsp.getAll());
            model.addAttribute("listSPCT",svspct.getAll());
            model.addAttribute("spct",spct);
            model.addAttribute("view","SPCT/index.jsp");
            return "layout";
        }
        if(!moTa.matches("[0-9a-zA-Z\\s \\W]{1,50}$")){
            model.addAttribute("validateMoTa","Describe no more than 50 characters!");
            model.addAttribute("listSP",svsp.getAll());
            model.addAttribute("listMS",svms.getAll());
            model.addAttribute("listNSX",svnsx.getAll());
            model.addAttribute("listDSP",svdsp.getAll());
            model.addAttribute("listSPCT",svspct.getAll());
            model.addAttribute("spct",spct);
            model.addAttribute("view","SPCT/index.jsp");
            return "layout";
        }
        spct.setMoTa(moTa);
        if(giaNhap.isEmpty()){
            model.addAttribute("validateGiaNhap","Import price has not been entered!");
            model.addAttribute("listSP",svsp.getAll());
            model.addAttribute("listMS",svms.getAll());
            model.addAttribute("listNSX",svnsx.getAll());
            model.addAttribute("listDSP",svdsp.getAll());
            model.addAttribute("listSPCT",svspct.getAll());
            model.addAttribute("spct",spct);
            model.addAttribute("view","SPCT/index.jsp");
            return "layout";
        }
        if(!giaNhap.matches("[1-9][0-9]+(.0)?$")){
            model.addAttribute("validateGiaNhap","Import price must be number!");
            model.addAttribute("listSP",svsp.getAll());
            model.addAttribute("listMS",svms.getAll());
            model.addAttribute("listNSX",svnsx.getAll());
            model.addAttribute("listDSP",svdsp.getAll());
            model.addAttribute("listSPCT",svspct.getAll());
            model.addAttribute("spct",spct);
            model.addAttribute("view","SPCT/index.jsp");
            return "layout";
        }
        spct.setGiaNhap(BigDecimal.valueOf(Double.valueOf(giaNhap)));
        if(giaBan.isEmpty()){
            model.addAttribute("validateGiaBan","Price has not been entered!");
            model.addAttribute("listSP",svsp.getAll());
            model.addAttribute("listMS",svms.getAll());
            model.addAttribute("listNSX",svnsx.getAll());
            model.addAttribute("listDSP",svdsp.getAll());
            model.addAttribute("listSPCT",svspct.getAll());
            model.addAttribute("spct",spct);
            model.addAttribute("view","SPCT/index.jsp");
            return "layout";
        }
        if(!giaBan.matches("[1-9][0-9]+(.0)?$")){
            model.addAttribute("validateGiaBan","Price must be number!");
            model.addAttribute("listSP",svsp.getAll());
            model.addAttribute("listMS",svms.getAll());
            model.addAttribute("listNSX",svnsx.getAll());
            model.addAttribute("listDSP",svdsp.getAll());
            model.addAttribute("listSPCT",svspct.getAll());
            model.addAttribute("spct",spct);
            model.addAttribute("view","SPCT/index.jsp");
            return "layout";
        }
        spct.setGiaBan(BigDecimal.valueOf(Double.valueOf(giaBan)));
        if(slt.isEmpty()){
            model.addAttribute("validateSLT","Quantity has not been entered!");
            model.addAttribute("listSP",svsp.getAll());
            model.addAttribute("listMS",svms.getAll());
            model.addAttribute("listNSX",svnsx.getAll());
            model.addAttribute("listDSP",svdsp.getAll());
            model.addAttribute("listSPCT",svspct.getAll());
            model.addAttribute("spct",spct);
            model.addAttribute("view","SPCT/index.jsp");
            return "layout";
        }
        if(!slt.matches("[1-9][0-9]+")){
            model.addAttribute("validateSLT","Quantity must be number!");
            model.addAttribute("listSP",svsp.getAll());
            model.addAttribute("listMS",svms.getAll());
            model.addAttribute("listNSX",svnsx.getAll());
            model.addAttribute("listDSP",svdsp.getAll());
            model.addAttribute("listSPCT",svspct.getAll());
            model.addAttribute("spct",spct);
            model.addAttribute("view","SPCT/index.jsp");
            return "layout";
        }
        spct.setSlt(Integer.valueOf(slt));

//        if(id_sp.isEmpty()){
//            model.addAttribute("validateSP","The product has not been selected!");
//            model.addAttribute("listSP",svsp.getAll());
//            model.addAttribute("listMS",svms.getAll());
//            model.addAttribute("listNSX",svnsx.getAll());
//            model.addAttribute("listDSP",svdsp.getAll());
//            model.addAttribute("listSPCT",svspct.getAll());
//            model.addAttribute("view","SPCT/index.jsp");
//            return "layout";
//        }
//        if(id_ms.isEmpty()){
//            model.addAttribute("validateMS","Color has not been selected!");
//            model.addAttribute("listSP",svsp.getAll());
//            model.addAttribute("listMS",svms.getAll());
//            model.addAttribute("listNSX",svnsx.getAll());
//            model.addAttribute("listDSP",svdsp.getAll());
//            model.addAttribute("listSPCT",svspct.getAll());
//            model.addAttribute("view","SPCT/index.jsp");
//            return "layout";
//        }
//        if(id_nsx.isEmpty()){
//            model.addAttribute("validateNSX","Color has not been selected!");
//            model.addAttribute("listSP",svsp.getAll());
//            model.addAttribute("listMS",svms.getAll());
//            model.addAttribute("listNSX",svnsx.getAll());
//            model.addAttribute("listDSP",svdsp.getAll());
//            model.addAttribute("listSPCT",svspct.getAll());
//            model.addAttribute("view","SPCT/index.jsp");
//            return "layout";
//        }
//        if(id_dsp.isEmpty()){
//            model.addAttribute("validateDSP","Product line has not been selected!");
//            model.addAttribute("listSP",svsp.getAll());
//            model.addAttribute("listMS",svms.getAll());
//            model.addAttribute("listNSX",svnsx.getAll());
//            model.addAttribute("listDSP",svdsp.getAll());
//            model.addAttribute("listSPCT",svspct.getAll());
//            model.addAttribute("view","SPCT/index.jsp");
//            return "layout";
//        }


        svspct.save(spct);
        model.addAttribute("listSP",svsp.getAll());
        model.addAttribute("listMS",svms.getAll());
        model.addAttribute("listNSX",svnsx.getAll());
        model.addAttribute("listDSP",svdsp.getAll());
        model.addAttribute("listSPCT",svspct.getAll());
        model.addAttribute("view","SPCT/index.jsp");
        return "layout";
    }
    @PostMapping("/update/{id}")
    private String update(Model model,@PathVariable("id")String id,
//                          @RequestParam("sp") String id_sp,
                        @RequestParam("ms") String id_ms,
                        @RequestParam("nsx") String id_nsx,
                        @RequestParam("dsp") String id_dsp,
                        @RequestParam("namBH") String namBH,
                        @RequestParam("moTa") String moTa,
                        @RequestParam("giaNhap") String giaNhap,
                        @RequestParam("giaBan") String giaBan,
                        @RequestParam("slt") String slt){

        SanPhamChiTiet spct = svspct.getOne(UUID.fromString(id));
//        SanPham sp = svsp.getById(UUID.fromString(id_sp));
        DongSP dsp = svdsp.getById(UUID.fromString(id_dsp));
        Nsx nsx = svnsx.getById(UUID.fromString(id_nsx));
        MauSac ms = svms.getById(UUID.fromString(id_ms));
        spct.setDsp(dsp);
        spct.setMs(ms);
        spct.setNsx(nsx);
        if(namBH.isEmpty()){
            model.addAttribute("validateNamBH","Warranty year has not been entered!");
            model.addAttribute("listSP",svsp.getAll());
            model.addAttribute("listMS",svms.getAll());
            model.addAttribute("listNSX",svnsx.getAll());
            model.addAttribute("listDSP",svdsp.getAll());
            model.addAttribute("listSPCT",svspct.getAll());
            model.addAttribute("view","SPCT/detail.jsp");
            model.addAttribute("spct",spct);
            return "layout";
        }
        if(!namBH.matches("[0-9]+")){
            model.addAttribute("validateNamBH","Warranty year must be number!");
            model.addAttribute("listSP",svsp.getAll());
            model.addAttribute("listMS",svms.getAll());
            model.addAttribute("listNSX",svnsx.getAll());
            model.addAttribute("listDSP",svdsp.getAll());
            model.addAttribute("listSPCT",svspct.getAll());
            model.addAttribute("spct",spct);
            model.addAttribute("view","SPCT/detail.jsp");
            return "layout";
        }
        spct.setNamBH(Integer.valueOf(namBH));
        if(moTa.isEmpty()){
            model.addAttribute("validateMoTa","Describe has not been entered!");
            model.addAttribute("listSP",svsp.getAll());
            model.addAttribute("listMS",svms.getAll());
            model.addAttribute("listNSX",svnsx.getAll());
            model.addAttribute("listDSP",svdsp.getAll());
            model.addAttribute("listSPCT",svspct.getAll());
            model.addAttribute("spct",spct);
            model.addAttribute("view","SPCT/detail.jsp");
            return "layout";
        }
        if(!moTa.matches("[0-9a-zA-Z\\s \\W]{1,50}$")){
            model.addAttribute("validateMoTa","Describe no more than 50 characters!");
            model.addAttribute("listSP",svsp.getAll());
            model.addAttribute("listMS",svms.getAll());
            model.addAttribute("listNSX",svnsx.getAll());
            model.addAttribute("listDSP",svdsp.getAll());
            model.addAttribute("listSPCT",svspct.getAll());
            model.addAttribute("spct",spct);
            model.addAttribute("view","SPCT/detail.jsp");
            return "layout";
        }
        spct.setMoTa(moTa);
        if(giaNhap.isEmpty()){
            model.addAttribute("validateGiaNhap","Import price has not been entered!");
            model.addAttribute("listSP",svsp.getAll());
            model.addAttribute("listMS",svms.getAll());
            model.addAttribute("listNSX",svnsx.getAll());
            model.addAttribute("listDSP",svdsp.getAll());
            model.addAttribute("listSPCT",svspct.getAll());
            model.addAttribute("spct",spct);
            model.addAttribute("view","SPCT/detail.jsp");
            return "layout";
        }
        if(!giaNhap.matches("[1-9][0-9]+(.0)?$")){
            model.addAttribute("validateGiaNhap","Import price must be number!");
            model.addAttribute("listSP",svsp.getAll());
            model.addAttribute("listMS",svms.getAll());
            model.addAttribute("listNSX",svnsx.getAll());
            model.addAttribute("listDSP",svdsp.getAll());
            model.addAttribute("listSPCT",svspct.getAll());
            model.addAttribute("spct",spct);
            model.addAttribute("view","SPCT/detail.jsp");
            return "layout";
        }
        spct.setGiaNhap(BigDecimal.valueOf(Double.valueOf(giaNhap)));
        if(giaBan.isEmpty()){
            model.addAttribute("validateGiaBan","Price has not been entered!");
            model.addAttribute("listSP",svsp.getAll());
            model.addAttribute("listMS",svms.getAll());
            model.addAttribute("listNSX",svnsx.getAll());
            model.addAttribute("listDSP",svdsp.getAll());
            model.addAttribute("listSPCT",svspct.getAll());
            model.addAttribute("spct",spct);
            model.addAttribute("view","SPCT/detail.jsp");
            return "layout";
        }
        if(!giaBan.matches("[1-9][0-9]+(.0)?$")){
            model.addAttribute("validateGiaBan","Price must be number!");
            model.addAttribute("listSP",svsp.getAll());
            model.addAttribute("listMS",svms.getAll());
            model.addAttribute("listNSX",svnsx.getAll());
            model.addAttribute("listDSP",svdsp.getAll());
            model.addAttribute("listSPCT",svspct.getAll());
            model.addAttribute("spct",spct);
            model.addAttribute("view","SPCT/detail.jsp");
            return "layout";
        }
        spct.setGiaBan(BigDecimal.valueOf(Double.valueOf(giaBan)));
        if(slt.isEmpty()){
            model.addAttribute("validateSLT","Quantity has not been entered!");
            model.addAttribute("listSP",svsp.getAll());
            model.addAttribute("listMS",svms.getAll());
            model.addAttribute("listNSX",svnsx.getAll());
            model.addAttribute("listDSP",svdsp.getAll());
            model.addAttribute("listSPCT",svspct.getAll());
            model.addAttribute("spct",spct);
            model.addAttribute("view","SPCT/detail.jsp");
            return "layout";
        }
        if(!slt.matches("[1-9][0-9]+")){
            model.addAttribute("validateSLT","Quantity must be number!");
            model.addAttribute("listSP",svsp.getAll());
            model.addAttribute("listMS",svms.getAll());
            model.addAttribute("listNSX",svnsx.getAll());
            model.addAttribute("listDSP",svdsp.getAll());
            model.addAttribute("listSPCT",svspct.getAll());
            model.addAttribute("spct",spct);
            model.addAttribute("view","SPCT/detail.jsp");
            return "layout";
        }
        spct.setSlt(Integer.valueOf(slt));

//        if(id_sp.isEmpty()){
//            model.addAttribute("validateSP","The product has not been selected!");
//            model.addAttribute("listSP",svsp.getAll());
//            model.addAttribute("listMS",svms.getAll());
//            model.addAttribute("listNSX",svnsx.getAll());
//            model.addAttribute("listDSP",svdsp.getAll());
//            model.addAttribute("listSPCT",svspct.getAll());
//            model.addAttribute("view","SPCT/index.jsp");
//            return "layout";
//        }
//        if(id_ms.isEmpty()){
//            model.addAttribute("validateMS","Color has not been selected!");
//            model.addAttribute("listSP",svsp.getAll());
//            model.addAttribute("listMS",svms.getAll());
//            model.addAttribute("listNSX",svnsx.getAll());
//            model.addAttribute("listDSP",svdsp.getAll());
//            model.addAttribute("listSPCT",svspct.getAll());
//            model.addAttribute("view","SPCT/index.jsp");
//            return "layout";
//        }
//        if(id_nsx.isEmpty()){
//            model.addAttribute("validateNSX","Color has not been selected!");
//            model.addAttribute("listSP",svsp.getAll());
//            model.addAttribute("listMS",svms.getAll());
//            model.addAttribute("listNSX",svnsx.getAll());
//            model.addAttribute("listDSP",svdsp.getAll());
//            model.addAttribute("listSPCT",svspct.getAll());
//            model.addAttribute("view","SPCT/index.jsp");
//            return "layout";
//        }
//        if(id_dsp.isEmpty()){
//            model.addAttribute("validateDSP","Product line has not been selected!");
//            model.addAttribute("listSP",svsp.getAll());
//            model.addAttribute("listMS",svms.getAll());
//            model.addAttribute("listNSX",svnsx.getAll());
//            model.addAttribute("listDSP",svdsp.getAll());
//            model.addAttribute("listSPCT",svspct.getAll());
//            model.addAttribute("view","SPCT/index.jsp");
//            return "layout";
//        }
        svspct.update(spct);
        model.addAttribute("listSP",svsp.getAll());
        model.addAttribute("listMS",svms.getAll());
        model.addAttribute("listNSX",svnsx.getAll());
        model.addAttribute("listDSP",svdsp.getAll());
        model.addAttribute("listSPCT",svspct.getAll());
        model.addAttribute("view","SPCT/index.jsp");
        return "layout";
    }
    @GetMapping("/detail/{id}")
    private String detail(Model model, @PathVariable("id") String id){
        model.addAttribute("listSP",svsp.getAll());
        model.addAttribute("listMS",svms.getAll());
        model.addAttribute("listNSX",svnsx.getAll());
        model.addAttribute("listDSP",svdsp.getAll());
        model.addAttribute("listSPCT",svspct.getAll());
        model.addAttribute("view","SPCT/detail.jsp");
        UUID uuid = UUID.fromString(id);
        model.addAttribute("spct",svspct.getOne(uuid));
        return "layout";
    }
}
