<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form class="d-flex" role="search" method="POST" action="/khach-hang/search" style="padding-top: 20px">
    <div class="col-md-2"></div>
    <div class="col-md-6">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="keyword">
    </div>
    <div class="col-md-4" style="padding-left: 10px; padding-top: 10px;">
        <button class="btn btn-outline-success" type="submit">Search</button>
    </div>
</form>

<form method="POST" class="col-md-12" action="/khach-hang/save">
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
                <option selected>Open this select menu</option>
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
                <option selected>Open this select menu</option>
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
            <button type="submit" class="btn btn-success">Thêm</button>
        </div>
    </div>
</form>
<table class="table" style="font-size: 12px">
    <thead>
    <tr>
        <td>STT</td>
        <td>Mã</td>
        <td>Tên</td>
        <td>Tên Đệm</td>
        <td>Họ</td>
        <td>Ngày Sinh</td>
        <td>Địa Chỉ</td>
        <td>Thành Phố</td>
        <td>Quốc Gia</td>
        <td>SDT</td>
        <td>Mật Khẩu</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="kh" varStatus="index">
        <tr>
            <td>${index.index + 1}</td>
            <td>${kh.ma}</td>
            <td>${kh.ten}</td>
            <td>${kh.tenDem}</td>
            <td>${kh.ho}</td>
            <td>${kh.ngaySinh}</td>
            <td>${kh.diaChi}</td>
            <td>${kh.thanhPho}</td>
            <td>${kh.quocGia}</td>
            <td>${kh.sdt}</td>
            <td>${kh.matKhau}</td>
            <td>
                <a class="btn btn-danger" href="/khach-hang/delete/${kh.id}">Delete</a>
                <a class="btn btn-success" href="/khach-hang/detail/${kh.id}">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>