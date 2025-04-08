package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import model.Student;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/student/*")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("✅ doGet called!");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String pathInfo = req.getPathInfo() == null ? "" : req.getPathInfo();

        out.println("<html><head><title>Student Management</title>");
        out.println("<link rel='stylesheet' href='/static/css/style.css'></head><body>");
        out.println("<header><h1>Student Management System</h1></header><div class='container'>");

        switch (pathInfo) {
            case "/add":
                out.println("<h2>Add Student</h2>");
                out.println("<form method='post' action='/student/add'>");
                out.println("<input type='number' name='roll' placeholder='Roll No' required>");
                out.println("<input type='text' name='enrid' placeholder='Enrollment ID' required>");
                out.println("<input type='text' name='name' placeholder='Name' required>");
                out.println("<input type='text' name='course' placeholder='Course' required>");
                out.println("<input type='text' name='contact' placeholder='Contact No' required>");
                out.println("<button type='submit'>Add Student</button>");
                out.println("</form>");
                break;

            case "/list":
                out.println("<h2>All Students</h2>");
                try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                    List<Student> students = session.createQuery("FROM Student", Student.class).list();
                    for (Student s : students) {
                        out.println("<div class='card'>");
                        out.println("<p><strong>Roll No:</strong> " + s.getRollNo() + "</p>");
                        out.println("<p><strong>Name:</strong> " + s.getName() + "</p>");
                        out.println("<p><strong>Enrollment:</strong> " + s.getEnrollmentId() + "</p>");
                        out.println("<p><strong>Course:</strong> " + s.getCourse() + "</p>");
                        out.println("<p><strong>Contact:</strong> " + s.getContact() + "</p>");
                        out.println("</div>");
                    }
                } catch (Exception e) {
                    out.println("<p>Error fetching student data: " + e.getMessage() + "</p>");
                }
                break;

            default:
                out.println("<h2>Welcome to Student Section</h2>");
                out.println("<p><a href='/student/add'>Add Student</a> | <a href='/student/list'>View Students</a></p>");
        }

        out.println("</div></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String pathInfo = req.getPathInfo();

        if ("/add".equals(pathInfo)) {
            try {
                int roll = Integer.parseInt(req.getParameter("roll"));
                String enrid = req.getParameter("enrid");
                String name = req.getParameter("name");
                String course = req.getParameter("course");
                String contact = req.getParameter("contact");

                if (enrid == null || name == null || course == null || contact == null) {
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "All fields are required.");
                    return;
                }

                Student student = new Student(roll, enrid, name, course, contact);
                try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                    Transaction tx = session.beginTransaction();
                    session.persist(student);
                    tx.commit();
                }

                // Optionally, add a success message in session
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("msg", "Student added successfully!");
                resp.sendRedirect("/student/list");

            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Roll Number.");
            } catch (Exception e) {
                e.printStackTrace();
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to save student.");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Invalid POST action.");
        }
    }
}
