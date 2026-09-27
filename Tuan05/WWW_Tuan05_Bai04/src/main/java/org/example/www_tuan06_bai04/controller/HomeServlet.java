package org.example.www_tuan06_bai04.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.www_tuan06_bai04.dao.BookDAO;
import org.example.www_tuan06_bai04.model.Book;

import java.io.IOException;
import java.util.List;

@WebServlet("/books")
public class HomeServlet extends HttpServlet {

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

        List<Book> books = bookDAO.getAllBooks();

        request.setAttribute("books", books);

        request.getRequestDispatcher("/danhsach.jsp")
                .forward(request, response);
    }
}
