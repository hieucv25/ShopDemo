<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<br>--%>
<%--<br>--%>
<%--<c:if test="${message != null}">--%>
<%--    <div class="alert alert-success" role="alert">--%>
<%--        ${message}--%>
<%--    </div>--%>
<%--</c:if>--%>
<div style="padding-left: 10px; padding-top: 20px;">
    <a class="btn btn-dark" href="/home/index" role="button">Back</a>
</div>
<form action="/home/hd/view/${spct.id}" method="GET">
<div class="container-fluid" style="padding: 20px;">
    <div class="row">
        <div class="col-md-6">
            <img src="https://s4827.pcdn.co/wp-content/uploads/2018/09/Apple-iPhone-Xs-combo-gold-banner.jpg" class="img-fluid" alt="..."
                 style="width: 700px; height: 400px; border-radius: 2%;padding: 20px 20px;">
        </div>
        <div class="col-md-6">
            <label class="form-label"
                   style="padding-right: 50px; padding-top: 20px;color: red; font-weight: bold;font-size: 25px;">
                ${spct.sp.ten}</label>
            <br>
            <label class="form-label" style="padding-right: 50px; padding-top: 20px;">Price : ${spct.giaBan}</label>
            <br>
            <label class="form-label" style="padding-right: 50px; padding-top: 20px;">Quantity : ${spct.slt}</label>
            <br>
            <label class="form-label" style="padding-right: 50px; padding-top: 20px;">Describe : ${spct.moTa}</label>
            <br>
            <label class="form-label" style="padding-right: 50px; padding-top: 20px;">
                <div class="buttons_added">
                    <input class="minus is-form" type="button" value="-">
                    <input aria-label="quantity" class="input-qty" max="${spct.slt}" min="1" name="sl" type="number" value="1">
                    <input class="plus is-form" type="button" value="+">
                </div>
            </label>
            <br>
            <br>
            <button type="submit" class="btn btn-success" id="btn" onclick="clicked()">Buy</button>
        </div>
    </div>
</div>
</form>
<%--<script>--%>
<%--    var input = document.getElementById("btn");--%>
<%--    input.onclick= function () {--%>
<%--        swal("Good job!", "You clicked the button!", "success");--%>
<%--    };--%>
<%--</script>--%>
<%--<script>--%>
<%--    $(document).ready(function (e){--%>
<%--        $("#add-post-form").on("submit",function (event){--%>
<%--            event.preventDefault();--%>
<%--            console.log("you have clicked on submit!")--%>
<%--            let form = new FormData(this);--%>
<%--            $.ajax({--%>
<%--                url: "home/hd/add/",--%>
<%--                method: 'POST',--%>
<%--                data: form,--%>
<%--                success: function (data,textStatus,jqXHR){--%>
<%--                    console.log(data);--%>
<%--                    if(data.trim()=='done'){--%>
<%--                        swal("Good job!", "You clicked the button!", "success");--%>
<%--                    }--%>
<%--                },--%>
<%--                error: function (data,textStatus,jqXHR){--%>
<%--                    console.log(data);--%>
<%--                },--%>
<%--                processData: false,--%>
<%--                contentType: false--%>
<%--            })--%>
<%--        })--%>
<%--    })--%>
<%--</script>--%>