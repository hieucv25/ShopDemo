<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <title>Document</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@600&display==swap');

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            /*font-family: 'Poppins', Arial;*/
        }

        body {
            background: #d5d0d6;
        }

        .box {
            position: relative;
            width: 250px;
            height: 250px;
        }

        .dropdown {
            position: relative;
            width: 100%;
            height: 60px;
            background: #7f0099;
            color: #fff;
            font-size: 22px;
            display: flex;
            justify-content: center;
            align-items: center;
            border-radius: 5px;
            cursor: pointer;
            box-shadow: 0 5px 10px rgba(0, 0, 0, .2);
        }

        .dropdown .left_icon,
        .dropdown .right_icon {
            position: relative;
            top: 2px;
            display: inline-block;
            width: 15px;
            height: 5px;
            background: #fff;
            border-radius: 40px;
            transition: .5s;
        }

        .dropdown .left_icon {
            left: 7px;
            transform: rotate(45deg);
        }

        .dropdown.active .left_icon {
            transform: rotate(135deg);
        }

        .dropdown .right_icon {
            transform: rotate(-45deg);
        }

        .dropdown.active .right_icon {
            transform: rotate(-135deg);
        }

        .dropdown .items {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 800px;
            margin-top: 63px;
            overflow: hidden;
            visibility: hidden;
            transition: .5s;
        }

        .dropdown.active .items {
            visibility: visible;
        }

        .dropdown .items a {
            position: relative;
            left: 100%;
            display: flex;
            font-size: 20px;
            background: #fff;
            color: #7f0099;
            text-decoration: none;
            border-radius: 5px;
            padding: 10px 15px;
            margin-top: 2.5px;
            z-index: 1;
            overflow: hidden;
            transition: .5s;
            transition-delay: calc(60ms * var(--i));
        }

        .dropdown.active .items a {
            left: 0;
        }

        .dropdown .items a:hover {
            color: #fff;
        }

        .dropdown .items a span {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: #bb00e0;
            z-index: -1;
            border-radius: inherit;
            transform: rotate(160deg);
            transform-origin: right;
            transition: .5s;
        }

        .dropdown .items a:hover span {
            transform: rotate(0deg);
        }
        .col-md-6{
            padding: 10px 10px;
        }
        .dropdown{
            margin-top: 50px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="/home/index">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">###</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">###</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">###</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled">###</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">LogOut</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="row">
    <div class="box col-md-2">
        <div class="dropdown">About
            <span class="left_icon"></span>
            <span class="right_icon"></span>
            <div class="items">
                <a href="/nhan-vien/index" style="--i:1;"><span></span>Nhân Viên</a>
                <a href="/san-pham/index" style="--i:2;"><span></span>Sản Phẩm</a>
                <a href="/nha-san-xuat/index" style="--i:3;"><span></span>NSX</a>
                <a href="/dong-sp/index" style="--i:4;"><span></span>Dòng SP</a>
                <a href="/mau-sac/index" style="--i:5;"><span></span>Màu Sắc</a>
                <a href="/chuc-vu/index" style="--i:5;"><span></span>Chức Vụ</a>
                <a href="/spct/index" style="--i:2;"><span></span>Chi Tiết Sản Phẩm</a>
                <a href="/khach-hang/index" style="--i:2;"><span></span>Khách Hàng</a>
                <a href="/cua-hang/index" style="--i:2;"><span></span>Cửa Hàng</a>
                <a href="/hoa-don/index" style="--i:2;"><span></span>Hoá Đơn</a>
                <a href="/hdct/index" style="--i:2;"><span></span>Hoá Đơn Chi Tiết</a>
            </div>
        </div>
    </div>
    <div class="col-md-10" style="font-size: 15px">
       <jsp:include page="${view}"/>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
    const dropdown = document.querySelector('.dropdown');

    dropdown.addEventListener('click', () => {
        dropdown.classList.toggle('active');
    });
</script>
</body>
</html>