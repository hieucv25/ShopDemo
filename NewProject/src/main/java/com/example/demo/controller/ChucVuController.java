package com.example.demo.controller;

import com.example.demo.Service.ServiceChucVu;
import com.example.demo.model.ChucVu;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.UUID;

@Controller
@RequestMapping("/chuc-vu")
public class ChucVuController {
    @Autowired
    ServiceChucVu svcv;
    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("list",svcv.getAll());
        model.addAttribute("view","ChucVu/index.jsp");
        return "layout";
    }

    @PostMapping("/save")
    public String save(Model model, @RequestParam("ma") String ma,
                       @RequestParam("ten") String ten) {
        ChucVu cv = new ChucVu();
        for(ChucVu cvv: svcv.getAll()){
            if(cvv.getMa().equalsIgnoreCase(ma)){
                model.addAttribute("message","Mã Trùng!");
                model.addAttribute("list",svcv.getAll());
                model.addAttribute("view","ChucVu/index.jsp");
                return "layout";
            }
        }
        cv.setTen(ten);
        cv.setMa(ma);
        svcv.save(cv);
        model.addAttribute("list",svcv.getAll());
        model.addAttribute("view","ChucVu/index.jsp");
        return "layout";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id")String id){
        model.addAttribute("list",svcv.getAll());
        model.addAttribute("view","ChucVu/detail.jsp");
        UUID uuid = UUID.fromString(id);
        model.addAttribute("cv",svcv.findById(uuid));
        return "layout";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id")String id){
        UUID uuid = UUID.fromString(id);
        svcv.delete(uuid);
        model.addAttribute("list",svcv.getAll());
        model.addAttribute("view","ChucVu/index.jsp");
        return "layout";
    }

    @PostMapping("/update/{id}")
    public String update(Model model,@PathVariable("id") String id,
                         @RequestParam("ma") String ma,
                         @RequestParam("ten") String ten,
                         HttpServletResponse response
                         )throws IOException,ServletException{
        ChucVu cvUpdate = svcv.findById(UUID.fromString(id));
        ChucVu cv = new ChucVu();
        cv.setTen(ten);
        cv.setMa(ma);
        ArrayList<ChucVu> listCV = svcv.getAll();
        if(cvUpdate.getMa().equalsIgnoreCase(cv.getMa())){
            listCV.remove(cvUpdate);
        }
        for (ChucVu chucVu: listCV
        ) {
            if(chucVu.getMa().equalsIgnoreCase(cv.getMa())){
                model.addAttribute("cv",cv);
                model.addAttribute("message","Identifier Duplicate!");
                model.addAttribute("view","ChucVu/detail.jsp");
                return "layout";
            }
        }
        cvUpdate.setMa(cv.getMa());
        cvUpdate.setTen(cv.getTen());
        svcv.update(cvUpdate);
        model.addAttribute("view","ChucVu/index.jsp");
        model.addAttribute("list",svcv.getAll());
        return "layout";
    }
}
