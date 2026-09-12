<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/12/2026
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Đăng Ký Phiếu Điểm</h2>

<form action="grade" method="post">
    <div>
        <label>Mã Sinh Viên:</label>
        <input type="text" name="maSinhVien">
    </div>

    <div>
        <label>Họ và Tên:</label>
        <input type="text" name="hoVaTen">
    </div>

    <div>
        <label>Học kỳ:</label>
        <select name="hocKy">
            <option value="Học kỳ 1">Học kỳ 1</option>
            <option value="Học kỳ 2">Học kỳ 2</option>
        </select>
    </div>

    <div>
        <label>Chọn môn học :</label>
        <label><input type="checkbox" name="monHoc" value="Lập trình Java"> Lập trình Java</label>
        <label><input type="checkbox" name="monHoc" value="Cơ sở dữ liệu"> Cơ sở dữ liệu</label>
        <label><input type="checkbox" name="monHoc" value="Cấu trúc dữ liệu"> Cấu trúc dữ liệu</label>
    </div>

    <button type="submit">Gửi phiếu điểm</button>
</form>

</body>
</html>
