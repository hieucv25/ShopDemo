<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="https://s4827.pcdn.co/wp-content/uploads/2018/09/Apple-iPhone-Xs-combo-gold-banner.jpg" class="d-block w-100" alt="." height="700px" style="object-fit: cover;"
                 style="padding-top: 0px;">
        </div>
        <div class="carousel-item">
            <img src="https://blog.ugreen.com/wp-content/uploads/2020/10/iphone-12-banner-2.png" class="d-block w-100" alt="." height="700px" style="object-fit: cover;"
                 style="padding-top: 0px;">
        </div>
        <div class="carousel-item">
            <img src="https://i.ytimg.com/vi/wM_3dCqj21M/maxresdefault.jpg" class="d-block w-100" alt="." height="700px" style="object-fit: cover;"
                 style="padding-top: 0px;">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>
<div class="container">
    <div class="col-md-12">
        <div class="row">
            <div class="col-md-3">
                <p style="color: black; font-weight: bold; padding-left: 90px;">Filter :</p>
            </div>
            <div class="col-md-2 " style="padding-left: 0px;">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"
                   style="padding-top: 50px;">
                    Buy The Most
                </a>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="#">Buy The Most</a></li>
                    <li><a class="dropdown-item" href="#">Buy The Least</a></li>
                </ul>
            </div>
            <div class="col-md-2">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"
                   style="padding-top: 50px;">
                    Newest
                </a>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="#">Newest</a></li>
                    <li><a class="dropdown-item" href="#">Latest</a></li>
                </ul>
            </div>
            <div class="col-md-2" style="padding-left: 50px;">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"
                   style="padding-top: 50px;">
                    Color
                </a>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="#">Black</a></li>
                    <li><a class="dropdown-item" href="#">White</a></li>
                    <li><a class="dropdown-item" href="#">Pink</a></li>
                    <li><a class="dropdown-item" href="#">Red</a></li>
                    <li><a class="dropdown-item" href="#">Purple</a></li>
                    <li><a class="dropdown-item" href="#">Yellow</a></li>
                    <li><a class="dropdown-item" href="#">Green</a></li>
                    <li><a class="dropdown-item" href="#">Other</a></li>
                </ul>
            </div>

            <div class="col-md-2" style="padding-left: 50px;">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"
                   style="padding-top: 50px;">
                    Price
                </a>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="#">Less Than 5.000.000VND</a></li>
                    <li><a class="dropdown-item" href="#">5.000.000 To 10.000.000VND</a></li>
                    <li><a class="dropdown-item" href="#">10.000.000Đ To 20.000.000VND</a></li>
                    <li><a class="dropdown-item" href="#">20.000.000 To 50.000.000VND</a></li>
                </ul>
            </div>

        </div>
    </div>
</div>

<div class="container text-center" style="padding-bottom: 50px;">

    <div class="row">
        <c:forEach items="${list}" var="spct">
        <div class="col-md-3"><img class="img-fluid" src="https://s4827.pcdn.co/wp-content/uploads/2018/09/Apple-iPhone-Xs-combo-gold-banner.jpg" alt="" style="border-radius: 2%;">
            <div class="text-center">
                <h3 style="font-size: 15px;">Name: ${spct.sp.ten}</h3>
                <p>Price : ${spct.giaBan} VND</p>
                <button type="button" class="btn btn-outline-dark">
                    <a style="text-decoration: none;" href="/home/detail/${spct.id}">Detail</a>
                </button>
                <a class="btn btn-outline-dark" href="/home/cart/add/${spct.id}">
<%--                    <i class="fa-solid fa-cart-shopping" style="padding-right: 1px;"></i>--%>
                    Add to cart</a>
            </div>
        </div>
        </c:forEach>
    </div>

</div>

<!-- <div class="container-fluid">
<div class="col-md-12" style=" display: flex;
justify-content: center;
align-items: center;">
<h1>Sản Phẩm Bán Chạy</h1>
</div>
<div class="hr">
<hr style="width: 100px; border: none; height: 2px; background-color: #198754;">
</div>
</div>
<div class="image-slider" style="padding-right: 100px;">
<div class="image-item">
<img src="/img/a1.jpg" alt="">
<p class="image-title">Content</p>
</div>
<div class="image-item">
<img src="" alt="">
<p class="image-title">Content</p>
</div>
<div class="image-item">
<img src="/img/a3.jfif" alt="">
<p class="image-title">Content</p>
</div>
<div class="image-item">
<img src="/img/a4.jpg" alt="">
<p class="image-title">Content</p>
</div>
<div class="image-item">
<img src="/img/a5.png" alt="">
<p class="image-title">Content</p>
</div>

</div>


<div class="container-fluid">
<div class="col-md-12" style=" display: flex;
justify-content: center;
align-items: center;">
<h1>Sản Phẩm Mới</h1>
</div>
<div class="hr">
<hr style="width: 100px; border: none; height: 2px; background-color: #198754;">
</div>
</div>
<div class="image-slider" style="padding-right: 100px;">
<div class="image-item">
<img src="/img/a1.jpg" alt="">
<p class="image-title">Content</p>
</div>
<div class="image-item">
<img src="/img/a2.jfif" alt="">
<p class="image-title">Content</p>
</div>
<div class="image-item">
<img src="/img/a3.jfif" alt="">
<p class="image-title">Content</p>
</div>
<div class="image-item">
<img src="/img/a4.jpg" alt="">
<p class="image-title">Content</p>
</div>
<div class="image-item">
<img src="/img/a5.png" alt="">
<p class="image-title">Content</p>
</div>
</div> -->