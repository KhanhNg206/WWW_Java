package org.example.www_tuan06_bai04.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.www_tuan06_bai04.dao.BookDAO;

import java.io.IOException;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

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

        String keyword = request.getParameter("keyword");

        if (keyword == null) {
            keyword = "";
        }

        request.setAttribute(
                "books",
                bookDAO.searchBooks(keyword)
        );

        request.setAttribute("keyword", keyword);

        request.getRequestDispatcher("/danhsach.jsp")
                .forward(request, response);
    }
}
