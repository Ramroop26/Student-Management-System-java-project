package com.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.model.User;
import com.student.dao.UserDao;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserDao dao = new UserDao();

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // Get form data
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Create User object
        User user = new User(name, email, password);

        // Save to database
        boolean success = dao.register(user);

        // Redirect based on result
        if (success) {
            res.sendRedirect("login.jsp?msg=registered");
        } else {
            res.sendRedirect("register.jsp?error=1");
        }
    }
}
