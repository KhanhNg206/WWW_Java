package org.example.www_tuan06_bai06.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.www_tuan06_bai06.dao.DanhSachTinTucQuanLy;


import java.io.IOException;

@WebServlet("/quan-ly")
public class QuanLyFormServlet extends HttpServlet {

    private DanhSachTinTucQuanLy quanLy;

    @Override
    public void init() {
        quanLy = new DanhSachTinTucQuanLy();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute(
                "tinTucs",
                quanLy.getAll()
        );

        request.getRequestDispatcher(
                "/QuanLyForm.jsp"
        ).forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String matt =
                request.getParameter("matt");

        quanLy.delete(matt);

        response.sendRedirect(
                request.getContextPath()
                        + "/quan-ly"
        );
    }
}
