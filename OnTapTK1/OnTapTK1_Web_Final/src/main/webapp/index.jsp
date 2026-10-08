<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<form action="bus-ticket" method="post">

<div>
    <label>Họ và tên</label>
    <input type="text" name="passengerName">
</div>

    <div>
        <label>Password : </label>
        <input type="password" name="password">
    </div>


    <div>
        <label>Loại ghế :</label>
        <label><input type="radio" name="seatType" value="Ghế ngồi">Ghế ngồi</label>
        <label><input type="radio" name="seatType" value="Giường nằm">Giường nằm</label>
    </div>

    <div>
        <label>Tuyến xe</label>
        <select name="route">
            <option value="Hà nội - Hải Phòng">Hà nội - Hải Phòng</option>
            <option value="TP.HCM - Đà Lạt">TP.HCM - Đà Lạt</option>
            <option value="Đà nẵng - Huế">Đà nẵng - Huế</option>
        </select>
    </div>

    <button type="submit">Thêm</button>
</form>

</body>
</html>