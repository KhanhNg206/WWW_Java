
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,
initial-scale=1">
    <title>Dang nhap</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/style.css">
</head>
<body>
<main class="card login-card">
    <h1>Dang nhap</h1>
    <p class="hint">account demo: <strong>student</strong> /
        <strong>123456</strong></p>
    <p class="error">${error}</p>
    <form method="post"
          action="${pageContext.request.contextPath}/login">
        <label for="username">Username</label>
        <input id="username" name="username" value="${username}"
               required autofocus>
        <label for="password">Password</label>
        <input id="password" name="password" type="password"
               required>
        <button type="submit">Đang nhap</button>
    </form>
</main>
</body>
</html>
