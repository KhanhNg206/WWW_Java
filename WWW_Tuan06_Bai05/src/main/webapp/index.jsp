<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee Management</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
        }

        a {
            display: inline-block;
            padding: 12px 20px;
            margin-right: 10px;
            background: #0d6efd;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }

        a:hover {
            background: #0b5ed7;
        }
    </style>
</head>

<body>

<h1>Employee Management</h1>

<a href="${pageContext.request.contextPath}/departments">
    Departments
</a>

<a href="${pageContext.request.contextPath}/employees">
    Employees
</a>

</body>
</html>