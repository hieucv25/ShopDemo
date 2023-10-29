<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<br>
<br>
<a href="/nhan-vien/index" style="padding-left: 20px; color: green; font-size: 35px;"><i class="fa-solid fa-backward"></i></a>
<br>
<br>
<form method="POST" class="col-md-10" action="/nhan-vien/update/${nv.id}">
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Mã</label>
            <input type="text" class="form-control" placeholder="Mã" name="ma" value="${nv.ma}" disabled>
        </div>
        <div class="col-md-6">
            <label>Tên</label>
            <input type="text" class="form-control" placeholder="Tên" name="ten" value="${nv.ten}">
        </div>
    </div>
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Tên Đệm</label>
            <input type="text" class="form-control" placeholder="Tên Đệm" name="tenDem" value="${nv.tenDem}">
        </div>
        <div class="col-md-6">
            <label>Họ</label>
            <input type="text" class="form-control" placeholder="Họ" name="ho" value="${nv.ho}">
        </div>
    </div>
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Gender</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioiTinh" value="Nam" ${nv.gioiTinh=="Nam"?"checked":""}>
                <label class="form-check-label">
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioiTinh" value="Nữ" ${nv.gioiTinh=="Nữ"?"checked":""}>
                <label class="form-check-label" >
                    Nữ
                </label>
            </div>
        </div>
        <div class="col-md-6">
            <label>Địa Chỉ</label>
            <input class="form-control" rows="4" name="diaChi" value="${nv.diaChi}">
        </div>
    </div>
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Ngày Sinh</label>
            <input type="date" class="form-control" placeholder="Ngày Sinh" name="ngaySinh" value="${nv.ngaySinh}">
        </div>
        <div class="col-md-6">
            <label>Số Điện Thoại</label>
            <input type="text" class="form-control" placeholder="Số Điện Thoại" name="sdt" value="${nv.sdt}">
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
                <option value="0" ${nv.trangThai == 0 ? "selected":""}>Đi Làm</option>
                <option value="1" ${nv.trangThai == 1 ? "selected":""}>Nghỉ Phép</option>
                <option value="2" ${nv.trangThai == 2 ? "selected":""}>Nghỉ Việc</option>
            </select>
        </div>
    </div>
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Chức Vụ</label>
            <select class="form-select" aria-label="Default select example" name="cv">
                <c:forEach items="${cv}" var="cv">
                    <option value="${cv.id}" ${nv.cv.id == cv.id ? "selected":""}>${cv.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <button type="submit" class="btn btn-success">Update</button>
        </div>
    </div>
</form>