package com.servlets;

import com.entities.Note;
import com.helper.FactoryProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/saveNotes")
public class saveNotesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Session s = null;
        Transaction tx = null;
        try {
            String title = request.getParameter("title");
            String content = request.getParameter("content");

            // Ensure title and content are not null or empty
            if (title == null || title.trim().isEmpty() || content == null || content.trim().isEmpty()) {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<h1 style='text-align:center;'>Title or Content cannot be empty!</h1>");
                return;
            }

            // Create note object
            Note note = new Note(new Date(), content, title);

            // Open session and begin transaction
            s = FactoryProvider.getFactory().openSession();
            tx = s.beginTransaction();
            s.save(note);
            tx.commit();

            // Respond with success message
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1 style='text-align:center;' font-style='Arial'>Note is added successfully</h1>");
            out.println("<h1 style='text-align:center;'><a href='all_notes.jsp'>View all notes</a></h1>");
        } catch (Exception e) {
            if (tx != null) tx.rollback();  // Rollback transaction in case of error
            e.printStackTrace();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1 style='text-align:center;'>Something went wrong! Please try again.</h1>");
        } finally {
            if (s != null) s.close();  // Ensure session is closed
        }
    }
}
