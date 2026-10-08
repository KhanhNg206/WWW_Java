package org.example.ontaptk1_web_final.controller;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.ontaptk1_web_final.model.Passenger;
import org.example.ontaptk1_web_final.service.TicketManager;

import java.io.IOException;

@WebServlet("/bus-ticket")
public class BusTicketManager extends HttpServlet {

    @Inject
    private TicketManager ticketManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         String passengerName = req.getParameter("passengerName");
         String password = req.getParameter("password");
         String seatType = req.getParameter("seatType");
         String route = req.getParameter("route");

        Passenger passenger = new Passenger(passengerName,password,seatType,route);

        ticketManager.addPassenger(passenger);

//        req.setAttribute("passengers",ticketManager.getAllPassenger());

        req.getRequestDispatcher("ticketResult.jsp").forward(req,resp);

    }
}
