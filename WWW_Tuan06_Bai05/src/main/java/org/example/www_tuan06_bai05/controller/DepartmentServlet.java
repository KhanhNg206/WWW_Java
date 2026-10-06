package org.example.www_tuan06_bai05.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.www_tuan06_bai05.dao.DepartmentDAO;
import org.example.www_tuan06_bai05.model.Department;

import java.io.IOException;
import java.util.List;

@WebServlet("/departments")
public class DepartmentServlet extends HttpServlet {

    private DepartmentDAO departmentDAO;

    @Override
    public void init() {

        departmentDAO = new DepartmentDAO();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("edit".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            Department department =
                    departmentDAO.getById(id);

            request.setAttribute(
                    "department",
                    department
            );

            request.getRequestDispatcher(
                    "/department-form.jsp"
            ).forward(request, response);

            return;
        }

        String keyword =
                request.getParameter("keyword");

        List<Department> departments;

        if (keyword == null || keyword.trim().isEmpty()) {

            departments = departmentDAO.getAll();

        } else {

            departments =
                    departmentDAO.search(keyword.trim());
        }

        request.setAttribute(
                "departments",
                departments
        );

        request.setAttribute(
                "keyword",
                keyword
        );

        request.getRequestDispatcher(
                "/departments.jsp"
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

        if ("add".equals(action)) {

            String name = request.getParameter("name");

            Department department = new Department(name);

            departmentDAO.insert(department);

        } else if ("update".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            String name =
                    request.getParameter("name");

            Department department =
                    new Department(id, name);

            departmentDAO.update(department);

        } else if ("delete".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            departmentDAO.delete(id);
        }

        response.sendRedirect(
                request.getContextPath() + "/departments"
        );
    }
}