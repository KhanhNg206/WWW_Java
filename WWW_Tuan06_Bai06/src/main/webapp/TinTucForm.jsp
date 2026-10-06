<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<!DOCTYPE html>

<html>

<head>

  <meta charset="UTF-8">

  <title>Thêm tin tức</title>

  <style>

    body {
      font-family: Arial, sans-serif;
      margin: 30px;
    }

    .form-group {
      margin-bottom: 15px;
    }

    label {
      display: block;
      margin-bottom: 5px;
    }

    input,
    textarea,
    select {
      width: 400px;
      padding: 8px;
    }

    textarea {
      height: 100px;
    }

    button {
      padding: 8px 20px;
    }

    .error {
      color: red;
      margin-bottom: 15px;
    }

  </style>

</head>

<body>

<h1>THÊM TIN TỨC</h1>

<c:if test="${error != null}">

  <div class="error">
      ${error}
  </div>

</c:if>

<form method="post"
      action="${pageContext.request.contextPath}/tin-tuc-form"
      onsubmit="return validateForm()">

  <div class="form-group">

    <label>Mã tin tức</label>

    <input type="text"
           id="matt"
           name="matt"
           required
           pattern="[A-Za-z0-9]+"
           title="Mã tin chỉ gồm chữ và số">

  </div>


  <div class="form-group">

    <label>Tiêu đề</label>

    <input type="text"
           id="tieuDe"
           name="tieuDe"
           required>

  </div>


  <div class="form-group">

    <label>Nội dung</label>

    <textarea id="noiDungTT"
              name="noiDungTT"
              required
              maxlength="255"></textarea>

  </div>


  <div class="form-group">

    <label>Liên kết</label>

    <input type="text"
           id="lienKet"
           name="lienKet"
           required
           pattern="http://.*"
           title="Liên kết phải bắt đầu bằng http://">

  </div>


  <div class="form-group">

    <label>Danh mục</label>

    <select name="madm"
            required>

      <option value="">
        -- Chọn danh mục --
      </option>

      <c:forEach var="dm"
                 items="${danhMucs}">

        <option value="${dm[0]}">
            ${dm[1]}
        </option>

      </c:forEach>

    </select>

  </div>


  <button type="submit">
    Thêm
  </button>

</form>

<br>

<a href="${pageContext.request.contextPath}/tin-tuc">
  Quay lại danh sách
</a>

<script>

  function validateForm() {

    const noiDung =
            document.getElementById("noiDungTT").value;

    const lienKet =
            document.getElementById("lienKet").value;

    // Kiểm tra nội dung không quá 255 ký tự
    if (noiDung.length > 255) {

      alert(
              "Nội dung không được quá 255 ký tự!"
      );

      return false;
    }

    // Kiểm tra bắt đầu bằng http://
    const regex =
            /^http:\/\/.+/;

    if (!regex.test(lienKet)) {

      alert(
              "Liên kết phải bắt đầu bằng http://"
      );

      return false;
    }

    return true;
  }

</script>

</body>

</html>