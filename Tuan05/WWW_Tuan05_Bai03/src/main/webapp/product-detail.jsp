<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Product Detail</title>

</head>

<body>

<h2>Product Detail</h2>

<c:if test="${empty product}">

    <p>Product not found!</p>

</c:if>

<c:if test="${not empty product}">

    <table border="1" cellpadding="10">

        <tr>
            <td>Model</td>
            <td>${product.model}</td>
        </tr>

        <tr>
            <td>Description</td>
            <td>${product.description}</td>
        </tr>

        <tr>
            <td>Price</td>

            <td>

                <fmt:formatNumber
                        value="${product.price}"
                        type="number"
                        maxFractionDigits="0"
                />

                VND

            </td>

        </tr>

        <tr>
            <td>Available Quantity</td>
            <td>${product.quantity}</td>
        </tr>

        <tr>

            <td>Image</td>

            <td>

                <img
                        src="${pageContext.request.contextPath}/images/${product.imgurl}"
                        width="150"
                >

            </td>

        </tr>

    </table>

    <br>

    <form
            action="${pageContext.request.contextPath}/cart"
            method="post"
    >

        <input
                type="hidden"
                name="action"
                value="add"
        >

        <input
                type="hidden"
                name="id"
                value="${product.id}"
        >

        <button type="submit">
            Add To Cart
        </button>

    </form>

</c:if>

<br>

<a href="${pageContext.request.contextPath}/products">
    Tiếp tục mua
</a>

</body>

</html>
