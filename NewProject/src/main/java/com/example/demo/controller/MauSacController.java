package com.example.demo.controller;

import com.example.demo.Service.ServiceMauSac;
import com.example.demo.model.MauSac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@Controller
@RequestMapping("/mau-sac")
public class MauSacController {
    @Autowired
    ServiceMauSac svms;
    @GetMapping("/index")
    public String home(Model model){
        model.addAttribute("list",svms.getAll());
        model.addAttribute("view","MauSac/index.jsp");
        return "layout";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id")String id){
        model.addAttribute("ms",svms.getById(UUID.fromString(id)));
        model.addAttribute("view","MauSac/detail.jsp");
        return "layout";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id")String id){
        svms.delete(UUID.fromString(id));
        model.addAttribute("view","MauSac/index.jsp");
        model.addAttribute("list",svms.getAll());
        return "layout";
    }
    @PostMapping("/save")
    public String save(Model model, @RequestParam("ma")String ma,
                       @RequestParam("ten")String ten){
        MauSac ms = new MauSac();
        ms.setMa(ma);
        ms.setTen(ten);
        for (MauSac mauSac: svms.getAll()
             ) {
            if(mauSac.getMa().equalsIgnoreCase(ms.getMa())){
                model.addAttribute("message","Identifier Duplicate!");
                model.addAttribute("ms",ms);
                model.addAttribute("list",svms.getAll());
                model.addAttribute("view","MauSac/index.jsp");
                return "layout";
            }
        }
        svms.save(ms);
        model.addAttribute("list",svms.getAll());
        model.addAttribute("view","MauSac/index.jsp");
        return "layout";
    }
    @PostMapping("/update/{id}")
    public String update(Model model,@PathVariable("id") String id,
                       @RequestParam("ma")String ma,
                       @RequestParam("ten")String ten){
        MauSac msUpdate = svms.getById(UUID.fromString(id));
        MauSac ms = new MauSac();
        ms.setMa(ma);
        ms.setTen(ten);
        ArrayList<MauSac> listMS = svms.getAll();
        if(ms.getMa().equalsIgnoreCase(msUpdate.getMa())){
            listMS.remove(msUpdate);
        }
        for (MauSac mauSac: listMS
        ) {
            if(mauSac.getMa().equalsIgnoreCase(ms.getMa())){
                model.addAttribute("message","Identifier Duplicate!");
                model.addAttribute("ms",ms);
                model.addAttribute("view","MauSac/detail.jsp");
                return "layout";
            }
        }
        msUpdate.setTen(ms.getTen());
        msUpdate.setMa(ms.getMa());
        svms.update(msUpdate);
        model.addAttribute("list",svms.getAll());
        model.addAttribute("view","MauSac/index.jsp");
        return "layout";
    }
}
