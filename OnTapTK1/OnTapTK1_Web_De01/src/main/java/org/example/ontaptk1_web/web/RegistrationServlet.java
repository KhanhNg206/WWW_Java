package org.example.ontaptk1_web.web;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.ontaptk1_web.model.StudentRegistration;
import org.example.ontaptk1_web.service.RegistrationService;
import org.example.ontaptk1_web.session.RegistrationSession;

import java.io.IOException;

@WebServlet("/dangKy")
public class RegistrationServlet extends HttpServlet {
    @Inject
    private RegistrationService registrationService;

    @Inject
    private RegistrationSession registrationSession;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String course = req.getParameter("course");
        String mode = req.getParameter("mode");

        String[] skills = req.getParameterValues("skills");

        StudentRegistration registration = registrationService.createRegistration(
                fullName,
                email,
                course,
                skills,
                mode
        );

        registrationSession.save(registration);
        req.getSession().setAttribute("registration", registration);

        resp.sendRedirect("result.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.sendRedirect("index.jsp");
    }
}
