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

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th,
        td {
            border: 1px solid #ccc;
            padding: 8px;
        }

        th {
            background: #eee;
        }

        button {
            padding: 5px 10px;
        }

    </style>

</head>

<body>

<h1>QUẢN LÝ TIN TỨC</h1>

<p>

    <a href="${pageContext.request.contextPath}/tin-tuc">
        Xem danh sách
    </a>

    |

    <a href="${pageContext.request.contextPath}/tin-tuc-form">
        Thêm tin tức
    </a>

</p>

<table>

    <tr>

        <th>Mã tin</th>

        <th>Tiêu đề</th>

        <th>Nội dung</th>

        <th>Danh mục</th>

        <th>Thao tác</th>

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
                    ${tin.madm}
            </td>

            <td>

                <form method="post"
                      action="${pageContext.request.contextPath}/quan-ly"
                      onsubmit="return confirm('Bạn có chắc muốn xóa tin này không?');">

                    <input type="hidden"
                           name="matt"
                           value="${tin.matt}">

                    <button type="submit">
                        Xóa
                    </button>

                </form>

            </td>

        </tr>

    </c:forEach>

</table>

</body>

</html>