package org.example.www_tuan06_bai03.servlet;

import org.example.www_tuan06_bai03.beans.CartBean;
import org.example.www_tuan06_bai03.beans.Product;
import org.example.www_tuan06_bai03.dao.ProductDAO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

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
                    "Cannot get DataSource jdbc/shopdb",
                    e
            );
        }
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        CartBean cart =
                (CartBean) session.getAttribute("cart");

        if (cart == null) {

            cart = new CartBean();

            session.setAttribute("cart", cart);
        }

        request.getRequestDispatcher(
                "/cart.jsp"
        ).forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String action =
                request.getParameter("action");

        HttpSession session =
                request.getSession();

        CartBean cart =
                (CartBean) session.getAttribute("cart");

        if (cart == null) {

            cart = new CartBean();

            session.setAttribute("cart", cart);
        }

        // ADD
        if ("add".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            Product product =
                    productDAO.getProductById(id);

            if (product != null) {
                cart.addProduct(product);
            }

            response.sendRedirect(
                    request.getContextPath()
                            + "/products"
            );

            return;
        }

        // UPDATE
        if ("update".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            int quantity = Integer.parseInt(
                    request.getParameter("quantity")
            );

            cart.updateQuantity(id, quantity);

            response.sendRedirect(
                    request.getContextPath()
                            + "/cart"
            );

            return;
        }

        // REMOVE
        if ("remove".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            cart.removeProduct(id);

            response.sendRedirect(
                    request.getContextPath()
                            + "/cart"
            );

            return;
        }

        // CLEAR
        if ("clear".equals(action)) {

            cart.clear();

            response.sendRedirect(
                    request.getContextPath()
                            + "/cart"
            );

            return;
        }

        response.sendRedirect(
                request.getContextPath()
                        + "/cart"
        );
    }
}


