package com.example.demo.controller;

import com.example.demo.Service.ServiceChucVu;
import com.example.demo.Service.ServiceNhanVien;
import com.example.demo.model.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;

@Controller
@RequestMapping("/nhan-vien")
public class NhanVienController {
    @Autowired
    ServiceNhanVien svnv;
    @Autowired
    ServiceChucVu svcv;
    @GetMapping("/index")
    public String home(Model model){
        if(svnv.getAll().size()<=0){
            model.addAttribute("mess","List Student is empty!");
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        } else {
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
    }
    @PostMapping("/search")
    public String search(Model model,@RequestParam("keyword") String keyword){
        ArrayList<NhanVien> listSearch = new ArrayList<>();
        String nameSearch = keyword.toLowerCase(Locale.ROOT);
        for (NhanVien nv: svnv.getAll()
             ) {
            String name = nv.getTen().toLowerCase(Locale.ROOT);
            if(name.contains(nameSearch)){
                listSearch.add(nv);
            }
        }
            model.addAttribute("list", listSearch);
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
    }
    @PostMapping("/save")
    public String save(Model model,@RequestParam("ma") String ma,
                       @RequestParam("ten") String ten,
                       @RequestParam("tenDem") String tenDem,
                       @RequestParam("ho") String ho,
                       @RequestParam("gioiTinh") String gioiTinh,
                       @RequestParam("diaChi") String diaChi,
                       @RequestParam("ngaySinh") String ngaySinh,
                       @RequestParam("sdt") String sdt,
                       @RequestParam("matKhau") String matKhau,
                       @RequestParam("trangThai") String trangThai,
                       @RequestParam("cv") String cv
                       ){
        NhanVien nv = new NhanVien();
        if(ma.isEmpty()){
            model.addAttribute("validateMa","Chưa Nhập Mã!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        if(!ma.matches("^[a-zA-Z][a-zA-Z0-9]{1,19}")){
            model.addAttribute("validateMa","Mã phải bắt đầu bằng chữ! Từ 2 đến 20 kí tự!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        nv.setMa(ma);
        for (NhanVien nhanVien: svnv.getAll()
             ) {
            if(nv.getMa().equalsIgnoreCase(nhanVien.getMa())){
                model.addAttribute("validateMa","Mã Nhân Viên Đã Tồn Tại!");
                model.addAttribute("list", svnv.getAll());
                model.addAttribute("cv",svcv.getAll());
                model.addAttribute("nv",nv);
                model.addAttribute("view","NhanVien/index.jsp");
                return "layout";
            }
        }
        if(ten.isEmpty()){
            model.addAttribute("validateTen","Tên Không Được Để Trống!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        nv.setTen(ten);
        if(!ten.matches("^[a-zA-Z][a-zA-Z ]{1,30}")){
            model.addAttribute("validateTen","Tên phải là chữ! Từ 2 đến 30 kí tự!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        if(tenDem.isEmpty()){
            model.addAttribute("validateTenDem","Tên Đệm Không Được Để Trống!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        nv.setTenDem(tenDem);
        if(!tenDem.matches("[a-zA-Z ]{2,30}")){
            model.addAttribute("validateTenDem","Tên phải là chữ! Từ 2 đến 30 kí tự!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }

        if(ho.isEmpty()){
            model.addAttribute("validateHo","Họ Không Được Để Trống!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        nv.setHo(ho);
        if(!ho.matches("[a-zA-Z ]{2,30}")){
            model.addAttribute("validateHo","Họ phải là chữ! Từ 2 đến 30 kí tự!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        nv.setGioiTinh(gioiTinh);
        if(diaChi.isEmpty()){
            model.addAttribute("validateDiaChi","Địa chỉ chưa được nhập!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        nv.setDiaChi(diaChi);
        if(!diaChi.matches("[a-zA-Z0-9\\W\\s]{1,100}")){
            model.addAttribute("validateDiaChi","Địa chỉ không quá 100 kí tự!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        if(ngaySinh.isEmpty()){
            model.addAttribute("validateNgaySinh","Ngày Sinh Không Được Để Trống!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        nv.setNgaySinh(Date.valueOf(ngaySinh));
        if(sdt.isEmpty()){
            model.addAttribute("validateSDT","SDT Không Được Để Trống!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        if(!sdt.matches("^[0][0-9]{9,12}")){
            model.addAttribute("validateSDT","SDT phải bắt đầu bằng 0 !Từ 9 đến 13 kí tự!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        nv.setSdt(sdt);
        nv.setMatKhau(matKhau);
        if(trangThai.equals("null")){
            model.addAttribute("validateTT","Trạng thái chưa được chọn!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        nv.setTrangThai(Integer.valueOf(trangThai));
        if(cv.equals("null")){
            model.addAttribute("validateCV","Chức Vụ chưa được chọn!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        UUID id = UUID.fromString(cv);
        nv.setCv(svcv.findById(id));
        svnv.save(nv);
        model.addAttribute("list", svnv.getAll());
        model.addAttribute("cv",svcv.getAll());
        model.addAttribute("view","NhanVien/index.jsp");
        return "layout";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model,@PathVariable("id") String id){
        UUID uuid = UUID.fromString(id);
        svnv.delete(uuid);
        model.addAttribute("list", svnv.getAll());
        model.addAttribute("cv",svcv.getAll());
        model.addAttribute("view","NhanVien/index.jsp");
        return "layout";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model,@PathVariable("id") String id){
        UUID uuid = UUID.fromString(id);
        NhanVien nv = svnv.getById(uuid);
        model.addAttribute("nv", nv);
        model.addAttribute("cv",svcv.getAll());
        model.addAttribute("view","NhanVien/detail.jsp");
        return "layout";
    }
    @PostMapping("/update/{id}")
    public String update(Model model,@PathVariable("id") String id,
                       @RequestParam("ten") String ten,
                       @RequestParam("tenDem") String tenDem,
                       @RequestParam("ho") String ho,
                       @RequestParam("gioiTinh") String gioiTinh,
                       @RequestParam("diaChi") String diaChi,
                       @RequestParam("ngaySinh") String ngaySinh,
                       @RequestParam("sdt") String sdt,
                       @RequestParam("matKhau") String matKhau,
                       @RequestParam("trangThai") String trangThai,
                       @RequestParam("cv") String cv
    ){
        UUID uuid = UUID.fromString(id);
        NhanVien nv = svnv.getById(uuid);
        if(ten.isEmpty()){
            model.addAttribute("validateTen","Tên Không Được Để Trống!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        nv.setTen(ten);
        if(!ten.matches("^[a-zA-Z][a-zA-Z ]{1,30}")){
            model.addAttribute("validateTen","Tên phải là chữ! Từ 2 đến 30 kí tự!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        if(tenDem.isEmpty()){
            model.addAttribute("validateTenDem","Tên Đệm Không Được Để Trống!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        nv.setTenDem(tenDem);
        if(!tenDem.matches("[a-zA-Z ]{2,30}")){
            model.addAttribute("validateTenDem","Tên phải là chữ! Từ 2 đến 30 kí tự!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }

        if(ho.isEmpty()){
            model.addAttribute("validateHo","Họ Không Được Để Trống!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        nv.setHo(ho);
        if(!ho.matches("[a-zA-Z ]{2,30}")){
            model.addAttribute("validateHo","Họ phải là chữ! Từ 2 đến 30 kí tự!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        nv.setGioiTinh(gioiTinh);
        if(diaChi.isEmpty()){
            model.addAttribute("validateDiaChi","Địa chỉ chưa được nhập!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        nv.setDiaChi(diaChi);
        if(!diaChi.matches("[a-zA-Z0-9\\W\\s]{1,100}")){
            model.addAttribute("validateDiaChi","Địa chỉ không quá 100 kí tự!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        if(ngaySinh.isEmpty()){
            model.addAttribute("validateNgaySinh","Ngày Sinh Không Được Để Trống!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        nv.setNgaySinh(Date.valueOf(ngaySinh));
        if(sdt.isEmpty()){
            model.addAttribute("validateSDT","SDT Không Được Để Trống!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        if(!sdt.matches("^[0][0-9]{9,12}")){
            model.addAttribute("validateSDT","SDT phải bắt đầu bằng 0 !Từ 9 đến 13 kí tự!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        nv.setSdt(sdt);
        nv.setMatKhau(matKhau);
        if(trangThai.equals("null")){
            model.addAttribute("validateTT","Trạng thái chưa được chọn!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        nv.setTrangThai(Integer.valueOf(trangThai));
        if(cv.equals("null")){
            model.addAttribute("validateCV","Chức Vụ chưa được chọn!");
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("nv",nv);
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
        UUID idCV = UUID.fromString(cv);
        nv.setCv(svcv.findById(idCV));
        nv.setTrangThai(Integer.valueOf(trangThai));
        svnv.update(nv);
        model.addAttribute("list", svnv.getAll());
        model.addAttribute("cv",svcv.getAll());
        model.addAttribute("view","NhanVien/index.jsp");
        return "layout";
    }
}
