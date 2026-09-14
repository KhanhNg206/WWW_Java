<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/14/2026
  Time: 7:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="borrow" method="post">
    <div>
        <label>mã sinh viên : </label>
        <input name="studentId" type="text">
    </div>
    <div>
        <label>Họ và tên : </label>
        <input name="studentName" type="text">
    </div>
    <div>
        <label>Ngày mượn sách : </label>
        <input name="borrowDate" type="date">
    </div>
    <div>
        <label>Ngày trả sách : </label>
        <input name="returnDate" type="date">
    </div>
    <div>
        <label>Thể loại sách : </label>
        <select name="bookTypes">
            <option value="Tình cảm">Tình cảm</option>
            <option value="Hài">Hài</option>
            <option value="Trinh thám">Trinh thám</option>
        </select>
    </div>
    <button type="submit">Gửi</button>
</form>

</body>
</html>
