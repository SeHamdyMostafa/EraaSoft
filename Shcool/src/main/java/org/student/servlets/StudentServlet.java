package org.student.servlets;

import org.student.models.StudentModel;
import org.student.repo.StudentRepo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class StudentServlet extends HttpServlet {

    StudentRepo repo = new StudentRepo();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if ("edit".equals(action)) {

            int id = Integer.parseInt(req.getParameter("id"));
            StudentModel student = repo.getStudentById(id);

            req.setAttribute("student", student);
            req.getRequestDispatcher("edit.jsp").forward(req, resp);

        } else {
            req.setAttribute("students", repo.getStudents());
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String action = req.getParameter("action");

        if (action == null) action = "add";

        switch (action) {
            case "add":
                StudentModel NewStudent = new StudentModel();
                NewStudent.setName(req.getParameter("name"));
                NewStudent.setAge(Integer.parseInt(req.getParameter("age")));
                repo.addNewStudent(NewStudent);
                break;

            case "delete":
                int deleteId = Integer.parseInt(req.getParameter("id"));
                repo.deleteStudent(deleteId);
                break;

            case "update":
                int updateId = Integer.parseInt(req.getParameter("id"));
                StudentModel UpdatedStudent = new StudentModel();
                UpdatedStudent.setName(req.getParameter("name"));
                UpdatedStudent.setAge(Integer.parseInt(req.getParameter("age")));
                repo.updateStudent(updateId, UpdatedStudent);
                break;
        }

        resp.sendRedirect("students");
    }
}