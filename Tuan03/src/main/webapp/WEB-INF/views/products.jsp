<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Danh sách sản phẩm</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 30px;
        }

        .page {
            max-width: 1000px;
            margin: auto;
        }

        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .card {
            margin-top: 30px;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #f5f5f5;
        }

        button {
            padding: 7px 12px;
            cursor: pointer;
        }

        .secondary {
            background-color: #eee;
        }

        .technical {
            color: #666;
            font-size: 14px;
        }
    </style>
</head>

<body>

<main class="page">

    <header>
        <div>
            <h1>Danh sách sản phẩm</h1>

            <p>
                Xin chào,
                <strong>${userSession.username}</strong>
            </p>
        </div>

        <form method="post"
              action="${pageContext.request.contextPath}/logout">

            <button class="secondary" type="submit">
                Đăng xuất
            </button>

        </form>
    </header>


    <!-- DANH SÁCH SẢN PHẨM -->
    <section class="card">

        <h2>Sản phẩm</h2>

        <table>

            <thead>
            <tr>
                <th>Sản phẩm</th>
                <th>Giá</th>
                <th></th>
            </tr>
            </thead>

            <tbody>

            <c:choose>

                <c:when test="${empty products}">

                    <tr>
                        <td colspan="3">
                            Không có sản phẩm nào.
                        </td>
                    </tr>

                </c:when>

                <c:otherwise>

                    <c:forEach items="${products}" var="product">

                        <tr>

                            <td>
                                    ${product.name}
                            </td>

                            <td>
                                <fmt:formatNumber
                                        value="${product.price}"
                                        type="currency"
                                        currencyCode="USD"/>
                            </td>

                            <td>

                                <form method="post"
                                      action="${pageContext.request.contextPath}/cart/add">

                                    <input type="hidden"
                                           name="productId"
                                           value="${product.id}">

                                    <button type="submit">
                                        Thêm vào giỏ
                                    </button>

                                </form>

                            </td>

                        </tr>

                    </c:forEach>

                </c:otherwise>

            </c:choose>

            </tbody>

        </table>

    </section>


    <!-- GIỎ HÀNG -->
    <section class="card">

        <h2>Giỏ hàng trong session</h2>

        <c:choose>

            <c:when test="${empty userSession.shoppingCart.items}">

                <p>Giỏ hàng đang trống.</p>

            </c:when>

            <c:otherwise>

                <ul>

                    <c:forEach
                            items="${userSession.shoppingCart.items}"
                            var="item">

                        <li>

                                ${item.product.name}
                            × ${item.quantity}
                            —

                            <fmt:formatNumber
                                    value="${item.subtotal}"
                                    type="currency"
                                    currencyCode="USD"/>

                        </li>

                    </c:forEach>

                </ul>

            </c:otherwise>

        </c:choose>


        <p>
            <strong>Số lượng:</strong>
            ${userSession.shoppingCart.itemCount}
        </p>


        <p>
            <strong>Tổng tiền:</strong>

            <fmt:formatNumber
                    value="${userSession.shoppingCart.total}"
                    type="currency"
                    currencyCode="USD"/>

        </p>


        <p class="technical">
            CDI session instance:
            ${userSession.instanceId}
        </p>

    </section>
    <div>
        <p>
            Số người đang online:
            <strong>${applicationScope.activeUsersCount - 1}</strong>
        </p>
    </div>
</main>

</body>
</html>
