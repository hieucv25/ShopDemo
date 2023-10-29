package com.example.demo.controller;

import com.example.demo.Repository.SanPhamRepository;
import com.example.demo.Service.*;
import com.example.demo.ViewModel.*;
import com.example.demo.model.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    SanPhamRepository sprp;
    @Autowired
    ServiceSPCT svspct;
    @Autowired
    ServiceGHCT svghct;
    @Autowired
    ServiceGH svgh;
    @Autowired
    ServiceKhachHang svkh;
    @Autowired
    HttpSession session;
    @Autowired
    ServiceHDCT svhdct;
    @Autowired
    ServiceHoaDon svhd;
    @Autowired
    ServiceNhanVien svnv;
    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("view","home.jsp");
        model.addAttribute("list",svspct.getAll());
        return "Home/index";
    }
//    @GetMapping("/cart/index")
//    public String cart(Model model){
//        Cart cart = (Cart) session.getAttribute("cart");
//        List<Item> listItem = cart.getItems();
//        model.addAttribute("view","cart.jsp");
//        model.addAttribute("pic",listItem);
//        return "Home/index";
//    }
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") String id){
        model.addAttribute("spct",svspct.getOne(UUID.fromString(id)));
        model.addAttribute("view","detail.jsp");
        return "Home/index";
    }
//    @GetMapping("/cart/add/{id}")
//    public String addCart(Model model, @PathVariable("id") String id) {
//        SanPhamChiTiet spct = svspct.getOne(UUID.fromString(id));
//        Item item = new Item(spct.getId(), spct.getSp().getTen(), 1, spct.getMs().getTen(), spct.getGiaBan());
//        Cart cartSession = (Cart) session.getAttribute("cart");
//        if (cartSession == null) {
//            Cart cart = new Cart();
//            List<Item> list = new ArrayList<>();
//            list.add(item);
//            cart.setItems(list);
//            session.setAttribute("cart", cart);
//        } else {
//            Cart cart = (Cart) session.getAttribute("cart");
//            List<Item> listItem = cart.getItems();
//            for (Item it : listItem
//            ) {
//                if (it.getIdCTSP().equals(spct.getId())) {
//                    it.setSoLuong(it.getSoLuong() + 1);
//                    model.addAttribute("view","home.jsp");
//                    model.addAttribute("list",svspct.getAll());
//                    return "Home/index";
//                }
//            }
//            listItem.add(item);
//        }
//        model.addAttribute("view","home.jsp");
//        model.addAttribute("list",svspct.getAll());
//        return "Home/index";
//    }
    @GetMapping("/cart/add/{id}")
    public String addCart(Model model, @PathVariable("id") String id) {
        SanPhamChiTiet spct = svspct.getOne(UUID.fromString(id));
        List<GioHangChiTiet> listGHCT = svghct.getAll();
        if(listGHCT.size()==0){
            GioHangChiTiet ghct = new GioHangChiTiet();
            IdGioHangChiTiet idGHCT = new IdGioHangChiTiet();
            idGHCT.setSpct(spct);
            idGHCT.setGh(svgh.getById(UUID.fromString("37311b6e-5c99-ce4a-ab80-c1e61b688749")));
            ghct.setId(idGHCT);
            ghct.setSoLuong(1);
            ghct.setDonGia(spct.getGiaBan());
            ghct.setDonGiaKhiGiam(spct.getGiaBan());
            svghct.save(ghct);
            model.addAttribute("view","home.jsp");
            model.addAttribute("list",svspct.getAll());
            return "Home/index";
        } else {
            for (GioHangChiTiet gh: listGHCT
                 ) {
                if (gh.getId().getGh().getId().equals(UUID.fromString("37311b6e-5c99-ce4a-ab80-c1e61b688749")) &&
                        gh.getId().getSpct().getId().equals(spct.getId())) {
                    gh.setSoLuong(gh.getSoLuong() + 1);
                    svghct.update(gh);
                    model.addAttribute("view", "home.jsp");
                    model.addAttribute("list", svspct.getAll());
                    return "Home/index";
                }
            }
            GioHangChiTiet ghct = new GioHangChiTiet();
            IdGioHangChiTiet idGHCT = new IdGioHangChiTiet();
            idGHCT.setGh(svgh.getById(UUID.fromString("37311b6e-5c99-ce4a-ab80-c1e61b688749")));
            idGHCT.setSpct(spct);
            ghct.setId(idGHCT);
            ghct.setSoLuong(1);
            ghct.setDonGia(spct.getGiaBan());
            ghct.setDonGiaKhiGiam(spct.getGiaBan());
            svghct.save(ghct);
            model.addAttribute("view", "home.jsp");
            model.addAttribute("list", svspct.getAll());
            return "Home/index";
        }
    }
    @GetMapping("/cart/delete/{id}")
    public String deleteCart(Model model, @PathVariable("id") String id){
        IdGioHangChiTiet idGHCT = new IdGioHangChiTiet();
        idGHCT.setSpct(svspct.getOne(UUID.fromString(id)));
        idGHCT.setGh(svgh.getById(UUID.fromString("37311b6e-5c99-ce4a-ab80-c1e61b688749")));
        svghct.delete(idGHCT);
        model.addAttribute("view", "cart.jsp");
        model.addAttribute("list", svghct.getAll());
        return "Home/index";
    }
    @GetMapping("/cart/update+1/{id}")
    public String update1(Model model, @PathVariable("id") String id){
        IdGioHangChiTiet idGHCT = new IdGioHangChiTiet();
        idGHCT.setSpct(svspct.getOne(UUID.fromString(id)));
        idGHCT.setGh(svgh.getById(UUID.fromString("37311b6e-5c99-ce4a-ab80-c1e61b688749")));
        GioHangChiTiet ghct = svghct.getById(idGHCT);
        ghct.setSoLuong(ghct.getSoLuong()+1);
        svghct.update(ghct);
        model.addAttribute("view", "cart.jsp");
        model.addAttribute("list", svghct.getAll());
        return "Home/index";
    }
    @GetMapping("/cart/update-1/{id}")
    public String update2(Model model, @PathVariable("id") String id){
        IdGioHangChiTiet idGHCT = new IdGioHangChiTiet();
        idGHCT.setSpct(svspct.getOne(UUID.fromString(id)));
        idGHCT.setGh(svgh.getById(UUID.fromString("37311b6e-5c99-ce4a-ab80-c1e61b688749")));
        GioHangChiTiet ghct = svghct.getById(idGHCT);
        ghct.setSoLuong(ghct.getSoLuong()-1);
        svghct.update(ghct);
        model.addAttribute("view", "cart.jsp");
        model.addAttribute("list", svghct.getAll());
        return "Home/index";
    }
    @GetMapping("/cart/index")
    public String cart(Model model){
        List<GioHangChiTiet> list = svghct.getAll();
        model.addAttribute("view","cart.jsp");
        model.addAttribute("list",list);
        return "Home/index";
    }
    @GetMapping("/cart/payment/view/{id}/{soLuong}")
    public String cartPayment(Model model,@PathVariable("id")String id,
                              @PathVariable("soLuong") Integer soLuong){
        Items item = new Items("Phúc Đỗ Hùng",svspct.getOne(UUID.fromString(id)).getSp().getTen(),
                svspct.getOne(UUID.fromString(id)).getMs().getTen() ,
                Date.valueOf(LocalDate.now()), UUID.fromString(id),soLuong,
                svspct.getOne(UUID.fromString(id)).getGiaBan());
        model.addAttribute("id",id);
        model.addAttribute("view","billToCart.jsp");
        model.addAttribute("hd",item);
        model.addAttribute("count",svhd.countById(UUID.fromString("c7fd07a3-842c-3d4d-abb4-43757da88f34")));
        session.setAttribute("viewHD",item);
        return "Home/index";
    }
    @GetMapping("/hd/view/{id}")
    public String viewHD(Model model, @PathVariable("id")String id,
                        @RequestParam("sl")Integer sl){
        Items item = new Items("Phúc Đỗ Hùng",svspct.getOne(UUID.fromString(id)).getSp().getTen(),
                svspct.getOne(UUID.fromString(id)).getMs().getTen() ,
                Date.valueOf(LocalDate.now()), UUID.fromString(id),sl,
                svspct.getOne(UUID.fromString(id)).getGiaBan());
        model.addAttribute("id",id);
        model.addAttribute("view","bill.jsp");
        model.addAttribute("hd",item);
        model.addAttribute("count",svhd.countById(UUID.fromString("c7fd07a3-842c-3d4d-abb4-43757da88f34")));
        session.setAttribute("viewHD",item);
        return "Home/index";
    }
    @PostMapping("/hd/add/{idCTSP}")
    public String addHD(Model model,@PathVariable("idCTSP")String id
            //            ,
//                        @RequestParam("tenKH") String tenKH,
//                        @RequestParam("tenSP") String tenSP,
//                        @RequestParam("mauSac") String mauSac,
//                        @RequestParam("donGia") BigDecimal donGia,
//                        @RequestParam("soLuong")Integer sl,
//                        @RequestParam("ngayTao") Date ngayTao
        ){
        Items viewHD = (Items) session.getAttribute("viewHD");
        HoaDon hd = new HoaDon();
//        GioHang gh = svgh.getById(UUID.fromString("37311b6e-5c99-ce4a-ab80-c1e61b688749"));
        hd.setKh(svkh.getById(UUID.fromString("c7fd07a3-842c-3d4d-abb4-43757da88f34")));
        hd.setMa("HD1N"+svhd.getAll().size()+1);
        hd.setNv(svnv.getById(UUID.fromString("bbc22009-cad2-d14f-b11f-0598d735b39c")));
        hd.setNgayTao(Date.valueOf(LocalDate.now()));
        hd.setNgayThanhToan(Date.valueOf(LocalDate.now()));
        hd.setTinhTrang(0);
        hd.setTenNguoiNhan(svkh.getById(UUID.fromString("c7fd07a3-842c-3d4d-abb4-43757da88f34")).getHo()+
                " "+svkh.getById(UUID.fromString("c7fd07a3-842c-3d4d-abb4-43757da88f34")).getTen());
        hd.setDiaChi(svkh.getById(UUID.fromString("c7fd07a3-842c-3d4d-abb4-43757da88f34")).getDiaChi());
        hd.setSdt(svkh.getById(UUID.fromString("c7fd07a3-842c-3d4d-abb4-43757da88f34")).getSdt());
        svhd.save(hd);
        HDCT hdct = new HDCT();
        IdHoaDonChiTiet idHDCT = new IdHoaDonChiTiet();
        if(svhd.existById(hd.getId())) {
            idHDCT.setHd(hd);
        }
        idHDCT.setSpct(svspct.getOne(UUID.fromString(id)));
        hdct.setId(idHDCT);
        hdct.setSoLuong(viewHD.getSoLuong());
        hdct.setDonGia(viewHD.getDonGia());
        svhdct.save(hdct);
            Items item = new Items();
            item.setIdCTSP(UUID.fromString(id));
            item.setTenKH(viewHD.getTenKH());
            item.setTenSP(viewHD.getTenSP());
            item.setMauSac(viewHD.getMauSac());
            item.setDonGia(viewHD.getDonGia());
            item.setNgayTao(viewHD.getNgayTao());
            item.setSoLuong(viewHD.getSoLuong());
            model.addAttribute("view","bill.jsp");
            model.addAttribute("hd",item);
            model.addAttribute("attribute","success");
            model.addAttribute("message","Chờ Xác Nhận!");
        HistoryList h = (HistoryList) session.getAttribute("history");
        HistoryBuy hb = new HistoryBuy();
        hb.setDateTime(new java.util.Date());
        hb.setStatus(0);
        hb.setMaHD(hd.getMa());
        SanPhamChiTiet spct = svspct.getOne(UUID.fromString(id));
        spct.setSlt(spct.getSlt()-viewHD.getSoLuong());
        svspct.update(spct);
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
        IdGioHangChiTiet idGhct = new IdGioHangChiTiet();
        idGhct.setSpct(svspct.getOne(UUID.fromString(id)));
        idGhct.setGh(svgh.getById(UUID.fromString("37311b6e-5c99-ce4a-ab80-c1e61b688749")));
        svghct.delete(idGhct);
        SanPhamChiTiet spctUpdate = svspct.getOne(UUID.fromString(id));
        spctUpdate.setSlt(spctUpdate.getSlt()-viewHD.getSoLuong());
        svspct.update(spctUpdate);
        model.addAttribute("count",svhd.countById(UUID.fromString("c7fd07a3-842c-3d4d-abb4-43757da88f34")));
        return "Home/index";
    }
    @GetMapping("/history")
    public String history(Model model){
        HistoryList list = (HistoryList) session.getAttribute("history");
        if(list==null){
            model.addAttribute("view","history.jsp");
            return "Home/index";
        }
        List<HistoryBuy> listItem = list.getListHistory();
        model.addAttribute("view","history.jsp");
        model.addAttribute("listht",listItem);
        return "Home/index";
    }
}
