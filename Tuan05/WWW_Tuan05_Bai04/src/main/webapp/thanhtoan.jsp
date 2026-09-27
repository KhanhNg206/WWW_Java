<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Checkout</title>

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet">

    <link
            rel="stylesheet"
            href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

<div class="container">

    <!-- HEADER -->

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

        <!-- ================= SIDEBAR ================= -->

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
                        class="form-control">

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


        <!-- ================= CHECKOUT ================= -->

        <div class="col-md-9">

            <div class="checkout">

                <div class="checkout-header">

                    <span>
                        Checkout - Already registered?
                    </span>

                </div>


                <form
                        action="${pageContext.request.contextPath}/checkout"
                        method="post">


                    <!-- FULLNAME -->

                    <div class="checkout-row">

                        <label>
                            Fullname:
                        </label>

                        <input
                                type="text"
                                name="fullname"
                                required>

                    </div>


                    <!-- SHIPPING ADDRESS -->

                    <div class="checkout-row">

                        <label>
                            Shipping address:
                        </label>

                        <input
                                type="text"
                                name="address"
                                required>

                    </div>


                    <!-- TOTAL PRICE -->

                    <c:set
                            var="grandTotal"
                            value="0"/>

                    <c:forEach
                            var="item"
                            items="${sessionScope.cart}">

                        <c:set
                                var="grandTotal"
                                value="${grandTotal + item.total}"/>

                    </c:forEach>


                    <div class="checkout-row">

                        <label>
                            Total price:
                        </label>

                        <input
                                type="text"
                                value="${grandTotal} VND"
                                readonly>

                    </div>


                    <!-- PAYMENT METHOD -->

                    <div class="checkout-row payment-row">

                        <label>
                            Payment method:
                        </label>

                        <div class="payment-options">

                            <label>

                                <input
                                        type="radio"
                                        name="payment"
                                        value="Paypal"
                                        required>

                                Paypal

                            </label>


                            <label>

                                <input
                                        type="radio"
                                        name="payment"
                                        value="ATM Debit">

                                ATM Debit

                            </label>


                            <label>

                                <input
                                        type="radio"
                                        name="payment"
                                        value="VisaMasterCard">

                                VisaMasterCard

                            </label>

                        </div>

                    </div>


                    <!-- BUTTON -->

                    <div class="checkout-buttons">

                        <button
                                type="submit"
                                class="btn btn-primary">

                            Save

                        </button>


                        <a
                                href="${pageContext.request.contextPath}/cart"
                                class="btn btn-secondary">

                            Cancel

                        </a>

                    </div>

                </form>

            </div>

        </div>

    </div>

</div>

</body>

</html>