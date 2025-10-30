package com.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // End the current session (if exists)
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Redirect to login page
        res.sendRedirect("login.jsp");
    }
}
