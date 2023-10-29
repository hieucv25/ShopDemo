package com.example.demo.controller;

import com.example.demo.Service.ServiceNsx;
import com.example.demo.model.Nsx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@Controller
@RequestMapping("/nha-san-xuat")
public class NsxController {
    @Autowired
    ServiceNsx svn;
    @GetMapping("/index")
    public String home(Model model){
        model.addAttribute("list",svn.getAll());
        model.addAttribute("view","Nsx/index.jsp");
        return "layout";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id")String id){
        model.addAttribute("nsx",svn.getById(UUID.fromString(id)));
        model.addAttribute("view","Nsx/detail.jsp");
        return "layout";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model,@PathVariable("id")String id){
        svn.delete(UUID.fromString(id));
        model.addAttribute("list",svn.getAll());
        model.addAttribute("view","Nsx/index.jsp");
        return "layout";
    }
    @PostMapping("/save")
    public String save(Model model, @RequestParam("ma")String ma,
                       @RequestParam("ten")String ten){
        Nsx nsx = new Nsx();
        nsx.setMa(ma);
        nsx.setTen(ten);
        for (Nsx n: svn.getAll()
             ) {
            if(n.getMa().equalsIgnoreCase(nsx.getMa())){
                model.addAttribute("nsx",nsx);
                model.addAttribute("list",svn.getAll());
                model.addAttribute("message","identifier Duplicate");
                model.addAttribute("view","Nsx/index.jsp");
                return "layout";
            }
        }
        svn.save(nsx);
        model.addAttribute("list",svn.getAll());
        model.addAttribute("view","Nsx/index.jsp");
        return "layout";
    }
    @PostMapping("/update/{id}")
    public String update(Model model,@PathVariable("id")String id,
                         @RequestParam("ma")String ma,
                       @RequestParam("ten")String ten){
        Nsx nsxUpdate = svn.getById(UUID.fromString(id));
        Nsx nsx = new Nsx();
        nsx.setMa(ma);
        nsx.setTen(ten);
        ArrayList<Nsx> listNsx = svn.getAll();
        if(nsxUpdate.getMa().equalsIgnoreCase(nsx.getMa())){
            listNsx.remove(nsxUpdate);
        }
        for (Nsx n: listNsx
        ) {
            if(n.getMa().equalsIgnoreCase(nsx.getMa())){
                model.addAttribute("nsx",nsx);
                model.addAttribute("message","identifier Duplicate");
                model.addAttribute("view","Nsx/detail.jsp");
                return "layout";
            }
        }
        nsxUpdate.setTen(ten);
        nsxUpdate.setMa(ma);
        svn.save(nsxUpdate);
        model.addAttribute("list",svn.getAll());
        model.addAttribute("view","Nsx/index.jsp");
        return "layout";
    }
}
