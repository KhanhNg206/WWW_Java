package org.example.www_tuan06_bai03.servlet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.www_tuan06_bai03.beans.Product;
import org.example.www_tuan06_bai03.dao.ProductDAO;

import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {

        try {
            Context initContext = new InitialContext();

            Context envContext =
                    (Context) initContext.lookup("java:/comp/env");

            DataSource dataSource =
                    (DataSource) envContext.lookup("jdbc/shopdb");

            productDAO = new ProductDAO(dataSource);

        } catch (NamingException e) {
            throw new ServletException(
                    "Cannot get DataSource jdbc/shopdb", e
            );
        }
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("detail".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            Product product =
                    productDAO.getProductById(id);

            request.setAttribute("product", product);

            request.getRequestDispatcher(
                    "/product-detail.jsp"
            ).forward(request, response);

            return;
        }

        List<Product> products =
                productDAO.getAllProducts();

        request.setAttribute("products", products);

        request.getRequestDispatcher(
                "/index.jsp"
        ).forward(request, response);
    }
}
