package com.servlet;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.model.Student;
import com.student.dao.StudentDao;

@WebServlet("/list")
public class ListStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private StudentDao dao = new StudentDao();

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // Get all students from database
        List<Student> students = dao.getAllStudents();

        // Set data for JSP
        req.setAttribute("students", students);

        // Forward to JSP page
        RequestDispatcher rd = req.getRequestDispatcher("students.jsp");
        rd.forward(req, res);
    }
}
