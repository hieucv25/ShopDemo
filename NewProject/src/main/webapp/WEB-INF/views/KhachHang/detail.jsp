<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<br>
<br>
<a href="/khach-hang/index" style="padding-left: 20px; color: green; font-size: 35px;"><i class="fa-solid fa-backward"></i></a>
<br>
<br>
<form method="POST" class="col-md-12" action="/khach-hang/update/${kh.id}">
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Mã</label>
            <input type="text" class="form-control" placeholder="Mã" name="ma" value="${kh.ma}">
            <label style="padding-top: 2px;font-weight: bold;color: red;">${validateMa}</label>
        </div>
        <div class="col-md-6">
            <label>Tên</label>
            <input type="text" class="form-control" placeholder="Tên" name="ten" value="${kh.ten}">
            <label style="padding-top: 2px;font-weight: bold;color: red;">${validateTen}</label>
        </div>
    </div>
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Tên Đệm</label>
            <input type="text" class="form-control" placeholder="Tên Đệm" name="tenDem" value="${kh.tenDem}">
            <label style="padding-top: 2px;font-weight: bold;color: red;">${validateTenDem}</label>
        </div>
        <div class="col-md-6">
            <label>Họ</label>
            <input type="text" class="form-control" placeholder="Họ" name="ho" value="${kh.ho}">
            <label style="padding-top: 2px;font-weight: bold;color: red;">${validateHo}</label>
        </div>
    </div>
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Mật Khẩu</label>
            <input type="text" class="form-control" placeholder="Mật Khẩu" name="matKhau">
            <label style="padding-top: 2px;font-weight: bold;color: red;">${validateMatKhau}</label>
        </div>
        <div class="col-md-6">
            <label>Địa Chỉ</label>
            <input class="form-control" rows="4" name="diaChi" value="${kh.diaChi}">
            <label style="padding-top: 2px;font-weight: bold;color: red;">${validateDiaChi}</label>
        </div>
    </div>
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Ngày Sinh</label>
            <input type="date" class="form-control" placeholder="Ngày Sinh" name="ngaySinh" value="${kh.ngaySinh}">
            <label style="padding-top: 2px;font-weight: bold;color: red;">${validateNgaySinh}</label>
        </div>
        <div class="col-md-6">
            <label>Số Điện Thoại</label>
            <input type="text" class="form-control" placeholder="Số Điện Thoại" name="sdt" value="${kh.sdt}">
            <label style="padding-top: 2px;font-weight: bold;color: red;">${validateSDT}</label>
        </div>
    </div>
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Thành Phố</label>
            <select class="form-select" aria-label="Default select example" name="thanhPho">
                <option value="Hanoi" ${kh.thanhPho == "Hanoi" ? "selected":""}>Hanoi</option>
                <option value="Seoul" ${kh.thanhPho == "Seoul" ? "selected":""}>Seoul</option>
                <option value="NewYork" ${kh.thanhPho == "NewYork" ? "selected":""}>NewYork</option>
                <option value="London" ${kh.thanhPho == "London" ? "selected":""}>London</option>
                <option value="Tokyo" ${kh.thanhPho == "Tokyo" ? "selected":""}>Tokyo</option>
                <option value="Berlin" ${kh.thanhPho == "Berlin" ? "selected":""}>Berlin</option>
            </select>
        </div>
        <div class="col-md-6">
            <label>Quốc Gia</label>
            <select class="form-select" aria-label="Default select example" name="quocGia">
                <option value="VietNam" ${kh.quocGia == "VietNam" ? "selected":""}>VietNam</option>
                <option value="Korea" ${kh.quocGia == "Korea" ? "selected":""}>Korea</option>
                <option value="America" ${kh.quocGia == "America" ? "selected":""}>America</option>
                <option value="England" ${kh.quocGia == "England" ? "selected":""}>England</option>
                <option value="Japan" ${kh.quocGia == "Japan" ? "selected":""}>Japan</option>
                <option value="Germany" ${kh.quocGia == "Germany" ? "selected":""}>Germany</option>
            </select>
        </div>
    </div>
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
        </div>
        <div class="col-md-6" style="margin-top: 20px">
            <button type="submit" class="btn btn-success">Update</button>
        </div>
    </div>
</form>