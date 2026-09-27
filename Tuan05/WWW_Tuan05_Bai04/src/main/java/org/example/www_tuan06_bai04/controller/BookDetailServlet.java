package org.example.www_tuan06_bai04.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.www_tuan06_bai04.dao.BookDAO;
import org.example.www_tuan06_bai04.model.Book;

import java.io.IOException;

@WebServlet("/book-detail")
public class BookDetailServlet extends HttpServlet {

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

        int id = Integer.parseInt(
                request.getParameter("id")
        );

        Book book = bookDAO.getBookById(id);

        request.setAttribute("book", book);

        request.getRequestDispatcher("/chitietsach.jsp")
                .forward(request, response);
    }
}
