package com.example.demo.controller;

import com.example.demo.Service.ServiceDongSP;
import com.example.demo.model.DongSP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@Controller
@RequestMapping("/dong-sp")
public class DspController {
    @Autowired
    ServiceDongSP svdsp;
    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("list",svdsp.getAll());
        model.addAttribute("view","DongSP/index.jsp");
        return "layout";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id")String id){
        model.addAttribute("dsp",svdsp.getById(UUID.fromString(id)));
        model.addAttribute("view","DongSP/detail.jsp");
        return "layout";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id")String id){
        svdsp.delete(UUID.fromString(id));
        model.addAttribute("list",svdsp.getAll());
        model.addAttribute("view","DongSP/index.jsp");
        return "layout";
    }
    @PostMapping("/save")
    public String save(Model model, @RequestParam("ma") String ma,
                       @RequestParam("ten") String ten){
        DongSP dsp = new DongSP();
        dsp.setTen(ten);
        dsp.setMa(ma);
        for (DongSP dongSP: svdsp.getAll()
             ) {
            if(dongSP.getMa().equalsIgnoreCase(dsp.getMa())){
                model.addAttribute("dsp",dsp);
                model.addAttribute("list",svdsp.getAll());
                model.addAttribute("message","Identifier Duplicate");
                model.addAttribute("view","DongSP/index.jsp");
                return "layout";
            }
        }
        svdsp.save(dsp);
        model.addAttribute("list",svdsp.getAll());
        model.addAttribute("view","DongSP/index.jsp");
        return "layout";
    }
    @PostMapping("/update/{id}")
    public String update(Model model,@PathVariable("id")String id,
                       @RequestParam("ma") String ma,
                       @RequestParam("ten") String ten){
        DongSP dspUpdate = svdsp.getById(UUID.fromString(id));
        DongSP dsp = new DongSP();
        dsp.setTen(ten);
        dsp.setMa(ma);
        ArrayList<DongSP> listDsp = svdsp.getAll();
        if(dsp.getMa().equalsIgnoreCase(dspUpdate.getMa())){
            listDsp.remove(dspUpdate);
        }
        for (DongSP dongSP: listDsp
        ) {
            if(dongSP.getMa().equalsIgnoreCase(dsp.getMa())){
                model.addAttribute("dsp",dsp);
                model.addAttribute("message","Identifier Duplicate");
                model.addAttribute("view","DongSP/detail.jsp");
                return "layout";
            }
        }
        dspUpdate.setTen(ten);
        dspUpdate.setMa(ma);
        svdsp.update(dspUpdate);
        model.addAttribute("list",svdsp.getAll());
        model.addAttribute("view","DongSP/index.jsp");
        return "layout";
    }
}
