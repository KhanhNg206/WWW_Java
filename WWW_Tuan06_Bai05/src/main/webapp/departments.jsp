<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<!DOCTYPE html>

<html>

<head>

    <div class="header">
        <img src="${pageContext.request.contextPath}/image/header.png"
             alt="Header">
    </div>

  <title>Departments List</title>

  <style>

    body {
      font-family: Arial, sans-serif;
      margin: 30px;
    }

    header {
        width: 100%;
        margin: 0;
        padding: 0;
    }

    header img {
        width: 100%;
        height: 220px;
        object-fit: cover;
        display: block;
    }

    h1 {
      margin-bottom: 20px;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
    }

    th, td {
      border: 1px solid #ddd;
      padding: 10px;
    }

    th {
      background: #f2f2f2;
    }

    a {
      text-decoration: none;
      margin-right: 5px;
    }

    .btn {
      padding: 8px 12px;
      border-radius: 4px;
      text-decoration: none;
    }

    .btn-add {
      background: #198754;
      color: white;
    }

    .btn-edit {
      color: #0d6efd;
    }

    .btn-delete {
      color: red;
    }

    .btn-employee {
      color: #6f42c1;
    }

    input {
      padding: 8px;
      width: 250px;
    }

    button {
      padding: 8px 15px;
    }

  </style>

</head>

<body>

<h1>Departments List</h1>

<a class="btn btn-add"
   href="${pageContext.request.contextPath}/department-form.jsp">

  Add Department

</a>

<form method="get"
      action="${pageContext.request.contextPath}/departments"
      style="margin-top:20px;">

  <label>Tìm phòng ban:</label>

  <input
          type="text"
          name="keyword"
          value="${keyword}"
          placeholder="Nhập tên phòng ban">

  <button type="submit">
    Search
  </button>

</form>


<table>

  <thead>

  <tr>

    <th>DEPT ID</th>

    <th>Name Department</th>

    <th>Action</th>

  </tr>

  </thead>

  <tbody>

  <c:forEach var="department"
             items="${departments}">

    <tr>

      <td>
          ${department.id}
      </td>

      <td>
          ${department.name}
      </td>

      <td>

        <a
                class="btn-edit"
                href="${pageContext.request.contextPath}/departments?action=edit&id=${department.id}">

          Edit

        </a>

        |

        <a
                class="btn-delete"
                href="${pageContext.request.contextPath}/departments?action=delete&id=${department.id}"
                onclick="return confirm('Bạn có chắc muốn xóa phòng ban này?')">

          Delete

        </a>

        |

        <a
                class="btn-employee"
                href="${pageContext.request.contextPath}/employees?departmentId=${department.id}">

          Employees

        </a>

      </td>

    </tr>

  </c:forEach>

  </tbody>

</table>

<br>

<a href="${pageContext.request.contextPath}/">
  Home
</a>

</body>

</html>