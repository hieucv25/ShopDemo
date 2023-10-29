package com.example.demo.controller;

import com.example.demo.Service.ServiceSanPham;
import com.example.demo.model.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController {
    @Autowired
    ServiceSanPham svsp;
    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("list",svsp.getAll());
        model.addAttribute("view","SanPham/index.jsp");
        return "layout";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id")String id){
        model.addAttribute("list",svsp.getAll());
        model.addAttribute("view","SanPham/index.jsp");
        SanPham sp = svsp.getById(UUID.fromString(id));
        svsp.delete(sp);
        return "layout";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id")String id){
        model.addAttribute("sp",svsp.getById(UUID.fromString(id)));
        model.addAttribute("view","SanPham/detail.jsp");
        return "layout";
    }
    @PostMapping("/save")
    public String save(Model model, @RequestParam("ma")String ma,
                       @RequestParam("ten") String ten){
        SanPham sp = new SanPham();
        sp.setMa(ma);
        sp.setTen(ten);
        for (SanPham sanPham: svsp.getAll()
             ) {
            if(sp.getMa().equalsIgnoreCase(sanPham.getMa())){
                model.addAttribute("message","Identifier Duplicate!");
                model.addAttribute("sp",sp);
                model.addAttribute("list",svsp.getAll());
                model.addAttribute("view","SanPham/index.jsp");
                return "layout";
            }
        }
        svsp.save(sp);
        model.addAttribute("view","SanPham/index.jsp");
        model.addAttribute("list",svsp.getAll());
        return "layout";
    }
    @PostMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") String id,
                         @RequestParam("ma")String ma,
                       @RequestParam("ten") String ten){
        SanPham spUpdate = svsp.getById(UUID.fromString(id));
        SanPham sp = new SanPham();
        sp.setTen(ten);
        sp.setMa(ma);
        ArrayList<SanPham> listSP = svsp.getAll();
        if(spUpdate.getMa().equalsIgnoreCase(sp.getMa())){
            listSP.remove(spUpdate);
        }
        for (SanPham sanPham: listSP
        ) {
            if(sanPham.getMa().equalsIgnoreCase(sp.getMa())){
                model.addAttribute("sp",sp);
                model.addAttribute("message","Identifier Duplicate!");
                model.addAttribute("view","SanPham/detail.jsp");
                return "layout";
            }
        }
        spUpdate.setMa(sp.getMa());
        spUpdate.setTen(sp.getTen());
        svsp.update(spUpdate);
        model.addAttribute("view","SanPham/index.jsp");
        model.addAttribute("list",svsp.getAll());
        return "layout";
    }
}