package com.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.student.dao.StudentDao;

@WebServlet("/delete")
public class DeleteStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private StudentDao dao = new StudentDao();

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // Get ID from URL
        int id = Integer.parseInt(req.getParameter("id"));

        // Delete student record
        dao.deleteStudent(id);

        // Redirect back to list page
        res.sendRedirect("list");
    }
}
