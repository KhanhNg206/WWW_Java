<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<!DOCTYPE html>

<html>

<head>

  <title>Employee Form</title>

  <style>

    body {
      font-family: Arial, sans-serif;
      margin: 40px;
    }

    .form-group {
      margin-bottom: 15px;
    }

    label {
      display: block;
      margin-bottom: 5px;
    }

    input, select {
      padding: 8px;
      width: 300px;
    }

    button {
      padding: 9px 20px;
    }

  </style>

</head>

<body>

<c:choose>



  <c:when test="${employee != null}">

    <h1>Edit Employee</h1>

    <form method="post"
          action="${pageContext.request.contextPath}/employees">

      <input
              type="hidden"
              name="action"
              value="update">

      <input
              type="hidden"
              name="id"
              value="${employee.id}">

      <div class="form-group">

        <label>
          Employee Name
        </label>

        <input
                type="text"
                name="name"
                value="${employee.name}"
                required>

      </div>


      <div class="form-group">

        <label>
          Department
        </label>

        <select name="departmentId" required>

          <c:forEach var="department"
                     items="${departments}">

            <c:choose>

              <c:when test="${employee.departmentId == department.id}">

                <option value="${department.id}" selected>
                    ${department.name}
                </option>

              </c:when>

              <c:otherwise>

                <option value="${department.id}">
                    ${department.name}
                </option>

              </c:otherwise>

            </c:choose>

          </c:forEach>

        </select>

      </div>


      <div class="form-group">

        <label>
          Salary
        </label>

        <input
                type="number"
                name="salary"
                step="0.01"
                value="${employee.salary}"
                required>

      </div>


      <button type="submit">
        Update
      </button>

    </form>

  </c:when>



  <c:otherwise>

    <h1>Add Employee</h1>

    <form method="post"
          action="${pageContext.request.contextPath}/employees">

      <input
              type="hidden"
              name="action"
              value="add">


      <div class="form-group">

        <label>
          Employee Name
        </label>

        <input
                type="text"
                name="name"
                required>

      </div>


      <div class="form-group">

        <label>
          Department
        </label>

        <select name="departmentId"
                required>

          <option value="">
            -- Chọn phòng ban --
          </option>

          <c:forEach var="department"
                     items="${departments}">

            <option value="${department.id}">

                ${department.name}

            </option>

          </c:forEach>

        </select>

      </div>


      <div class="form-group">

        <label>
          Salary
        </label>

        <input
                type="number"
                name="salary"
                step="0.01"
                required>

      </div>


      <button type="submit">
        Add
      </button>

    </form>

  </c:otherwise>

</c:choose>

<br>

<a href="${pageContext.request.contextPath}/employees">
  Back to Employees
</a>

</body>

</html>