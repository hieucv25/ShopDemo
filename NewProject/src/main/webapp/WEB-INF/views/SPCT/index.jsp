<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${message != null}">
    <div class="alert alert-danger" role="alert" style="width: 200px; background-color: rgb(179,58,58); color: white;font-weight: bold;">
            ${message}
    </div>
</c:if>
<br>
<br>
<form class="d-flex" role="search" method="POST" action="/nhan-vien/search" style="padding-top: 20px">
    <div class="col-md-2"></div>
    <div class="col-md-6">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="keyword">
    </div>
    <div class="col-md-4" style="padding-left: 10px;padding-top: 10px;">
        <button class="btn btn-outline-success" type="submit">Search</button>
    </div>

</form>
<form method="POST" class="col-md-10" action="/spct/save">
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Sản Phẩm</label>
            <select class="form-select" aria-label="Default select example" name="sp">
                <option selected value="null">Open this select menu</option>
                <c:forEach items="${listSP}" var="sp">
                    <option value="${sp.id}" ${spct.sp.id == sp.id ? "selected":""}>${sp.ten}</option>
                </c:forEach>
                <label style="padding-top: 2px;font-weight: bold;color: red;">${validateSP}</label>
            </select>
        </div>
        <div class="col-md-6">
            <label>Nhà Sản Xuất</label>
            <select class="form-select" aria-label="Default select example" name="nsx">
                <option selected value="null">Open this select menu</option>
                <c:forEach items="${listNSX}" var="nsx">
                    <option value="${nsx.id}" ${spct.nsx.id == nsx.id ? "selected":""}>${nsx.ten}</option>
                </c:forEach>
                <label style="padding-top: 2px;font-weight: bold;color: red;">${validateNSX}</label>
            </select>
        </div>
    </div>
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Màu Sắc</label>
            <select class="form-select" aria-label="Default select example" name="ms">
                <option selected value="null">Open this select menu</option>
                <c:forEach items="${listMS}" var="ms">
                    <option value="${ms.id}" ${ms.id == spct.ms.id ?"selected":""}>${ms.ten}</option>
                </c:forEach>
                <label style="padding-top: 2px;font-weight: bold;color: red;">${validateMS}</label>
            </select>
        </div>
        <div class="col-md-6">
            <label>Dòng Sản Phẩm</label>
            <select class="form-select" aria-label="Default select example" name="dsp">
                <option selected value="null">Open this select menu</option>
                <c:forEach items="${listDSP}" var="dsp">
                    <option value="${dsp.id}" ${spct.dsp.id == dsp.id ? "selected":""}>${dsp.ten}</option>
                </c:forEach>
                <label style="padding-top: 2px;font-weight: bold;color: red;">${validateDSP}</label>
            </select>
        </div>
        <div class="row" style="display: flex; justify-content: center; align-items: center;">
            <div class="col-md-6">
                <label>Năm Bảo Hành</label>
                <input type="text" class="form-control" placeholder="Năm Bảo Hành" name="namBH" value="${spct.namBH}">
                <label style="padding-top: 2px;font-weight: bold;color: red;">${validateNamBH}</label>
            </div>
            <div class="col-md-6">
                <label>Mô Tả</label>
                <input type="text" class="form-control" placeholder="Tên" name="moTa" value="${spct.moTa}">
                <label style="padding-top: 2px;font-weight: bold;color: red;">${validateMoTa}</label>
            </div>
        </div>
        <div class="row" style="display: flex; justify-content: center; align-items: center;">
            <div class="col-md-6">
                <label>Giá Nhập</label>
                <input type="text" class="form-control" placeholder="Giá Nhập" name="giaNhap" value="${spct.giaNhap}">
                <label style="padding-top: 2px;font-weight: bold;color: red;">${validateGiaNhap}</label>
            </div>
            <div class="col-md-6">
                <label>Giá Bán</label>
                <input type="text" class="form-control" placeholder="Giá Bán" name="giaBan" value="${spct.giaBan}">
                <label style="padding-top: 2px;font-weight: bold;color: red;">${validateGiaBan}</label>
            </div>
        </div>
        <div class="row" style="display: flex; justify-content: center; align-items: center;">
            <div class="col-md-6">
                <label>Số Lượng Tồn</label>
                <input type="text" class="form-control" placeholder="Số Lượng Tồn" name="slt" value="${spct.slt}">
                <label style="padding-top: 2px;font-weight: bold;color: red;">${validateSLT}</label>
            </div>
            <div class="col-md-6" style="padding-top: 30px;">
                <button class="btn btn-success">Save</button>
            </div>
        </div>
    </div>
</form>
<table class="table">
    <thead>
    <tr>
        <td>STT</td>
        <td>Sản Phẩm</td>
        <td>Nhà Sản Xuất</td>
        <td>Màu Sắc</td>
        <td>Dòng Sản Phẩm</td>
        <td>Năm Bảo Hành</td>
        <td>Mô Tả</td>
        <td>Số Lượng</td>
        <td>Giá Nhập</td>
        <td>Giá Bán</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listSPCT}" var="spct" varStatus="index">
        <tr>
            <td>${index.index + 1}</td>
            <td>${spct.sp.ten}</td>
            <td>${spct.nsx.ten}</td>
            <td>${spct.ms.ten}</td>
            <td>${spct.dsp.ten}</td>
            <td>${spct.namBH}</td>
            <td>${spct.moTa}</td>
            <td>${spct.slt}</td>
            <td>${spct.giaNhap}</td>
            <td>${spct.giaBan}</td>
            <td>
                <a class="btn btn-danger" href="/spct/delete/${spct.id}">Delete</a>
                <a class="btn btn-success" href="/spct/detail/${spct.id}">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>