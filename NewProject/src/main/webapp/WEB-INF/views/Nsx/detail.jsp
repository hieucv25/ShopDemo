<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<br>
<br>
<a href="/nha-san-xuat/index" style="padding-left: 20px; color: green; font-size: 35px;"><i class="fa-solid fa-backward"></i></a>
<br>
<br>
<form method="POST" class="col-md-10" action="/nha-san-xuat/update/${nsx.id}">
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Mã</label>
            <input type="text" class="form-control" placeholder="Mã" name="ma" value="${nsx.ma}" >
            <label style="padding-top: 5px;color: red; font-weight: bold;">${message}</label>
        </div>
        <div class="col-md-6">
            <label>Tên</label>
            <input type="text" class="form-control" placeholder="Tên" name="ten" value="${nsx.ten}">
        </div>
    </div>
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
        </div>
        <div class="col-md-6">
            <button type="submit" class="btn btn-success">
                Update
            </button>
        </div>
    </div>
</form>