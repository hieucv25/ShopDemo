<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<br>
<br>
<c:if test="${message != null}">
    <div class="alert alert-${attribute}" role="alert">
            ${message}
    </div>
</c:if>
<br>
<br>
<div style="margin-left: 20px;">
    <a href="/home/cart/index"
       class="btn btn-warning btn-md">
        <i class="fa fa-arrow-left" aria-hidden="true"></i>&nbsp;Back</a>
</div>
<br>
<br>
<form action="/home/hd/add/${hd.idCTSP}" method="POST">
    <%--    <div class="row" style="margin-left: 20px;">--%>
    <%--            <div class="col-md-6">--%>
    <%--                <label class="form-label">Khách Hàng</label>--%>
    <%--                <br>--%>
    <%--            </div>--%>
    <%--            <div class="col-md-6">--%>
    <%--                <input type="text" class="form-control" name="tenKH" value="${hd.tenKH}" />--%>
    <%--                <br>--%>
    <%--            </div>--%>
    <%--    </div>--%>
    <%--    <div class="row" style="margin-left: 20px;">--%>
    <%--            <div class="col-md-6">--%>
    <%--                <label class="form-label">Sản Phẩm</label>--%>
    <%--                <br>--%>
    <%--            </div>--%>
    <%--            <div class="col-md-6">--%>
    <%--                <input type="text" class="form-control" name="tenSP" value="${hd.tenSP}" />--%>
    <%--                <br>--%>
    <%--            </div>--%>
    <%--    </div>--%>
    <%--    <div class="row" style="margin-left: 20px;">--%>
    <%--        <div class="col-md-6">--%>
    <%--            <label class="form-label">Màu Sắc</label>--%>
    <%--            <br>--%>
    <%--        </div>--%>
    <%--        <div class="col-md-6">--%>
    <%--            <input type="text" class="form-control" name="mauSac" value="${hd.mauSac}" />--%>
    <%--            <br>--%>
    <%--        </div>--%>
    <%--    </div>--%>
    <%--    <div class="row" style="margin-left: 20px;">--%>
    <%--            <div class="col-md-6">--%>
    <%--                <label class="form-label">Số Lượng</label>--%>
    <%--                <br>--%>
    <%--            </div>--%>
    <%--            <div class="col-md-6">--%>
    <%--                <input type="text" class="form-control" name="soLuong" value="${hd.soLuong}" />--%>
    <%--                <br>--%>
    <%--            </div>--%>
    <%--    </div>--%>
    <%--    <div class="row" style="margin-left: 20px;">--%>
    <%--            <div class="col-md-6" >--%>
    <%--                <label class="form-label">Đơn Giá</label>--%>
    <%--                <br>--%>
    <%--            </div>--%>
    <%--            <div class="col-md-6">--%>
    <%--                <input type="text" class="form-control" name="donGia" value="${hd.donGia}"/>--%>
    <%--                <br>--%>
    <%--            </div>--%>
    <%--    </div>--%>
    <%--    <div class="row" style="margin-left: 20px;">--%>
    <%--            <div class="col-md-6">--%>
    <%--                <label class="form-label">Thành Tiền</label>--%>
    <%--                <br>--%>
    <%--            </div>--%>
    <%--            <div class="col-md-6">--%>
    <%--                <input type="text" class="form-control" value="${hd.soLuong*hd.donGia} VND" />--%>
    <%--                <br>--%>
    <%--            </div>--%>
    <%--    </div>--%>
    <%--    <div class="row" style="margin-left: 20px;">--%>
    <%--            <div class="col-md-6">--%>
    <%--                <label class="form-label">Ngày Tạo</label>--%>
    <%--                <br>--%>
    <%--            </div>--%>
    <%--            <div class="col-md-6">--%>
    <%--                <input type="text" class="form-control" name="ngayTao" value="${hd.ngayTao}" />--%>
    <%--                <br>--%>
    <%--            </div>--%>
    <%--    </div>--%>
    <%--    <div style="margin-left: 40px;" >--%>
    <%--        <button type="submit" class="btn btn-primary btn-md" >--%>
    <%--            <i class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;Payment--%>
    <%--        </button>--%>
    <%--    </div>--%>
    <div class="container mt-6 mb-7">
        <div class="row justify-content-center">
            <div class="col-lg-12 col-xl-7">
                <div class="card">
                    <div class="card-body p-5">
                        <h2>
                            Hey ${hd.tenKH},
                        </h2>
                        <p class="fs-sm">
                            This is the receipt for a payment of <strong>${hd.soLuong*hd.donGia}</strong> (VND) you made to Spacial Themes.
                        </p>

                        <div class="border-top border-gray-200 pt-4 mt-4">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="text-muted mb-2">Payment No.</div>
                                    <strong>#${count}</strong>
                                </div>
                                <div class="col-md-6 text-md-end">
                                    <div class="text-muted mb-2">Payment Date</div>
                                    <strong>${hd.ngayTao}</strong>
                                </div>
                            </div>
                        </div>

                        <div class="border-top border-gray-200 mt-4 py-4">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="text-muted mb-2">Client</div>
                                    <strong>
                                        John McClane
                                    </strong>
                                    <p class="fs-sm">
                                        989 5th Avenue, New York, 55832
                                        <br>
                                        <a href="#!" class="text-purple">john@email.com
                                        </a>
                                    </p>
                                </div>
                                <div class="col-md-6 text-md-end">
                                    <div class="text-muted mb-2">Payment To</div>
                                    <strong>
                                        Themes LLC
                                    </strong>
                                    <p class="fs-sm">
                                        9th Avenue, San Francisco 99383
                                        <br>
                                        <a href="#!" class="text-purple">themes@email.com
                                        </a>
                                    </p>
                                </div>
                            </div>
                        </div>

                        <table class="table border-bottom border-gray-200 mt-3">
                            <thead>
                            <tr>
                                <th scope="col" class="fs-sm text-dark text-uppercase-bold-sm px-0">Description</th>
                                <th scope="col" class="fs-sm text-dark text-uppercase-bold-sm text-end px-0">Color</th>
                                <th scope="col" class="fs-sm text-dark text-uppercase-bold-sm text-end px-0">Amount</th>
                                <th scope="col" class="fs-sm text-dark text-uppercase-bold-sm text-end px-0">Price</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td class="text-end px-0">${hd.tenSP}</td>
                                <td class="text-end px-0">${hd.mauSac}</td>
                                <td class="text-end px-0">${hd.soLuong}</td>
                                <td class="text-end px-0">${hd.donGia} VND</td>
                            </tr>
                            <%--                            <tr>--%>
                            <%--                                <td class="px-0">Website design</td>--%>
                            <%--                                <td class="text-end px-0">$80.00</td>--%>
                            <%--                            </tr>--%>
                            </tbody>
                        </table>

                        <div class="mt-5">
                            <div class="d-flex justify-content-end">
                                <p class="text-muted me-3">Subtotal:</p>
                                <span>${hd.donGia*hd.soLuong} VND</span>
                            </div>
                            <%--                            <div class="d-flex justify-content-end">--%>
                            <%--                                <p class="text-muted me-3">Discount:</p>--%>
                            <%--                                <span>-$40.00</span>--%>
                            <%--                            </div>--%>
                            <%--                            <div class="d-flex justify-content-end mt-3">--%>
                            <%--                                <h5 class="me-3">Total:</h5>--%>
                            <%--                                <h5 class="text-success">$399.99 USD</h5>--%>
                            <%--                            </div>--%>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-dark btn-lg card-footer-btn justify-content-center text-uppercase-bold-sm hover-lift-light">
            <span class="svg-icon text-white me-2">
              <svg xmlns="http://www.w3.org/2000/svg" width="512" height="512" viewBox="0 0 512 512"><title>ionicons-v5-g</title><path d="M336,208V113a80,80,0,0,0-160,0v95" style="fill:none;stroke:#000;stroke-linecap:round;stroke-linejoin:round;stroke-width:32px"></path><rect x="96" y="208" width="320" height="272" rx="48" ry="48" style="fill:none;stroke:#000;stroke-linecap:round;stroke-linejoin:round;stroke-width:32px"></rect></svg>
            </span>
                        Pay Now
                    </button>
                </div>
            </div>
        </div>
    </div>
</form>
<br>
<br>