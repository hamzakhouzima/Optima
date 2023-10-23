package com.optima.demo12.Http;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name="LogoutServlet", urlPatterns={"/demo12_war_exploded/LogoutServlet/"})
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the user's session
        HttpSession session = request.getSession(false);

        if (session != null) {
            // Invalidate the session
            session.invalidate();
        }

        // Redirect the user to the login page or any other appropriate page
//        response.sendRedirect("/demo12_war_exploded/LoginServlet/");


        RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginServlet/");
        dispatcher.include(request, response);

    }



}
