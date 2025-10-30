package com.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.model.Student;
import com.student.dao.StudentDao;

@WebServlet("/edit")
public class EditStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private StudentDao dao = new StudentDao();

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // Get form data
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String course = req.getParameter("course");
        String email = req.getParameter("email");

        // Create Student object and set ID
        Student student = new Student(name, course, email);
        student.setId(id);

        // Update record in database
        dao.updateStudent(student);

        // Redirect to list page
        res.sendRedirect("list");
    }
}
