<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/11/2026
  Time: 10:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>ĐĂNG KÝ KHÓA HỌC</h2>
<form action="dangKy" method="post">
    <div>
        <label>Họ tên :</label>
        <input type="text" name="fullName">
    </div>
    <div>
        <label>Email :</label>
        <input type="text" name="email">
    </div>
    <div>
        <label>Khóa học :</label>
        <select name="course">
            <option value="Java">Java</option>
            <option value="C">C</option>
            <option value="React">React</option>
        </select>
    </div>
    <div>
        <label>Kỹ năng</label>
        <label> <input type="checkbox" name="skills" value="Tiếng anh"> Tiếng anh</label>
        <label> <input type="checkbox" name="skills" value="Tiếng việt"> Tiếng việt</label>
        <label> <input type="checkbox" name="skills" value="Tiếng trung"> Tiếng trung</label>
    </div>
    <div>
        <select name="mode">
            <option value="Online">Online</option>
            <option value="Offline">Offline</option>
        </select>
    </div>
    <button type="submit">Đăng kí</button>

</form>

</body>
</html>
