<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Book Detail</title>

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet">

    <link rel="stylesheet"
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

            <hr>

            <h6>SEARCH SITE</h6>

            <form
                    action="${pageContext.request.contextPath}/search"
                    method="get">

                <input
                        type="text"
                        name="keyword"
                        class="form-control">

                <button class="btn btn-secondary mt-2">
                    Search
                </button>

            </form>

        </div>


        <div class="col-md-9">

            <h5>
                ${book.tittle}
            </h5>

            <div class="detail">

                <img
                        src="${pageContext.request.contextPath}/images/${book.imgbook}"
                        class="detail-image">

                <div>

                    <p>
                        Author: ${book.author}
                    </p>

                    <p>
                        Price: ${book.price} VND
                    </p>

                    <p>
                        Quantity: 10
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

                        <button class="btn btn-primary">
                            Add to cart
                        </button>

                    </form>

                    <br>

                    <a href="${pageContext.request.contextPath}/books">
                        Back to Product List
                    </a>

                </div>

            </div>

        </div>

    </div>

</div>

</body>

</html>