package com.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.model.Student;
import com.student.dao.StudentDao;

@WebServlet("/add")
public class AddStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDao dao = new StudentDao();

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        // session check: only logged-in users
        if (req.getSession(false) == null || req.getSession(false).getAttribute("user") == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        String name = req.getParameter("name");
        String course = req.getParameter("course");
        String email = req.getParameter("email");

        Student s = new Student(name, course, email);
        dao.addStudent(s);
        res.sendRedirect("list");
    }
}
