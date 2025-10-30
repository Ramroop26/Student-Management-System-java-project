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

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // Get form data
        String name = req.getParameter("name");
        String course = req.getParameter("course");
        String email = req.getParameter("email");

        // Create Student object
        Student s = new Student(name, course, email);

        // Save student to database
        dao.addStudent(s);

        // Redirect to list page
        res.sendRedirect("list");
    }
}
