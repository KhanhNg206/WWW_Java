<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<!DOCTYPE html>

<html>

<head>

  <meta charset="UTF-8">

  <title>Quản lý tin tức</title>

  <style>

    body {
      font-family: Arial, sans-serif;
      margin: 30px;
    }

    .menu {
      margin-bottom: 20px;
    }

    .menu a {
      margin-right: 15px;
    }

    table {
      border-collapse: collapse;
      width: 100%;
    }

    th, td {
      border: 1px solid #ccc;
      padding: 8px;
      text-align: left;
    }

    th {
      background: #eee;
    }

    .btn {
      padding: 6px 10px;
      text-decoration: none;
      border: 1px solid #999;
      background: #f5f5f5;
    }

  </style>

</head>

<body>

<h1>QUẢN LÝ TIN TỨC</h1>

<div class="menu">

  <a href="${pageContext.request.contextPath}/tin-tuc">
    Tất cả tin tức
  </a>

  <a href="${pageContext.request.contextPath}/tin-tuc-form">
    Thêm tin tức
  </a>

  <a href="${pageContext.request.contextPath}/quan-ly">
    Quản lý / Xóa
  </a>

</div>

<h3>Xem tin theo danh mục</h3>

<c:forEach var="dm" items="${danhMucs}">

  <a class="btn"
     href="${pageContext.request.contextPath}/tin-tuc?madm=${dm[0]}">

      ${dm[1]}

  </a>

</c:forEach>

<br>
<br>

<table>

  <tr>

    <th>Mã TT</th>
    <th>Tiêu đề</th>
    <th>Nội dung</th>
    <th>Liên kết</th>
    <th>Mã DM</th>

  </tr>

  <c:forEach var="tin"
             items="${tinTucs}">

    <tr>

      <td>
          ${tin.matt}
      </td>

      <td>
          ${tin.tieuDe}
      </td>

      <td>
          ${tin.noiDungTT}
      </td>

      <td>
        <a href="${tin.lienKet}"
           target="_blank">
          Xem
        </a>
      </td>

      <td>
          ${tin.madm}
      </td>

    </tr>

  </c:forEach>

</table>

</body>

</html>