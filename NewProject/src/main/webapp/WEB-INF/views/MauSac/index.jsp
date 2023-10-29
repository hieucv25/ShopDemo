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
<form method="POST" class="col-md-10" action="/mau-sac/save">
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Mã</label>
            <input type="text" class="form-control" placeholder="Mã" name="ma" value="${ms.ma}" >
            <label style="padding-top: 5px;color: red; font-weight: bold;">${message}</label>
        </div>
        <div class="col-md-6">
            <label>Tên</label>
            <input type="text" class="form-control" placeholder="Tên" name="ten" value="${ms.ten}">
        </div>
    </div>
    <div class="row" style="display: flex; justify-content: center; align-items: center;" >
        <div class="col-md-6">
        </div>
        <div class="col-md-6">
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
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="ms" varStatus="index">
        <tr>
            <td>${ms.ma}</td>
            <td>${ms.ten}</td>
            <td>
                <a class="btn btn-danger" href="/mau-sac/delete/${ms.id}">Delete</a>
                <a class="btn btn-success" href="/mau-sac/detail/${ms.id}">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>