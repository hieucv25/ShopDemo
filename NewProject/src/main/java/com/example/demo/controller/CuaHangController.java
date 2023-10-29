package com.example.demo.controller;

import com.example.demo.Service.ServiceCuaHang;
import com.example.demo.model.CuaHang;
import com.example.demo.model.MauSac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/cua-hang")
public class CuaHangController {
    @Autowired
    ServiceCuaHang svch;
    @GetMapping("/index")
    public String home(Model model){
        model.addAttribute("list",svch.getAll());
        model.addAttribute("view","CuaHang/index.jsp");
        return "layout";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id")String id){
        model.addAttribute("ch",svch.getById(UUID.fromString(id)));
        model.addAttribute("view","CuaHang/detail.jsp");
        return "layout";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id")String id){
        svch.delete(UUID.fromString(id));
        model.addAttribute("view","CuaHang/index.jsp");
        model.addAttribute("list",svch.getAll());
        return "layout";
    }
    @PostMapping("/save")
    public String save(Model model, @RequestParam("ma")String ma,
                       @RequestParam("ten")String ten,
                       @RequestParam("diaChi")String diaChi,
                       @RequestParam("thanhPho")String thanhPho,
                       @RequestParam("quocGia")String quocGia){
        CuaHang ch = new CuaHang();
        ch.setMa(ma);
        ch.setTen(ten);
        ch.setDiaChi(diaChi);
        ch.setThanhPho(thanhPho);
        ch.setQuocGia(quocGia);
        for (CuaHang cuaHang: svch.getAll()
        ) {
            if(cuaHang.getMa().equalsIgnoreCase(ch.getMa())){
                model.addAttribute("message","Identifier Duplicate!");
                model.addAttribute("ch",ch);
                model.addAttribute("list",svch.getAll());
                model.addAttribute("view","CuaHang/index.jsp");
                return "layout";
            }
        }
        svch.save(ch);
        model.addAttribute("list",svch.getAll());
        model.addAttribute("view","CuaHang/index.jsp");
        return "layout";
    }
    @PostMapping("/update/{id}")
    public String update(Model model,@PathVariable("id") String id,
                         @RequestParam("ma")String ma,
                         @RequestParam("ten")String ten,
                         @RequestParam("diaChi")String diaChi,
                         @RequestParam("thanhPho")String thanhPho,
                         @RequestParam("quocGia")String quocGia){
        CuaHang chUpdate = svch.getById(UUID.fromString(id));
        CuaHang ch = new CuaHang();
        ch.setMa(ma);
        List<CuaHang> listCH = svch.getAll();
        if(ch.getMa().equalsIgnoreCase(chUpdate.getMa())){
            listCH.remove(chUpdate);
        }
        for (CuaHang cuaHang: listCH
        ) {
            if(cuaHang.getMa().equalsIgnoreCase(ch.getMa())){
                model.addAttribute("message","Identifier Duplicate!");
                model.addAttribute("ch",ch);
                model.addAttribute("view","CuaHang/detail.jsp");
                return "layout";
            }
        }
        chUpdate.setTen(ten);
        chUpdate.setMa(ch.getMa());
        chUpdate.setDiaChi(diaChi);
        chUpdate.setThanhPho(thanhPho);
        chUpdate.setQuocGia(quocGia);
        svch.update(chUpdate);
        model.addAttribute("list",svch.getAll());
        model.addAttribute("view","CuaHang/index.jsp");
        return "layout";
    }
}
