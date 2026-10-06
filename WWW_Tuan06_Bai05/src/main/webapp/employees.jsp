<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<!DOCTYPE html>

<html>

<head>

    <title>Employees List</title>

    <style>

        body {
            font-family: Arial, sans-serif;
            margin: 30px;
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

        input, select {
            padding: 8px;
            margin-right: 5px;
        }

        button {
            padding: 8px 15px;
        }

        a {
            text-decoration: none;
        }

        .add {
            display: inline-block;
            background: green;
            color: white;
            padding: 8px 12px;
            margin-bottom: 15px;
        }

        .edit {
            color: blue;
        }

        .delete {
            color: red;
        }

    </style>

</head>

<body>

<h1>Employees List</h1>

<a class="add" href="${pageContext.request.contextPath}/employees?action=add">
    Add Employee
</a>


<form method="get"
      action="${pageContext.request.contextPath}/employees">

    <input
            type="text"
            name="keyword"
            value="${keyword}"
            placeholder="Tên nhân viên">

    <select name="departmentId">

        <option value="">
            -- Tất cả phòng ban --
        </option>

        <c:forEach var="department"
                   items="${departments}">

            <option
                    value="${department.id}"
                    <c:if test="${selectedDepartment == department.id}">
                        selected
                    </c:if>>

                    ${department.name}

            </option>

        </c:forEach>

    </select>

    <button type="submit">
        Search
    </button>

</form>


<table>

    <thead>

    <tr>

        <th>ID</th>

        <th>Name</th>

        <th>Department</th>

        <th>Salary</th>

        <th>Action</th>

    </tr>

    </thead>

    <tbody>

    <c:forEach var="employee"
               items="${employees}">

        <tr>

            <td>
                    ${employee.id}
            </td>

            <td>
                    ${employee.name}
            </td>

            <td>
                    ${employee.departmentName}
            </td>

            <td>
                    ${employee.salary}
            </td>

            <td>

                <a
                        class="edit"
                        href="${pageContext.request.contextPath}/employees?action=edit&id=${employee.id}">

                    Edit

                </a>

                |

                <form method="post"
                      action="${pageContext.request.contextPath}/employees"
                      style="display:inline;">

                    <input
                            type="hidden"
                            name="action"
                            value="delete">

                    <input
                            type="hidden"
                            name="id"
                            value="${employee.id}">

                    <button
                            type="submit"
                            style="border:none;background:none;color:red;cursor:pointer;"
                            onclick="return confirm('Bạn có chắc muốn xóa nhân viên này?')">

                        Delete

                    </button>

                </form>

            </td>

        </tr>

    </c:forEach>

    </tbody>

</table>

<br>

<a href="${pageContext.request.contextPath}/departments">
    Departments
</a>

|

<a href="${pageContext.request.contextPath}/">
    Home
</a>

</body>

</html>