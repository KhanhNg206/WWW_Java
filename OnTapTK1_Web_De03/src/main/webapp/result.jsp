<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/14/2026
  Time: 7:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Thông tin đăng kí mượn sách</h2>
<div>
      <p>Mã sinh viên : </p> ${borrowReport.studentId}
</div>

<div>
  <p>Tên sinh viên : </p> ${borrowReport.studentName}
</div>

<div>
  <p>Ngaỳ mượn sách : </p> ${borrowReport.borrowDate}
</div>

<div>
  <p>Ngày trả sách: </p> ${borrowReport.returnDate}
</div>

<div>
  <p>Thể loại sách : </p>
  <ul>
    <c:forEach var="theLoai" items="${borrowReport.bookTypes}">
    <li>
      ${theLoai}
    </li>
    </c:forEach>
  </ul>
</div>

<div>
  <p>Số ngaày mượn : </p> ${borrowReport.borrowDays}
</div>


</body>
</html>

