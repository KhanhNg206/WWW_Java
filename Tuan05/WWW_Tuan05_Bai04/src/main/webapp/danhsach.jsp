<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>IUH BOOKSTORE</title>

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet">

    <link rel="stylesheet"
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

        <!-- SIDEBAR -->

        <div class="col-md-3 sidebar">

            <h6>ABOUT US</h6>

            <p>
                About us tutorials will be here...
            </p>

            <hr>

            <h6>SEARCH SITE</h6>

            <form
                    action="${pageContext.request.contextPath}/search"
                    method="get">

                <input
                        type="text"
                        name="keyword"
                        value="${keyword}"
                        class="form-control">

                <button class="btn btn-secondary mt-2">
                    Search
                </button>

            </form>

            <br>

            <a href="${pageContext.request.contextPath}/cart">
                Shopping cart
            </a>

        </div>


        <!-- BOOK LIST -->

        <div class="col-md-9">

            <div class="row">

                <c:forEach var="book" items="${books}">

                    <div class="col-md-4 mb-4">

                        <div class="book-card">

                            <a href="${pageContext.request.contextPath}/book-detail?id=${book.id}">

                                <img
                                        src="${pageContext.request.contextPath}/images/${book.imgbook}"
                                        class="book-image">

                            </a>

                            <h6>
                                    ${book.tittle}
                            </h6>

                            <p>
                                Price: ${book.price} VND
                            </p>

                            <p>
                                Quantity: 1
                            </p>

                            <form
                                    action="${pageContext.request.contextPath}/cart"
                                    method="post">

                                <input
                                        type="hidden"
                                        name="action"
                                        value="add">

                                <input
                                        type="hidden"
                                        name="id"
                                        value="${book.id}">

                                <button class="btn btn-sm btn-primary">
                                    Add to cart
                                </button>

                            </form>

                        </div>

                    </div>

                </c:forEach>

            </div>

        </div>

    </div>

</div>

</body>
</html>