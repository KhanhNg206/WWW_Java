package org.example.ontaptk1_web_de03.controller;


import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.ontaptk1_web_de03.model.BorrowReport;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@WebServlet("/borrow")
public class BorrowSession extends HttpServlet {

    @Inject
    private BorrowReport borrowReport;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         int studentId = Integer.parseInt(req.getParameter("studentId"));
         String studentName = req.getParameter("studentName");
         String borrowDateText = req.getParameter("borrowDate");
         LocalDate borrowDate = LocalDate.parse(borrowDateText);
         LocalDate returnDate = LocalDate.parse(req.getParameter("returnDate"));
         String[] listBookTypes = req.getParameterValues("listBookTypes");
         Long borrowDays = returnDate.toEpochDay() - borrowDate.toEpochDay();

         if(borrowDays <= 0){
             req.setAttribute("error","Ngày mượn phải sau ngày trả");
             req.getRequestDispatcher("index.jsp").forward(req,resp);
             return;
         }

         if(listBookTypes != null){
             List<String> bookTypes = Arrays.asList(listBookTypes);
             borrowReport.setBookTypes(bookTypes);
         }else{
             borrowReport.setBookTypes(null);
         }

         borrowReport.setStudentId(studentId);
         borrowReport.setStudentName(studentName);
         borrowReport.setBorrowDate(borrowDate);
         borrowReport.setReturnDate(returnDate);
         borrowReport.setBorrowDays(borrowDays);

         req.getRequestDispatcher("result.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("borrowForm.jsp").forward(req,resp);
    }
}
