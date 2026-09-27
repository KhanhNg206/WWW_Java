<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Shopping Cart</title>

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet">

    <link
            rel="stylesheet"
            href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

<div class="container">


    <header>

        <div class="logo">
            IUH BOOKSTORE
        </div>

        <nav>

            <a href="${pageContext.request.contextPath}/books">
                HOME
            </a>

            <a href="#">
                EXAMPLES
            </a>

            <a href="#">
                SERVICES
            </a>

            <a href="${pageContext.request.contextPath}/cart">
                PRODUCTS
            </a>

            <a href="#">
                CONTACT
            </a>

        </nav>

    </header>


    <div class="row">

        <div class="col-md-3 sidebar">

            <h6>ABOUT US</h6>

            <p>
                About us tutorials will be here...
            </p>

            <a href="#">
                Read More »
            </a>

            <hr>

            <h6>SEARCH SITE</h6>

            <form
                    action="${pageContext.request.contextPath}/search"
                    method="get">

                <input
                        type="text"
                        name="keyword"
                        class="form-control"
                        value="${keyword}">

                <button
                        type="submit"
                        class="btn btn-secondary mt-2">

                    Search

                </button>

            </form>

            <br>

            <a href="${pageContext.request.contextPath}/cart">
                Shopping cart
            </a>

        </div>


        <div class="col-md-9">

            <h5 class="cart-title">
                SHOPPING CART
            </h5>


            <table class="table table-bordered cart-table">

                <thead>

                <tr>

                    <th>Product ID</th>

                    <th>Product name</th>

                    <th>Price</th>

                    <th>Qty</th>

                    <th>Total</th>

                    <th>Remove</th>

                </tr>

                </thead>


                <tbody>

                <c:set
                        var="grandTotal"
                        value="0"/>


                <c:choose>

                    <c:when test="${not empty sessionScope.cart}">

                        <c:forEach
                                var="item"
                                items="${sessionScope.cart}">

                            <tr>

                                <td>
                                        ${item.book.id}
                                </td>

                                <td>
                                        ${item.book.tittle}
                                </td>

                                <td>
                                        ${item.book.price}
                                </td>

                                <td>

                                    <form
                                            action="${pageContext.request.contextPath}/cart"
                                            method="post"
                                            class="quantity-form">

                                        <input
                                                type="hidden"
                                                name="action"
                                                value="update">

                                        <input
                                                type="hidden"
                                                name="id"
                                                value="${item.book.id}">

                                        <input
                                                type="number"
                                                name="quantity"
                                                value="${item.quantity}"
                                                min="1"
                                                class="quantity-input">

                                        <button
                                                type="submit"
                                                class="btn btn-sm btn-secondary">

                                            Update

                                        </button>

                                    </form>

                                </td>

                                <td>

                                        ${item.total}

                                    <c:set
                                            var="grandTotal"
                                            value="${grandTotal + item.total}"/>

                                </td>

                                <td>

                                    <form
                                            action="${pageContext.request.contextPath}/cart"
                                            method="post">

                                        <input
                                                type="hidden"
                                                name="action"
                                                value="remove">

                                        <input
                                                type="hidden"
                                                name="id"
                                                value="${item.book.id}">

                                        <button
                                                type="submit"
                                                class="btn btn-sm btn-danger">

                                            Remove

                                        </button>

                                    </form>

                                </td>

                            </tr>

                        </c:forEach>

                    </c:when>



                    <c:otherwise>

                        <tr>

                            <td
                                    colspan="6"
                                    class="text-center">

                                Shopping cart is empty.

                            </td>

                        </tr>

                    </c:otherwise>

                </c:choose>

                </tbody>


                <tfoot>

                <tr>

                    <td
                            colspan="4"
                            class="text-end">

                        <strong>
                            Total price
                        </strong>

                    </td>

                    <td colspan="2">

                        <strong>
                            ${grandTotal} VND
                        </strong>

                    </td>

                </tr>

                </tfoot>

            </table>



            <div class="cart-buttons">

                <a
                        href="${pageContext.request.contextPath}/checkout"
                        class="btn btn-primary">

                    Checkout

                </a>


                <a
                        href="${pageContext.request.contextPath}/books"
                        class="btn btn-secondary">

                    Continue shopping

                </a>

            </div>

        </div>

    </div>

</div>

</body>

</html>