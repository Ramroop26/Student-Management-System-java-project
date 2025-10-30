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
    private UserDao userDao = new UserDao();

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = userDao.login(email, password);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user); // store User object
            res.sendRedirect("list"); // list students
        } else {
            res.sendRedirect("login.jsp?error=1");
        }
    }
}
