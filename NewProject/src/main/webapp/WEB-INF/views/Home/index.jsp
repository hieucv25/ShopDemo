<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <title>Home</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@600&display==swap');
        body{
            font-family: 'Poppins',Arial;
        }
        .col-md-3 {
            padding-top: 50px;
        }

        .image-item img {
            width: 100%;
            height: 140px;
        }
        .image-title{
            display: flex;
            justify-content: center;
            align-items: center;
        }
        /*.slick-initialized .slick-slide {*/
        /*    padding-left: 100px;*/
        /*}*/

        /*.image-slider {*/
        /*    padding: 50px 10px;*/
        /*}*/

        /*.slick-prev {*/
        /*    right: 0;*/
        /*}*/

        /*.slick-next {*/
        /*    left: 0;*/
        /*}*/

        /*.slick-arrow {*/
        /*    position: absolute;*/
        /*    top: 50%;*/
        /*    transform: translateY(-50%);*/
        /*    border: none;*/
        /*    width: 50px;*/
        /*    height: 50px;*/
        /*    display: flex;*/
        /*    justify-content: center;*/
        /*    align-items: center;*/
        /*    font-size: 20px;*/
        /*    line-height: 1;*/
        /*    z-index: 5;*/
        /*    transition: all 0.2s linear;*/
        /*}*/

        /*.slick-dots {*/
        /*    position: absolute;*/
        /*    bottom: 0;*/
        /*    left: 45%;*/
        /*    transform: translateX(-50%,0);*/
        /*    display: flex !important;*/
        /*    align-items: center;*/
        /*    justify-content: center;*/
        /*    gap: 0 20px;*/
        /*    list-style: none;*/
        /*}*/

        /*.slick-dots button {*/
        /*    width: 15px;*/
        /*    height: 15px;*/
        /*    font-size: 0;*/
        /*    border-radius: 100rem;*/
        /*    background-color: #eee;*/
        /*    border: none;*/
        /*    outline: none;*/
        /*    transition: all 0.2s linear;*/
        /*}*/

        /*.slick-dots .slick-active button {*/
        /*    background-color: #2cccff;*/
        /*}*/
        .hr{
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .col-md-3:hover img{
            transform: scale(1.1);
        }
        .col-md-3 img{
            transition: all 0.3s ease-in-out;
        }
        .text-center{
            padding-top: 20px;
        }
        a{
            color: black;
        }
        .text-center a i{
            position: absolute;
            top: 980px;
            left: 400px;
            display: none;
        }
        .text-center button a:hover{
            color: white;
        }
        .text-center:hover a i{
            display: block;
        }
        .text-center a{
            font-size: 20px;
        }

        .buttons_added {
            opacity:1;
            display:inline-block;
            display:-ms-inline-flexbox;
            display:inline-flex;
            white-space:nowrap;
            vertical-align:top;
        }
        .is-form {
            overflow:hidden;
            position:relative;
            background-color:#f9f9f9;
            height:2.2rem;
            width:1.9rem;
            padding:0;
            text-shadow:1px 1px 1px #fff;
            border:1px solid #ddd;
        }
        .is-form:focus,.input-text:focus {
            outline:none;
        }
        .is-form.minus {
            border-radius:4px 0 0 4px;
        }
        .is-form.plus {
            border-radius:0 4px 4px 0;
        }
        .input-qty {
            background-color:#fff;
            height:2.2rem;
            text-align:center;
            font-size:1rem;
            display:inline-block;
            vertical-align:top;
            margin:0;
            border-top:1px solid #ddd;
            border-bottom:1px solid #ddd;
            border-left:0;
            border-right:0;
            padding:0;
        }
        .input-qty::-webkit-outer-spin-button,.input-qty::-webkit-inner-spin-button {
            -webkit-appearance:none;
            margin:0;
        }
        .card-footer-btn {
            display: flex;
            align-items: center;
            border-top-left-radius: 0!important;
            border-top-right-radius: 0!important;
        }
        .text-uppercase-bold-sm {
            text-transform: uppercase!important;
            font-weight: 500!important;
            letter-spacing: 2px!important;
            font-size: .85rem!important;
        }
        .hover-lift-light {
            transition: box-shadow .25s ease,transform .25s ease,color .25s ease,background-color .15s ease-in;
        }
        .justify-content-center {
            justify-content: center!important;
        }
        .btn-group-lg>.btn, .btn-lg {
            padding: 0.8rem 1.85rem;
            font-size: 1.1rem;
            border-radius: 0.3rem;
        }
        .btn-dark {
            color: #fff;
            background-color: #1e2e50;
            border-color: #1e2e50;
        }

        .card {
            position: relative;
            display: flex;
            flex-direction: column;
            min-width: 0;
            word-wrap: break-word;
            background-color: #fff;
            background-clip: border-box;
            border: 1px solid rgba(30,46,80,.09);
            border-radius: 0.25rem;
            box-shadow: 0 20px 27px 0 rgb(0 0 0 / 5%);
        }

        .p-5 {
            padding: 3rem!important;
        }
        .card-body {
            flex: 1 1 auto;
            padding: 1.5rem 1.5rem;
        }

        tbody, td, tfoot, th, thead, tr {
            border-color: inherit;
            border-style: solid;
            border-width: 0;
        }

        .table td, .table th {
            border-bottom: 0;
            border-top: 1px solid #edf2f9;
        }
        .table>:not(caption)>*>* {
            padding: 1rem 1rem;
            background-color: var(--bs-table-bg);
            border-bottom-width: 1px;
            box-shadow: inset 0 0 0 9999px var(--bs-table-accent-bg);
        }
        .px-0 {
            padding-right: 0!important;
            padding-left: 0!important;
        }
        .table thead th, tbody td, tbody th {
            vertical-align: middle;
        }
        tbody, td, tfoot, th, thead, tr {
            border-color: inherit;
            border-style: solid;
            border-width: 0;
        }

        .mt-5 {
            margin-top: 3rem!important;
        }

        .icon-circle[class*=text-] [fill]:not([fill=none]), .icon-circle[class*=text-] svg:not([fill=none]), .svg-icon[class*=text-] [fill]:not([fill=none]), .svg-icon[class*=text-] svg:not([fill=none]) {
            fill: currentColor!important;
        }
        .svg-icon>svg {
            width: 1.45rem;
            height: 1.45rem;
        }
    </style>
</head>
<body>
<nav style="width: 100%; height: 30px;">
    <div class="row">
        <div class="col-md-6">
            <p style="padding-left: 20px;font-family: cursive;"><span style="font-family: cursive;">Hệ Thống Store |
                        Mua
                        hàng
                        : </span><span style="color: red; padding-left: 10px; font-weight: 700; font-family: cursive;">
                        0128465139</span></p>
        </div>
        <div class="col-md-6">
            <div class="icon" style="padding-left: 500px;">
                <a href="#" style="color: black; text-decoration: none;">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="18" fill="currentColor"
                         class="bi bi-person-fill" viewBox="0 0 16 16" style="padding-bottom: 2px;">
                        <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3Zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6Z" />
                    </svg>
                </a>
                <span style="padding-left: 0px; font-size: 14px; font-family: cursive;">Tài Khoản | </span>
                <a href="/home/cart/index" style="color: black; text-decoration: none;">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                         class="bi bi-bag-check-fill" viewBox="0 0 16 16" style="padding-bottom: 2px;">
                        <path fill-rule="evenodd"
                              d="M10.5 3.5a2.5 2.5 0 0 0-5 0V4h5v-.5zm1 0V4H15v10a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V4h3.5v-.5a3.5 3.5 0 1 1 7 0zm-.646 5.354a.5.5 0 0 0-.708-.708L7.5 10.793 6.354 9.646a.5.5 0 1 0-.708.708l1.5 1.5a.5.5 0 0 0 .708 0l3-3z" />
                    </svg>
                </a>
                <span style="padding-left: 0px; font-size: 14px; font-family: cursive;">Giỏ Hàng</span>
<%--                <span style="color: red;">(</span> <span style="color: red;">0</span> <span--%>
<%--                    style="color: red;">)</span>--%>
            </div>
        </div>
    </div>
</nav>
<nav class="navbar navbar-expand-lg bg-body-tertiary" style="padding-top: 0; padding-bottom: 0;">
    <div class="container-fluid" style="background-color: gray; height: 70px;">
        <a class="navbar-brand" href="/home/index" style="font-size: 27px; font-family: cursive; color: white;">Shop Genm</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="/home/history"
                       style="font-weight: bold;font-family: cursive; color: white;">Purchase History</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href=""
                       style="font-weight: bold;font-family: cursive; color: white;">Intro</a>
                </li>
                <!-- <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                        aria-expanded="false" style="font-weight: bold;font-family: cursive; color: white;">
                        Dowload Picture
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#"
                                style="font-weight: bold;font-family: cursive; color: black;">Action</a></li>
                        <li><a class="dropdown-item" href="#"
                                style="font-weight: bold;font-family: cursive; color: black;">Suit</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="#"
                                style="font-weight: bold;font-family: cursive; color: black;">Artist</a></li>
                    </ul>
                </li> -->
                <!-- <li class="nav-item">
            <a class="nav-link disabled" style="font-weight: bold;">Disabled</a>
          </li> -->
            </ul>
            <form class="d-flex" role="search" style="width: 50%; margin-top: 20px;">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"
                       style="font-family: cursive;">
                <button class="btn btn-outline-light" style="color: black; font-family: cursive;"
                        type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<jsp:include page="${view}"/>
<!-- Footer -->
<footer class="bg-secondary text-white">
    <!-- Grid container -->
    <div class="container p-4">
        <!--Grid row-->
        <div class="row">
            <!--Grid column-->
            <div class="col-lg-6 col-md-12 mb-4 mb-md-0">
                <h5 class="text-uppercase">Presents By Ark</h5>

                <p>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Sapiente veniam ullam illum mollitia incidunt quam perferendis odit praesentium rerum magni, quisquam doloremque vero eos itaque non exercitationem deleniti voluptate. Minima?
                </p>
            </div>
            <!--Grid column-->

            <!--Grid column-->
            <div class="col-lg-3 col-md-6 mb-4 mb-md-0" style="padding-left: 140px;">
                <h5 class="text-uppercase">Product Series</h5>

                <ul class="list-unstyled mb-0">
                    <li>
                        <a href="#!" class="text-white">Link 1</a>
                    </li>
                    <li>
                        <a href="#!" class="text-white">Link 2</a>
                    </li>
                    <li>
                        <a href="#!" class="text-white">Link 3</a>
                    </li>
                    <li>
                        <a href="#!" class="text-white">Link 4</a>
                    </li>
                </ul>
            </div>
            <!--Grid column-->

            <!--Grid column-->
            <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
                <h5 class="text-uppercase mb-0">Links</h5>

                <ul class="list-unstyled">
                    <li>
                        <a href="#!" class="text-white">Link 1</a>
                    </li>
                    <li>
                        <a href="#!" class="text-white">Link 2</a>
                    </li>
                    <li>
                        <a href="#!" class="text-white">Link 3</a>
                    </li>
                    <li>
                        <a href="#!" class="text-white">Link 4</a>
                    </li>
                </ul>
            </div>
            <!--Grid column-->
        </div>
        <!--Grid row-->
    </div>
    <!-- Grid container -->

    <!-- Copyright -->
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
        © 2022 Copyright:
        <a class="text-white" href="#">abc.com</a>
    </div>
    <!-- Copyright -->
</footer>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
<script
        src="https://code.jquery.com/jquery-3.7.0.js"
        integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"
        integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
    $('input.input-qty').each(function() {
        var $this = $(this),
            qty = $this.parent().find('.is-form'),
            min = Number($this.attr('min')),
            max = Number($this.attr('max'))
        if (min == 0) {
            var d = 0
        } else d = min
        $(qty).on('click', function() {
            if ($(this).hasClass('minus')) {
                if (d > min) d += -1
            } else if ($(this).hasClass('plus')) {
                var x = Number($this.val()) + 1
                if (x <= max) d += 1
            }
            $this.attr('value', d).val(d)
        })
    })
</script>
<%--<script>--%>
<%--    var input = document.getElementById("btn");--%>
<%--    input.onclick= function () {--%>
<%--        swal("Good job!", "You clicked the button!", "success");--%>
<%--    };--%>
<%--</script>--%>
</body>
</html>