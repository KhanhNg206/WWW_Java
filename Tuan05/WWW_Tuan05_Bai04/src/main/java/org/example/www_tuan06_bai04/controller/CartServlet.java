package org.example.www_tuan06_bai04.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.www_tuan06_bai04.dao.BookDAO;
import org.example.www_tuan06_bai04.model.Book;
import org.example.www_tuan06_bai04.model.CartItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private BookDAO bookDAO;

    @Override
    public void init() {
        bookDAO = new BookDAO();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        HttpSession session = request.getSession();

        List<CartItem> cart =
                (List<CartItem>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        request.getRequestDispatcher("/giohang.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {

        String action = request.getParameter("action");

        HttpSession session = request.getSession();

        List<CartItem> cart =
                (List<CartItem>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        // Thêm sách
        if ("add".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            Book book = bookDAO.getBookById(id);

            boolean found = false;

            for (CartItem item : cart) {

                if (item.getBook().getId() == id) {

                    item.setQuantity(
                            item.getQuantity() + 1
                    );

                    found = true;
                    break;
                }
            }

            if (!found) {
                cart.add(new CartItem(book, 1));
            }
        }

        // Xóa sản phẩm
        if ("remove".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            cart.removeIf(
                    item -> item.getBook().getId() == id
            );
        }

        // Thay đổi số lượng
        if ("update".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            int quantity = Integer.parseInt(
                    request.getParameter("quantity")
            );

            for (CartItem item : cart) {

                if (item.getBook().getId() == id) {

                    if (quantity <= 0) {
                        cart.remove(item);
                    } else {
                        item.setQuantity(quantity);
                    }

                    break;
                }
            }
        }

        session.setAttribute("cart", cart);

        response.sendRedirect(
                request.getContextPath() + "/cart"
        );
    }
}
