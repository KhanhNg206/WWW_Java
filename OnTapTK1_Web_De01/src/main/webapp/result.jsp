<%@ page import="org.example.ontaptk1_web.session.RegistrationSession" %>
<%@ page import="org.example.ontaptk1_web.model.StudentRegistration" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/11/2026
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
  StudentRegistration registration = (StudentRegistration) session.getAttribute("registration");
%>

<h2>THÔNG TIN ĐĂNG KÝ</h2>

<p> Họ tên : </p> <%= registration.getFullName() %>
<p> Email : </p> <%= registration.getEmail() %>
<p> Khóa học : </p> <%= registration.getCourse() %>
<p> Kỹ năng : </p>
<div class="skills">
  <% if (registration.getSkills() != null) {
       for (String skill : registration.getSkills()) { %>
  <div> ✓ <%= skill %> </div>
  <%   }
     } %>
</div>

<p> Hình thức : </p> <%= registration.getMode() %>

<a href="register.jsp">quay lại đăng ký</a>

</body>
</html>
