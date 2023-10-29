<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.lang.String"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1 class="text-center">Cart</h1>
<div class="row">
    <div class="col col-md-12">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>No</th>
                <th>Picture</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Color</th>
                <th>Price</th>
                <th>Into Money</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody id="datarow">
                <c:forEach items="${list}" var="p" varStatus="index">
                    <tr>
                        <td>${index.index + 1}</td>
                        <td>
                            <img src="../assets/img/product/iphone5-white.jpeg" class="hinhdaidien">
                        </td>
                        <td class="text-right">${p.id.spct.sp.ten}</td>
                        <td class="text-right">${p.soLuong}</td>
                        <td class="text-right">${p.id.spct.ms.ten}</td>
                        <td class="text-right">${p.donGia} VND</td>
                        <td class="text-right">${p.donGia*p.soLuong} VND</td>
                        <td>
                            <a class="btn btn-danger" href="/home/cart/update-1/${p.id.spct.id}">
                                <i class="fa fa-shopping-cart"
                                   aria-hidden="true"></i> - 1
                            </a>
                            <a class="btn btn-danger" href="/home/cart/update+1/${p.id.spct.id}">
                                <i class="fa fa-shopping-cart"
                                   aria-hidden="true"></i> + 1
                            </a>
                            <a class="btn btn-danger" href="/home/cart/delete/${p.id.spct.id}">
                                <i class="fa fa-trash" aria-hidden="true"></i> Delete
                            </a>
                            <a href="/home/cart/payment/view/${p.id.spct.id}/${p.soLuong}"
                               class="btn btn-primary btn-md"><i class="fa fa-shopping-cart"
                                                                          aria-hidden="true"></i>&nbsp;Payment</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <a href="/home/index" class="btn btn-warning btn-md"><i class="fa fa-arrow-left"
                                                                  aria-hidden="true"></i>&nbsp;Back</a>
        <a href="#ChuaNghiRaCachLam" class="btn btn-primary btn-md"><i class="fa fa-shopping-cart"
                                                                  aria-hidden="true"></i>&nbsp;Payment All</a>
    </div>
</div>
<br>
<br>