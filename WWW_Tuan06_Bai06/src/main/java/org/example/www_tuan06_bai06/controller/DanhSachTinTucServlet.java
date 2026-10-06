package org.example.www_tuan06_bai06.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.www_tuan06_bai06.dao.DanhSachTinTucQuanLy;


import java.io.IOException;

@WebServlet("/tin-tuc")
public class DanhSachTinTucServlet extends HttpServlet {

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

        String madmParam =
                request.getParameter("madm");

        if (madmParam != null
                && !madmParam.isEmpty()) {

            int madm =
                    Integer.parseInt(madmParam);

            request.setAttribute(
                    "tinTucs",
                    quanLy.getByDanhMuc(madm)
            );

            request.setAttribute(
                    "selectedDanhMuc",
                    madm
            );

        } else {

            request.setAttribute(
                    "tinTucs",
                    quanLy.getAll()
            );
        }

        request.setAttribute(
                "danhMucs",
                quanLy.getDanhMuc()
        );

        request.getRequestDispatcher(
                "/DanhSachTinTuc.jsp"
        ).forward(request, response);
    }
}
