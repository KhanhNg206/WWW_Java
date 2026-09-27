<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Cart</title>

    <style>

        .cart {
            border: 1px solid green;
            padding: 5px;
            width: 450px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            padding: 5px;
        }

        th {
            text-align: left;
        }

        .empty {
            border: 1px solid green;
            width: 200px;
            padding: 10px;
        }

        .continue {
            margin-top: 15px;
        }

    </style>

</head>

<body>

<h1>Cart</h1>


<!-- ========================== -->
<!-- GIỎ HÀNG TRỐNG -->
<!-- ========================== -->

<c:if test="${empty sessionScope.cart.items}">

    <div class="empty">

        <h2>Cart</h2>

        <p>
            Cart is empty!
        </p>

        <a
                href="${pageContext.request.contextPath}/products">
            Tiếp tục mua
        </a>

    </div>

</c:if>


<!-- ========================== -->
<!-- GIỎ HÀNG CÓ SẢN PHẨM -->
<!-- ========================== -->

<c:if test="${not empty sessionScope.cart.items}">

    <div class="cart">

        <h2>Cart</h2>

        <table>

            <thead>

            <tr>

                <th>Model</th>

                <th>Quantity</th>

                <th>Price</th>

                <th>SubTotal</th>

                <th>Action</th>

            </tr>

            </thead>

            <tbody>

            <c:forEach
                    var="item"
                    items="${sessionScope.cart.items}">

                <tr>

                    <td>
                            ${item.product.model}
                    </td>


                    <td>

                        <form
                                action="${pageContext.request.contextPath}/cart"
                                method="post"
                        >

                            <input
                                    type="hidden"
                                    name="action"
                                    value="update"
                            >

                            <input
                                    type="hidden"
                                    name="id"
                                    value="${item.product.id}"
                            >

                            <input
                                    type="number"
                                    name="quantity"
                                    value="${item.quantity}"
                                    min="1"
                                    style="width:90px"
                            >

                            <button type="submit">
                                Cập nhật
                            </button>

                        </form>

                    </td>


                    <td>

                        <fmt:formatNumber
                                value="${item.product.price}"
                                type="number"
                                maxFractionDigits="0"
                        />

                    </td>


                    <td>

                        <fmt:formatNumber
                                value="${item.subtotal}"
                                type="number"
                                maxFractionDigits="0"
                        />

                    </td>


                    <td>

                        <form
                                action="${pageContext.request.contextPath}/cart"
                                method="post"
                        >

                            <input
                                    type="hidden"
                                    name="action"
                                    value="remove"
                            >

                            <input
                                    type="hidden"
                                    name="id"
                                    value="${item.product.id}"
                            >

                            <button type="submit">
                                Xóa
                            </button>

                        </form>

                    </td>

                </tr>

            </c:forEach>

            </tbody>


            <tfoot>

            <tr>

                <th colspan="3">
                    Total:
                </th>

                <th colspan="2">

                    <fmt:formatNumber
                            value="${sessionScope.cart.total}"
                            type="number"
                            maxFractionDigits="0"
                    />

                    VND

                </th>

            </tr>

            </tfoot>

        </table>


        <br>


        <!-- Xóa hết giỏ hàng -->

        <form
                action="${pageContext.request.contextPath}/cart"
                method="post"
        >

            <input
                    type="hidden"
                    name="action"
                    value="clear"
            >

            <button type="submit">
                Xóa hết giỏ hàng
            </button>

        </form>


        <div class="continue">

            <a
                    href="${pageContext.request.contextPath}/products">
                Tiếp tục mua
            </a>

        </div>

    </div>

</c:if>

</body>

</html>
