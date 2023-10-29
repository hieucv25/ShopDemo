<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${message != null}">
    <div class="alert alert-secondary" role="alert">
        ${message}
    </div>
</c:if>
<style>
    .page-link{
        color: green;
    }
    .page-link:hover{
        color: white;
        background-color: green;
    }
</style>
<form class="d-flex" role="search" method="POST" action="/hoa-don/search/${list.number}" style="padding-top: 20px">
    <div class="col-md-2"></div>
    <div class="col-md-6">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="keyword">
    </div>
    <div class="col-md-4" style="padding-left: 10px; padding-top: 10px;">
        <button class="btn btn-outline-success" type="submit">Search</button>
    </div>
</form>

<form method="POST" class="col-md-12" action="/hoa-don/update/${hd.id}/${list.number}">
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Mã</label>
            <input type="text" class="form-control" placeholder="Mã" name="ma" value="${hd.ma}" disabled>
        </div>
        <div class="col-md-6">
            <label>Ngày Tạo</label>
            <input type="text" class="form-control" name="ngayTao" value="${hd.ngayTao}" disabled>
        </div>
    </div>
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Ngày Thanh Toán</label>
            <input type="text" class="form-control" name="ngayThanhToan" value="${hd.ngayThanhToan}" disabled>
        </div>
        <div class="col-md-6">
            <label>Ngày Ship</label>
            <input type="date" class="form-control" placeholder="Ngày Ship" name="ngayShip" value="${hd.ngayShip}">
        </div>
    </div>
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Ngày Nhận</label>
            <input type="date" class="form-control" placeholder="Ngày Nhận" name="ngayNhan" value="${hd.ngayNhan}">
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label class="form-label">Địa Chỉ</label>
                <input type="text" class="form-control" placeholder="Địa Chỉ" name="diaChi" value="${hd.diaChi}">
            </div>
        </div>
    </div>
    <div class="row" >
        <div class="col-md-6" style="padding-top: 20px">
            <label>Trạng Thái</label>
            <select class="form-select" aria-label="Default select example" name="tinhTrang">
                <option selected value="0" ${hd.tinhTrang == 0 ? "selected":""}>Chờ Xác Nhận</option>
                <option value="1" ${hd.tinhTrang == 1 ? "selected":""}>Đang Giao Hàng</option>
                <option value="2" ${hd.tinhTrang == 2 ? "selected":""}>Giao Hàng Thành Công</option>
            </select>
        </div>
        <div class="col-md-6" style="padding-top: 20px">
            <label>Số Điện Thoại</label>
            <input type="text" class="form-control" placeholder="Số Điện Thoại" name="sdt" value="${hd.sdt}">
        </div>
    </div>
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-2" style="margin-top: 20px;">
        </div>
        <div class="col-md-2" style="margin-top: 20px;">
        </div>
        <div class="col-md-1" style="margin-top: 20px;">
        </div>
        <div class="col-md2" style="margin-top: 20px; display: flex;justify-content: center;align-items: center;">
            <button type="submit" class="btn btn-success">Update</button>
        </div>
        <div class="col-md-1" style="margin-top: 20px;">
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
        <td>Ngày Tạo</td>
        <td>Ngày Thanh Toán</td>
        <td>Ngày Ship</td>
        <td>Ngày Nhận</td>
        <td>Trạng Thái</td>
        <td>Địa Chỉ</td>
        <td>SDT</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list.content}" var="hd" varStatus="index">
        <tr>
            <td>${index.index + 1}</td>
            <td>${hd.ma}</td>
            <td>${hd.ngayTao}</td>
            <td>${hd.ngayThanhToan}</td>
            <td>${hd.ngayShip}</td>
            <td>${hd.ngayNhan}</td>
            <c:if test="${hd.tinhTrang==0}">
                <td>Chờ Xác Nhận</td>
            </c:if>
            <c:if test="${hd.tinhTrang==1}">
                <td>Đang Giao Hàng</td>
            </c:if>
            <c:if test="${hd.tinhTrang==2}">
                <td>Giao Hàng Thành Công</td>
            </c:if>
            <td>${hd.diaChi}</td>
            <td>${hd.sdt}</td>
            <td>
                <a class="btn btn-danger" href="/hoa-don/delete/${hd.id}/${list.number}">Delete</a>
                <a class="btn btn-success" href="/hoa-don/detail/${hd.id}/${list.number}">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example" style="display: flex;justify-content: center;align-items: center;">
    <ul class="pagination">
        <li class="page-item"><a class="page-link" href="/hoa-don/page/0"><i class="fa-solid fa-backward-fast"></i></a></li>
        <li class="page-item">
            <c:if test="${list.number-1 < 0}">
                <a class="page-link" href="/hoa-don/page/${list.totalPages - 1}">
                    <i class="fa-solid fa-backward"></i>
                </a>
            </c:if>
            <c:if test="${list.number-1 == 0}">
                <a class="page-link" href="/hoa-don/page/${list.number - 1}">
                    <i class="fa-solid fa-backward"></i>
                </a>
            </c:if>
            <c:if test="${list.number-1 <= list.totalPages-1 && list.number -1 > 0}">
                <a class="page-link" href="/hoa-don/page/${list.number -1}">
                    <i class="fa-solid fa-backward"></i>
                </a>
            </c:if>
        </li>
        <li class="page-item"><a class="page-link" aria-disabled="true">${list.number}</a></li>
        <li class="page-item">
            <c:if test="${list.totalPages - 1 < list.number + 1}">
                <a class="page-link" href="/hoa-don/page/0">
                    <i class="fa-solid fa-forward"></i>
                </a>
            </c:if>
            <c:if test="${list.totalPages > list.number + 1}">
                <a class="page-link" href="/hoa-don/page/${list.number + 1}">
                    <i class="fa-solid fa-forward"></i>
                </a>
            </c:if>
        </li>
        <li class="page-item">
            <a class="page-link" href="/hoa-don/page/${list.totalPages - 1}">
                <i class="fa-solid fa-forward-fast"></i>
            </a>
        </li>
    </ul>
</nav>