<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<br>
<br>
<a href="/cua-hang/index" style="padding-left: 20px; color: green; font-size: 35px;"><i class="fa-solid fa-backward"></i></a>
<br>
<br>
<form method="POST" class="col-md-10" action="/cua-hang/update/${ch.id}">
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
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Địa Chỉ</label>
            <input class="form-control" rows="4" name="diaChi" value="${ch.diaChi}">
        </div>
        <div class="col-md-6" style="padding-top: 30px;">
            <button type="submit" class="btn btn-success">
                Update
            </button>
        </div>
    </div>
</form>