<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="d-flex" role="search" method="POST" action="/home/search" style="padding-top: 20px">
    <div class="col-md-2"></div>
    <div class="col-md-6">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="ten">
    </div>
    <div class="col-md-4" style="padding-left: 10px;padding-top: 10px;">
        <button class="btn btn-outline-success" type="submit">Search</button>
    </div>
</form>
<form method="POST" class="col-md-10" action="/cua-hang/save">
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Mã</label>
            <input type="text" class="form-control" placeholder="Mã" name="ma" value="${ch.ma}" >
            <label style="padding-top: 5px;color: red; font-weight: bold;">${message}</label>
        </div>
        <div class="col-md-6">
            <label>Tên</label>
            <input type="text" class="form-control" placeholder="Tên" name="ten" value="${ch.ten}">
        </div>
    </div>
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Thành Phố</label>
            <select class="form-select" aria-label="Default select example" name="thanhPho">
                <option selected>Open this select menu</option>
                <option value="Hanoi" ${ch.thanhPho == "Hanoi" ? "selected":""}>Hanoi</option>
                <option value="Seoul" ${ch.thanhPho == "Seoul" ? "selected":""}>Seoul</option>
                <option value="NewYork" ${ch.thanhPho == "NewYork" ? "selected":""}>NewYork</option>
                <option value="London" ${ch.thanhPho == "London" ? "selected":""}>London</option>
                <option value="Tokyo" ${ch.thanhPho == "Tokyo" ? "selected":""}>Tokyo</option>
                <option value="Berlin" ${ch.thanhPho == "Berlin" ? "selected":""}>Berlin</option>
            </select>
        </div>
        <div class="col-md-6">
            <label>Quốc Gia</label>
            <select class="form-select" aria-label="Default select example" name="quocGia">
                <option selected>Open this select menu</option>
                <option value="VietNam" ${ch.quocGia == "VietNam" ? "selected":""}>VietNam</option>
                <option value="Korea" ${ch.quocGia == "Korea" ? "selected":""}>Korea</option>
                <option value="America" ${ch.quocGia == "America" ? "selected":""}>America</option>
                <option value="England" ${ch.quocGia == "England" ? "selected":""}>England</option>
                <option value="Japan" ${ch.quocGia == "Japan" ? "selected":""}>Japan</option>
                <option value="Germany" ${ch.quocGia == "Germany" ? "selected":""}>Germany</option>
            </select>
        </div>
    </div>
    <div class="row" style="display: flex; justify-content: center; align-items: center;" >
        <div class="col-md-6">
            <label>Địa Chỉ</label>
            <input class="form-control" rows="4" name="diaChi" value="${ch.diaChi}">
        </div>
        <div class="col-md-6" style="padding-top: 30px;">
            <button type="submit" class="btn btn-success">
                Save
            </button>
        </div>
    </div>
</form>
<table class="table">
    <thead>
    <tr>
        <td>Mã</td>
        <td>Tên</td>
        <td>Địa Chỉ</td>
        <td>Thành Phố</td>
        <td>Quốc Gia</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="ch" varStatus="index">
        <tr>
            <td>${ch.ma}</td>
            <td>${ch.ten}</td>
            <td>${ch.diaChi}</td>
            <td>${ch.thanhPho}</td>
            <td>${ch.quocGia}</td>
            <td>
                <a class="btn btn-danger" href="/cua-hang/delete/${ch.id}">Delete</a>
                <a class="btn btn-success" href="/cua-hang/detail/${ch.id}">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>