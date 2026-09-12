package org.example.ontaptk1_web_de02.controller;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.ontaptk1_web_de02.model.GradeReport;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@WebServlet("/grade")
public class GradeServlet extends HttpServlet {

    @Inject
    GradeReport gradeReport;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String maSv = req.getParameter("maSinhVien");
        String hoVaTen = req.getParameter("hoVaTen");
        String hocKy = req.getParameter("hocKy");
        String[] monHoc = req.getParameterValues("monHoc");

        gradeReport.setHoVaTen(hoVaTen);
        gradeReport.setMaSv(maSv);
        gradeReport.setHocKy(hocKy);

        if(monHoc != null){
            List<String> dsMonHoc = Arrays.asList(monHoc);
            gradeReport.setMonHoc(dsMonHoc);
        }else{
            gradeReport.setMonHoc(null);
        }

        req.getRequestDispatcher("result.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("gradeform.jsp").forward(req,resp);
    }
}
