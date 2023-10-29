package com.example.demo.controller;

import com.example.demo.Service.ServiceKhachHang;
import com.example.demo.model.KhachHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/khach-hang")
public class KhachHangController {
    @Autowired
    ServiceKhachHang svkh;
    @GetMapping("/index")
    public String home(Model model){
        model.addAttribute("list",svkh.getAll());
        model.addAttribute("view","KhachHang/index.jsp");
        return "layout";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id")String id){
        svkh.delete(UUID.fromString(id));
        model.addAttribute("list",svkh.getAll());
        model.addAttribute("view","KhachHang/index.jsp");
        return "layout";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id")String id){
        model.addAttribute("kh",svkh.getById(UUID.fromString(id)));
        model.addAttribute("list",svkh.getAll());
        model.addAttribute("view","KhachHang/detail.jsp");
        return "layout";
    }
    @PostMapping("/save")
    public String save(Model model, @RequestParam("ma") String ma,
                       @RequestParam("ten") String ten,
                       @RequestParam("tenDem") String tenDem,
                       @RequestParam("ho") String ho,
                       @RequestParam("ngaySinh") String ngaySinh,
                       @RequestParam("sdt") String sdt,
                       @RequestParam("diaChi") String diaChi,
                       @RequestParam("thanhPho") String thanhPho,
                       @RequestParam("quocGia") String quocGia,
                       @RequestParam("matKhau") String matKhau){
        KhachHang kh = new KhachHang();
        kh.setMa(ma);
        kh.setTen(ten);
        kh.setTenDem(tenDem);
        kh.setHo(ho);
        try {
            kh.setNgaySinh(Date.valueOf(ngaySinh));
        } catch (Exception e){
            e.printStackTrace();
            model.addAttribute("validateNgaySinh","Wrong date of birth!");
            model.addAttribute("kh",kh);
            model.addAttribute("list",svkh.getAll());
            model.addAttribute("view","KhachHang/index.jsp");
            return "layout";
        }
        kh.setSdt(sdt);
        kh.setDiaChi(diaChi);
        kh.setThanhPho(thanhPho);
        kh.setQuocGia(quocGia);
        kh.setMatKhau(matKhau);
        for (KhachHang khachHang: svkh.getAll()
             ) {
            if(khachHang.getMa().equalsIgnoreCase(kh.getMa())){
                model.addAttribute("validateMa","Duplicate identifier!");
                model.addAttribute("kh",kh);
                model.addAttribute("list",svkh.getAll());
                model.addAttribute("view","KhachHang/index.jsp");
                return "layout";
            }
        }
        if(kh.getMa().isEmpty()){
            model.addAttribute("validateMa","identifier not yet entered!");
            model.addAttribute("kh",kh);
            model.addAttribute("list",svkh.getAll());
            model.addAttribute("view","KhachHang/index.jsp");
            return "layout";
        }
        if(kh.getTen().isEmpty()){
            model.addAttribute("validateTen","First Name not yet entered!");
            model.addAttribute("kh",kh);
            model.addAttribute("list",svkh.getAll());
            model.addAttribute("view","KhachHang/index.jsp");
            return "layout";
        }
        if(!kh.getTen().matches("^[a-zA-z][a-zA-Z ]{1,29}$")){
            model.addAttribute("validateTen","First Name must start with 1 letter " +
                    "and not more than 30 characters!");
            model.addAttribute("kh",kh);
            model.addAttribute("list",svkh.getAll());
            model.addAttribute("view","KhachHang/index.jsp");
            return "layout";
        }
        if(kh.getTenDem().isEmpty()){
            model.addAttribute("validateTenDem","Middle name not yet entered!");
            model.addAttribute("kh",kh);
            model.addAttribute("list",svkh.getAll());
            model.addAttribute("view","KhachHang/index.jsp");
            return "layout";
        }
        if(!kh.getTenDem().matches("^[a-zA-z][a-zA-Z ]{1,29}$")){
            model.addAttribute("validateTenDem","Middle name must start with 1 letter " +
                    "and not more than 30 characters!");
            model.addAttribute("kh",kh);
            model.addAttribute("list",svkh.getAll());
            model.addAttribute("view","KhachHang/index.jsp");
            return "layout";
        }
        if(kh.getHo().isEmpty()){
            model.addAttribute("validateHo","Last Name not yet entered!");
            model.addAttribute("kh",kh);
            model.addAttribute("list",svkh.getAll());
            model.addAttribute("view","KhachHang/index.jsp");
            return "layout";
        }
        if(!kh.getHo().matches("^[a-zA-z][a-zA-Z ]{1,29}$")){
            model.addAttribute("validateHo","Last Name must start with 1 letter " +
                    "and not more than 30 characters!");
            model.addAttribute("kh",kh);
            model.addAttribute("list",svkh.getAll());
            model.addAttribute("view","KhachHang/index.jsp");
            return "layout";
        }
        if(kh.getSdt().isEmpty()){
            model.addAttribute("validateSDT","Number Phone not yet entered!");
            model.addAttribute("kh",kh);
            model.addAttribute("list",svkh.getAll());
            model.addAttribute("view","KhachHang/index.jsp");
            return "layout";
        }
        if(!kh.getSdt().matches("^[0-9][0-9]{1,29}$")){
            model.addAttribute("validateSDT","Phone number must start " +
                    "with 1 number and up to 30 numbers!");
            model.addAttribute("kh",kh);
            model.addAttribute("list",svkh.getAll());
            model.addAttribute("view","KhachHang/index.jsp");
            return "layout";
        }
        if(!kh.getDiaChi().matches("[0-9a-zA-Z\\s \\W]{1,100}$")){
            model.addAttribute("validateDiaChi","Location max 50 character!");
            model.addAttribute("kh",kh);
            model.addAttribute("list",svkh.getAll());
            model.addAttribute("view","KhachHang/index.jsp");
            return "layout";
        }
        svkh.save(kh);
        model.addAttribute("list",svkh.getAll());
        model.addAttribute("view","KhachHang/index.jsp");
        return "layout";
    }
    @PostMapping("/update/{id}")
    public String update(Model model,@PathVariable("id")String id,
                         @RequestParam("ma") String ma,
                       @RequestParam("ten") String ten,
                       @RequestParam("tenDem") String tenDem,
                       @RequestParam("ho") String ho,
                       @RequestParam("ngaySinh") String ngaySinh,
                       @RequestParam("sdt") String sdt,
                       @RequestParam("diaChi") String diaChi,
                       @RequestParam("thanhPho") String thanhPho,
                       @RequestParam("quocGia") String quocGia,
                       @RequestParam("matKhau") String matKhau){
        KhachHang khUpdate = svkh.getById(UUID.fromString(id));
        KhachHang kh = new KhachHang();
        kh.setMa(ma);
        kh.setTen(ten);
        kh.setTenDem(tenDem);
        kh.setHo(ho);
        List<KhachHang> listKH = svkh.getAll();
        if(kh.getMa().equalsIgnoreCase(khUpdate.getMa())){
            listKH.remove(khUpdate);
        }
        try {
            kh.setNgaySinh(Date.valueOf(ngaySinh));
        } catch (Exception e){
            e.printStackTrace();
            model.addAttribute("validateNgaySinh","Wrong date of birth!");
            model.addAttribute("kh",kh);
            model.addAttribute("list",svkh.getAll());
            model.addAttribute("view","KhachHang/detail.jsp");
            return "layout";
        }
        kh.setSdt(sdt);
        kh.setDiaChi(diaChi);
        kh.setThanhPho(thanhPho);
        kh.setQuocGia(quocGia);
        kh.setMatKhau(matKhau);
        for (KhachHang khachHang: listKH
        ) {
            if(khachHang.getMa().equalsIgnoreCase(kh.getMa())){
                model.addAttribute("validateMa","Duplicate identifier!");
                model.addAttribute("kh",kh);
                model.addAttribute("list",svkh.getAll());
                model.addAttribute("view","KhachHang/detail.jsp");
                return "layout";
            }
        }
        if(kh.getMa().isEmpty()){
            model.addAttribute("validateMa","identifier not yet entered!");
            model.addAttribute("kh",kh);
            model.addAttribute("list",svkh.getAll());
            model.addAttribute("view","KhachHang/detail.jsp");
            return "layout";
        }
        if(kh.getTen().isEmpty()){
            model.addAttribute("validateTen","First Name not yet entered!");
            model.addAttribute("kh",kh);
            model.addAttribute("list",svkh.getAll());
            model.addAttribute("view","KhachHang/detail.jsp");
            return "layout";
        }
        if(!kh.getTen().matches("^[a-zA-z][a-zA-Z ]{1,29}$")){
            model.addAttribute("validateTen","First Name must start with 1 letter " +
                    "and not more than 30 characters!");
            model.addAttribute("kh",kh);
            model.addAttribute("list",svkh.getAll());
            model.addAttribute("view","KhachHang/detail.jsp");
            return "layout";
        }
        if(kh.getTenDem().isEmpty()){
            model.addAttribute("validateTenDem","Middle name not yet entered!");
            model.addAttribute("kh",kh);
            model.addAttribute("list",svkh.getAll());
            model.addAttribute("view","KhachHang/detail.jsp");
            return "layout";
        }
        if(!kh.getTenDem().matches("^[a-zA-z][a-zA-Z ]{1,29}$")){
            model.addAttribute("validateTenDem","Middle name must start with 1 letter " +
                    "and not more than 30 characters!");
            model.addAttribute("kh",kh);
            model.addAttribute("list",svkh.getAll());
            model.addAttribute("view","KhachHang/detail.jsp");
            return "layout";
        }
        if(kh.getHo().isEmpty()){
            model.addAttribute("validateHo","Last Name not yet entered!");
            model.addAttribute("kh",kh);
            model.addAttribute("list",svkh.getAll());
            model.addAttribute("view","KhachHang/detail.jsp");
            return "layout";
        }
        if(!kh.getHo().matches("^[a-zA-z][a-zA-Z ]{1,29}$")){
            model.addAttribute("validateHo","Last Name must start with 1 letter " +
                    "and not more than 30 characters!");
            model.addAttribute("kh",kh);
            model.addAttribute("list",svkh.getAll());
            model.addAttribute("view","KhachHang/detail.jsp");
            return "layout";
        }
        if(kh.getSdt().isEmpty()){
            model.addAttribute("validateSDT","Number Phone not yet entered!");
            model.addAttribute("kh",kh);
            model.addAttribute("list",svkh.getAll());
            model.addAttribute("view","KhachHang/detail.jsp");
            return "layout";
        }
        if(!kh.getSdt().matches("^[0-9][0-9]{1,29}$")){
            model.addAttribute("validateSDT","Phone number must start " +
                    "with 1 number and up to 30 numbers!");
            model.addAttribute("kh",kh);
            model.addAttribute("list",svkh.getAll());
            model.addAttribute("view","KhachHang/detail.jsp");
            return "layout";
        }
        if(!kh.getDiaChi().matches("[0-9a-zA-Z\\s \\W]{1,100}$")){
            model.addAttribute("validateDiaChi","Location max 50 character!");
            model.addAttribute("kh",kh);
            model.addAttribute("list",svkh.getAll());
            model.addAttribute("view","KhachHang/detail.jsp");
            return "layout";
        }
        khUpdate.setMa(ma);
        khUpdate.setTen(ten);
        khUpdate.setTenDem(tenDem);
        khUpdate.setHo(ho);
        khUpdate.setNgaySinh(Date.valueOf(ngaySinh));
        khUpdate.setSdt(sdt);
        khUpdate.setDiaChi(diaChi);
        khUpdate.setThanhPho(thanhPho);
        khUpdate.setQuocGia(quocGia);
        khUpdate.setMatKhau(matKhau);
        svkh.save(khUpdate);
        model.addAttribute("list",svkh.getAll());
        model.addAttribute("view","KhachHang/index.jsp");
        return "layout";
    }
    @PostMapping("/search")
    public String search(Model model,@RequestParam("keyword") String keyword){
        model.addAttribute("list",svkh.search(keyword));
        model.addAttribute("view","KhachHang/index.jsp");
        return "layout";
    }
}
