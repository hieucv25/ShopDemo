<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form class="d-flex" role="search" method="POST" action="/nhan-vien/search" style="padding-top: 20px">
    <div class="col-md-2"></div>
    <div class="col-md-6">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="keyword">
    </div>
    <div class="col-md-4" style="padding-left: 10px; padding-top: 10px;">
        <button class="btn btn-outline-success" type="submit">Search</button>
    </div>
</form>

<form method="POST" class="col-md-12" action="/nhan-vien/save">
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Mã</label>
            <input type="text" class="form-control" placeholder="Mã" name="ma" value="${nv.ma}">
            <label style="padding-top: 2px;font-weight: bold;color: red;">${validateMa}</label>
        </div>
        <div class="col-md-6">
            <label>Tên</label>
            <input type="text" class="form-control" placeholder="Tên" name="ten" value="${nv.ten}">
            <label style="padding-top: 2px;font-weight: bold;color: red;">${validateTen}</label>
        </div>
    </div>
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Tên Đệm</label>
            <input type="text" class="form-control" placeholder="Tên Đệm" name="tenDem" value="${nv.tenDem}">
            <label style="padding-top: 2px;font-weight: bold;color: red;">${validateTenDem}</label>
        </div>
        <div class="col-md-6">
            <label>Họ</label>
            <input type="text" class="form-control" placeholder="Họ" name="ho" value="${nv.ho}">
            <label style="padding-top: 2px;font-weight: bold;color: red;">${validateHo}</label>
        </div>
    </div>
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Gender</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioiTinh" value="Nam">
                <label class="form-check-label">
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioiTinh" value="Nữ" checked>
                <label class="form-check-label" >
                    Nữ
                </label>
            </div>
        </div>
        <div class="col-md-6">
            <label>Địa Chỉ</label>
            <input class="form-control" rows="4" name="diaChi" value="${nv.diaChi}">
            <label style="padding-top: 2px;font-weight: bold;color: red;">${validateDiaChi}</label>
        </div>
    </div>
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Ngày Sinh</label>
            <input type="date" class="form-control" placeholder="Ngày Sinh" name="ngaySinh" value="${nv.ngaySinh}">
            <label style="padding-top: 2px;font-weight: bold;color: red;">${validateNgaySinh}</label>
        </div>
        <div class="col-md-6">
            <label>Số Điện Thoại</label>
            <input type="text" class="form-control" placeholder="Số Điện Thoại" name="sdt" value="${nv.sdt}">
            <label style="padding-top: 2px;font-weight: bold;color: red;">${validateSDT}</label>
        </div>
    </div>
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Mật Khẩu</label>
            <input type="text" class="form-control" placeholder="Mật Khẩu" name="matKhau">
        </div>
        <div class="col-md-6">
            <label>Trạng Thái</label>
            <select class="form-select" aria-label="Default select example" name="trangThai">
                <option selected value="null">Open this select menu</option>
                <option value="0" ${nv.trangThai == 0 ? "selected":""}>Đi Làm</option>
                <option value="1" ${nv.trangThai == 1 ? "selected":""}>Nghỉ Phép</option>
                <option value="2" ${nv.trangThai == 2 ? "selected":""}>Nghỉ Việc</option>
            </select>
            <label style="padding-top: 2px;font-weight: bold;color: red;">${validateTT}</label>
        </div>
    </div>
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Chức Vụ</label>
            <select class="form-select" aria-label="Default select example" name="cv">
                <option selected value="null">Open this select menu</option>
                <c:forEach items="${cv}" var="cv">
                    <option value="${cv.id}">${cv.ten}</option>
                </c:forEach>
            </select>
            <label style="padding-top: 2px;font-weight: bold;color: red;">${validateCV}</label>
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
        <td>Giới Tính</td>
        <td>Ngày Sinh</td>
        <td>Địa Chỉ</td>
        <td>SDT</td>
        <td>Mật Khẩu</td>
        <td>Trạng Thái</td>
        <td>Chức Vụ</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="nv" varStatus="index">
        <tr>
            <td>${index.index + 1}</td>
            <td>${nv.ma}</td>
            <td>${nv.ten}</td>
            <td>${nv.tenDem}</td>
            <td>${nv.ho}</td>
            <td>${nv.gioiTinh}</td>
            <td>${nv.ngaySinh}</td>
            <td>${nv.diaChi}</td>
            <td>${nv.sdt}</td>
            <td>${nv.matKhau}</td>
            <td>${nv.trangThai==0 ? "Đi làm":"Nghỉ phép"}</td>
            <td>${nv.cv.ten}</td>
            <td>
                <a class="btn btn-danger" href="/nhan-vien/delete/${nv.id}">Delete</a>
                <a class="btn btn-success" href="/nhan-vien/detail/${nv.id}">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>