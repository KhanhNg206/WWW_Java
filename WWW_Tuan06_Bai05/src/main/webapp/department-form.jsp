<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<!DOCTYPE html>

<html>

<head>

    <title>Department Form</title>

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

        input {
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

    <c:when test="${department != null}">

        <h1>Edit Department</h1>

        <form method="post"
              action="${pageContext.request.contextPath}/departments">

            <input type="hidden"
                   name="action"
                   value="update">

            <input type="hidden"
                   name="id"
                   value="${department.id}">

            <div class="form-group">

                <label>
                    Department Name
                </label>

                <input
                        type="text"
                        name="name"
                        value="${department.name}"
                        required>

            </div>

            <button type="submit">
                Update
            </button>

        </form>

    </c:when>

    <c:otherwise>

        <h1>Add Department</h1>

        <form method="post"
              action="${pageContext.request.contextPath}/departments">

            <input type="hidden"
                   name="action"
                   value="add">

            <div class="form-group">

                <label>
                    Department Name
                </label>

                <input
                        type="text"
                        name="name"
                        required>

            </div>

            <button type="submit">
                Add
            </button>

        </form>

    </c:otherwise>

</c:choose>

<br>

<a href="${pageContext.request.contextPath}/departments">
    Back to Departments
</a>

</body>

</html>