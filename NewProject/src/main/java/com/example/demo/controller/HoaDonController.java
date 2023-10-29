package com.example.demo.controller;

import com.example.demo.Service.Impl.ServiceHDImpl;
import com.example.demo.Service.ServiceHDCT;
import com.example.demo.Service.ServiceHoaDon;
import com.example.demo.Service.ServiceSPCT;
import com.example.demo.ViewModel.HistoryBuy;
import com.example.demo.ViewModel.HistoryList;
import com.example.demo.model.HDCT;
import com.example.demo.model.HoaDon;
import com.example.demo.model.IdHoaDonChiTiet;
import com.example.demo.model.SanPhamChiTiet;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/hoa-don")
public class HoaDonController {
    @Autowired
    HttpSession session;
    @Autowired
    ServiceHoaDon svhd;
    @Autowired
    ServiceHDCT svhdct;
    @GetMapping("/index")
    public String view(Model model){
        Pageable pageable = PageRequest.of(0,5);
        Page<HoaDon> page = svhd.findAll(pageable);
        model.addAttribute("list",page);
        model.addAttribute("view","HoaDon/index.jsp");
        return "layout";
    }
    @GetMapping("/detail/{id}/{number}")
    public String detail(Model model, @PathVariable("id")String id,
                         @PathVariable("number") int number){
        Pageable pageable = PageRequest.of(number,5);
        Page<HoaDon> page = svhd.findAll(pageable);
        model.addAttribute("list",page);
        model.addAttribute("hd",svhd.getById(UUID.fromString(id)));
        model.addAttribute("view","HoaDon/index.jsp");
        return "layout";
    }
    @GetMapping("/delete/{id}/{number}")
    public String delete(Model model, @PathVariable("id")String id,
                         @PathVariable("number") Integer number
    ){
        if(svhdct.findByIDHD(UUID.fromString(id)) != null){
            List<HDCT> list = svhdct.findByIDHD(UUID.fromString(id));
            for (HDCT hdct: list
                 ) {
                svhdct.delete(hdct.getId());
            }
        }
        svhd.delete(UUID.fromString(id));
        Pageable pageable = PageRequest.of(number,5);
        Page<HoaDon> page = svhd.findAll(pageable);
        model.addAttribute("list",page);
        model.addAttribute("view","HoaDon/index.jsp");
        return "layout";
    }
    @PostMapping("/update/{id}/{number}")
    public String update(Model model, @PathVariable("id")String id, @RequestParam("tinhTrang") Integer status,
                         @PathVariable("number") int number){
        HoaDon hd = svhd.getById(UUID.fromString(id));
        hd.setTinhTrang(status);
        if(status==1){
            hd.setNgayThanhToan(Date.valueOf(LocalDate.now()));
            hd.setNgayShip(Date.valueOf(LocalDate.now()));
        }
        if(status==2){
            hd.setNgayNhan(Date.valueOf(LocalDate.now()));
        }
        svhd.update(hd);
        Pageable pageable = PageRequest.of(number,5);
        Page<HoaDon> page = svhd.findAll(pageable);
        HistoryList h = (HistoryList) session.getAttribute("history");
        HistoryBuy hb = new HistoryBuy();
        hb.setDateTime(new java.util.Date());
        hb.setStatus(status);
        hb.setMaHD(hd.getMa());
        if(h == null) {
            HistoryList history = new HistoryList();
            List<HistoryBuy> listH = new ArrayList<>();
            listH.add(hb);
            history.setListHistory(listH);
            session.setAttribute("history", history);
        } else {
            HistoryList his = (HistoryList) session.getAttribute("history");
            List<HistoryBuy> list = his.getListHistory();
            list.add(hb);
        }
        model.addAttribute("list",page);
        model.addAttribute("view","HoaDon/index.jsp");
        return "layout";
    }
    @PostMapping("/search/{number}")
    public String search(Model model, @RequestParam("keyword")String keyword,
                         @PathVariable("number") Optional<Integer> number){
        List<HoaDon> listAll = svhd.getAll();
        for (int i = 0; i < listAll.size()/5; i++)
        {
            Pageable pageable = PageRequest.of(i,5);
            Page<HoaDon> page = svhd.findAll(pageable);
            for (HoaDon hd: page
                 ) {
                if(hd.getMa().equalsIgnoreCase(keyword)){
                    Pageable pageable2 = PageRequest.of(page.getNumber(),5);
                    Page<HoaDon> page2 = svhd.findAll(pageable2);
                    model.addAttribute("list",page2);
                    model.addAttribute("hd",hd);
                    model.addAttribute("view","HoaDon/index.jsp");
                    return "layout";
                }
            }
        }
        Pageable pageable2 = PageRequest.of(number.orElse(0),5);
        Page<HoaDon> page2 = svhd.findAll(pageable2);
        model.addAttribute("list",page2);
        model.addAttribute("message","Not Found!");
        model.addAttribute("view","HoaDon/index.jsp");
        return "layout";
    }
    @GetMapping("/page/{number}")
    public String page(Model model, @PathVariable("number")Optional<Integer> number,
                       @PathVariable("number")Integer number2){
        if(svhd.getAll().size()%5==0){
            if(number2>svhd.getAll().size()/5){
                Pageable pageable = PageRequest.of(0,5);
                Page<HoaDon> page = svhd.findAll(pageable);
                model.addAttribute("list",page);
                model.addAttribute("view","HoaDon/index.jsp");
                return "layout";
            }
            if(number2<0){
                Pageable pageable = PageRequest.of(svhd.getAll().size()/5,5);
                Page<HoaDon> page = svhd.findAll(pageable);
                model.addAttribute("list",page);
                model.addAttribute("view","HoaDon/index.jsp");
                return "layout";
            }
        }
        if(svhd.getAll().size()%5!=0){
            if(number2>=svhd.getAll().size()/5+1){
                Pageable pageable = PageRequest.of(0,5);
                Page<HoaDon> page = svhd.findAll(pageable);
                model.addAttribute("list",page);
                model.addAttribute("view","HoaDon/index.jsp");
                return "layout";
            }
            if(number2<0){
                Pageable pageable = PageRequest.of(svhd.getAll().size()/5,5);
                Page<HoaDon> page = svhd.findAll(pageable);
                model.addAttribute("list",page);
                model.addAttribute("view","HoaDon/index.jsp");
                return "layout";
            }
        }
        Pageable pageable = PageRequest.of(number.orElse(0),5);
        Page<HoaDon> page = svhd.findAll(pageable);

        model.addAttribute("list",page);
        model.addAttribute("view","HoaDon/index.jsp");
        return "layout";
    }
}
