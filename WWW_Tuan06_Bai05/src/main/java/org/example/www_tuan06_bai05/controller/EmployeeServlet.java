package org.example.www_tuan06_bai05.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.www_tuan06_bai05.dao.DepartmentDAO;
import org.example.www_tuan06_bai05.dao.EmployeeDAO;
import org.example.www_tuan06_bai05.model.Department;
import org.example.www_tuan06_bai05.model.Employee;

import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {

    private EmployeeDAO employeeDAO;
    private DepartmentDAO departmentDAO;

    @Override
    public void init() {

        employeeDAO = new EmployeeDAO();
        departmentDAO = new DepartmentDAO();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action =
                request.getParameter("action");

        // =========================
        // ADD EMPLOYEE
        // =========================
        if ("add".equals(action)) {

            List<Department> departments =
                    departmentDAO.getAll();

            request.setAttribute(
                    "departments",
                    departments
            );

            request.getRequestDispatcher(
                    "/employee-form.jsp"
            ).forward(request, response);

            return;
        }

        // =========================
        // EDIT EMPLOYEE
        // =========================
        if ("edit".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            Employee employee =
                    employeeDAO.getById(id);

            List<Department> departments =
                    departmentDAO.getAll();

            request.setAttribute(
                    "employee",
                    employee
            );

            request.setAttribute(
                    "departments",
                    departments
            );

            request.getRequestDispatcher(
                    "/employee-form.jsp"
            ).forward(request, response);

            return;
        }

        // =========================
        // EMPLOYEE LIST
        // =========================

        String departmentIdParam =
                request.getParameter("departmentId");

        String keyword =
                request.getParameter("keyword");

        List<Employee> employees;

        Integer departmentId = null;

        if (departmentIdParam != null
                && !departmentIdParam.isEmpty()) {

            departmentId =
                    Integer.parseInt(departmentIdParam);
        }

        if (keyword != null
                && !keyword.trim().isEmpty()) {

            employees = employeeDAO.search(
                    keyword.trim(),
                    departmentId
            );

        } else if (departmentId != null) {

            employees =
                    employeeDAO.getByDepartment(
                            departmentId
                    );

        } else {

            employees =
                    employeeDAO.getAll();
        }

        request.setAttribute(
                "employees",
                employees
        );

        request.setAttribute(
                "departments",
                departmentDAO.getAll()
        );

        request.setAttribute(
                "keyword",
                keyword
        );

        request.setAttribute(
                "selectedDepartment",
                departmentId
        );

        request.getRequestDispatcher(
                "/employees.jsp"
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

            String name =
                    request.getParameter("name");

            int departmentId =
                    Integer.parseInt(
                            request.getParameter(
                                    "departmentId"
                            )
                    );

            double salary =
                    Double.parseDouble(
                            request.getParameter("salary")
                    );

            Employee employee =
                    new Employee(
                            name,
                            departmentId,
                            salary
                    );

            employeeDAO.insert(employee);

        } else if ("update".equals(action)) {

            int id =
                    Integer.parseInt(
                            request.getParameter("id")
                    );

            String name =
                    request.getParameter("name");

            int departmentId =
                    Integer.parseInt(
                            request.getParameter(
                                    "departmentId"
                            )
                    );

            double salary =
                    Double.parseDouble(
                            request.getParameter("salary")
                    );

            Employee employee =
                    new Employee();

            employee.setId(id);
            employee.setName(name);
            employee.setDepartmentId(departmentId);
            employee.setSalary(salary);

            employeeDAO.update(employee);

        } else if ("delete".equals(action)) {

            int id =
                    Integer.parseInt(
                            request.getParameter("id")
                    );

            employeeDAO.delete(id);
        }

        response.sendRedirect(
                request.getContextPath() + "/employees"
        );
    }
}
