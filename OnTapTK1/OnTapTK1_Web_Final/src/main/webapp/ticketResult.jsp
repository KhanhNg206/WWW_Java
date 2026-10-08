<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/15/2026
  Time: 8:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="passenger" items="${passengers.getAllPassenger()}">

    <p>--------------------</p>
    <div>
        <p>Họ tên : </p>${passenger.passengerName}
    </div>

    <div>
        <p>Password : </p>${passenger.password}
    </div>

    <div>
        <p>Laoị ghế : </p>${passenger.seatType}
    </div>

    <div>
        <p>Tuyến xe : </p>${passenger.route}
    </div>
    <p>--------------------</p>
</c:forEach>
</body>
</html>
