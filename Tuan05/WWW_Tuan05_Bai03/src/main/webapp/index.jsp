<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Shop</title>

    <style>

        body {
            font-family: Arial, sans-serif;
        }

        .top {
            margin-bottom: 10px;
        }

        .products {
            display: flex;
            gap: 6px;
            border: 1px solid green;
            padding: 8px;
            width: fit-content;
        }

        .product {
            width: 110px;
            min-height: 190px;
            border: 1px solid #999;
            padding: 8px;
            text-align: center;
        }

        .product img {
            width: 70px;
            height: 80px;
            object-fit: contain;
        }

        .product button {
            margin-top: 5px;
        }

        a {
            color: purple;
        }

    </style>

</head>

<body>

<div class="top">

    <a href="${pageContext.request.contextPath}/cart">
        View Cart
    </a>

</div>


<div class="products">

    <c:forEach var="p" items="${products}">

        <div class="product">

            <b>
                    ${p.model}
            </b>

            <br><br>

            <img
                    src="${pageContext.request.contextPath}/images/${p.imgurl}"
                    alt="${p.model}"
                    width="100"
                    height="100">


            <br><br>

            Price:

            <fmt:formatNumber
                    value="${p.price}"
                    type="number"
                    maxFractionDigits="0"
            />

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
                        value="${p.id}"
                >

                <input
                        type="number"
                        name="quantity"
                        value="1"
                        min="1"
                        style="width:35px"
                >

                <br>

                <button type="submit">
                    Add To Cart
                </button>

            </form>

            <br>

            <a
                    href="${pageContext.request.contextPath}/products?action=detail&id=${p.id}">
                Product Detail
            </a>

        </div>

    </c:forEach>

</div>

</body>

</html>
