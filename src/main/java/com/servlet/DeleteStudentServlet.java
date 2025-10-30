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

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (req.getSession(false) == null || req.getSession(false).getAttribute("user") == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        int id = Integer.parseInt(req.getParameter("id"));
        dao.deleteStudent(id);
        res.sendRedirect("list");
    }
}
