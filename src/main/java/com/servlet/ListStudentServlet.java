package com.servlet;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.model.Student;
import com.student.dao.StudentDao;

@WebServlet("/list")
public class ListStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDao dao = new StudentDao();

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (req.getSession(false) == null || req.getSession(false).getAttribute("user") == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        List<Student> list = dao.getAllStudents();
        req.setAttribute("students", list);
        RequestDispatcher rd = req.getRequestDispatcher("students.jsp");
        rd.forward(req, res);
    }
}
