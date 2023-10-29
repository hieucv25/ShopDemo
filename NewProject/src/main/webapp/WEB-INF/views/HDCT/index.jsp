<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form class="d-flex" role="search" method="POST" action="" style="padding-top: 20px">
    <div class="col-md-2"></div>
    <div class="col-md-6">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="keyword">
    </div>
    <div class="col-md-4" style="padding-left: 10px; padding-top: 10px;">
        <button class="btn btn-outline-success" type="submit">Search</button>
    </div>
</form>

<form method="POST" class="col-md-12" action="/hdct/update?idCTSP=${hdct.id.spct.id}&idHD=${hdct.id.hd.id}">
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Mã Hoá Đơn</label>
            <input type="text" class="form-control" value="${hdct.id.hd.ma}" disabled>
        </div>
        <div class="col-md-6">
            <label>Tên Sản Phẩm</label>
            <input type="text" class="form-control" value="${hdct.id.spct.sp.ten}" disabled>
        </div>
    </div>
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Số Lượng</label>
            <input type="text" class="form-control" name="soLuong" value="${hdct.soLuong}">
        </div>
        <div class="col-md-6">
            <label>Đơn Giá</label>
            <input type="text" class="form-control" name="donGia" value="${hdct.donGia}">
        </div>
    </div>
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-2" style="margin-top: 20px;">
        </div>
        <div class="col-md-2" style="margin-top: 20px;">
        </div>
        <div class="col-md-2" style="margin-top: 20px;">
            <button type="submit" class="btn btn-success">Update</button>
        </div>
        <div class="col-md-2" style="margin-top: 20px;">
        </div>
        <div class="col-md-2" style="margin-top: 20px;">
        </div>
        <div class="col-md-2" style="margin-top: 20px;">
        </div>
    </div>
</form>
<table class="table" style="font-size: 12px;margin-top: 20px;">
    <thead>
    <tr>
        <td>No</td>
        <td>Mã Hoá Đơn</td>
        <td>Tên Sản Phẩm</td>
        <td>Số Lượng</td>
        <td>Đơn Giá</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="hdct" varStatus="index">
        <tr>
            <td>${index.index + 1}</td>
            <td>${hdct.id.hd.ma}</td>
            <td>${hdct.id.spct.sp.ten}</td>
            <td>${hdct.soLuong}</td>
            <td>${hdct.donGia} VND</td>
            <td>
                <a class="btn btn-success" href="/hdct/detail?idCTSP=${hdct.id.spct.id}&idHD=${hdct.id.hd.id}">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>