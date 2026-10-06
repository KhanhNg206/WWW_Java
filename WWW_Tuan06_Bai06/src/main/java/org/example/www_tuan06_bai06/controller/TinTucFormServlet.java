package org.example.www_tuan06_bai06.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.www_tuan06_bai06.dao.DanhSachTinTucQuanLy;
import org.example.www_tuan06_bai06.model.TinTuc;


import java.io.IOException;

@WebServlet("/tin-tuc-form")
public class TinTucFormServlet extends HttpServlet {

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
                "danhMucs",
                quanLy.getDanhMuc()
        );

        request.getRequestDispatcher(
                "/TinTucForm.jsp"
        ).forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String matt =
                request.getParameter("matt");

        String tieuDe =
                request.getParameter("tieuDe");

        String noiDung =
                request.getParameter("noiDungTT");

        String lienKet =
                request.getParameter("lienKet");

        int madm =
                Integer.parseInt(
                        request.getParameter("madm")
                );

        TinTuc tinTuc =
                new TinTuc(
                        matt,
                        tieuDe,
                        noiDung,
                        lienKet,
                        madm
                );

        boolean success =
                quanLy.insert(tinTuc);

        if (success) {

            response.sendRedirect(
                    request.getContextPath()
                            + "/tin-tuc"
            );

        } else {

            request.setAttribute(
                    "error",
                    "Không thể thêm tin tức. Mã tin có thể đã tồn tại."
            );

            request.setAttribute(
                    "danhMucs",
                    quanLy.getDanhMuc()
            );

            request.getRequestDispatcher(
                    "/TinTucForm.jsp"
            ).forward(request, response);
        }
    }
}
