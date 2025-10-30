package com.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.model.User;
import com.student.dao.UserDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserDao dao = new UserDao();

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // Get login details
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Check user in database
        User user = dao.login(email, password);

        if (user != null) {
            // Login success → save in session
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            res.sendRedirect("list");
        } else {
            // Login failed → back to login page
            res.sendRedirect("login.jsp?error=1");
        }
    }
}
