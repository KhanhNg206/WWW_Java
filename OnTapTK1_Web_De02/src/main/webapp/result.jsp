<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/12/2026
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Thông Tin Phiếu Điểm Sinh Viên</h2>

<p>Mã Sinh Viên : </p> ${gradeReport.maSv}
<p>Họ và Tên : </p> ${gradeReport.hoVaTen}
<p>Học Kỳ : </p> ${gradeReport.hocKy}

<p>Các môn học đã chọn</p>
<ul>
    <c:forEach var="mon" items="${gradeReport.monHoc}">
        <li>
            ${mon}
        </li>
    </c:forEach>
</ul>

<a href="gradeform.jsp">quay lại trang chủ</a>

</body>
</html>
