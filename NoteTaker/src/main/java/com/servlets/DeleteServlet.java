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

@WebServlet("/deleteservlet")
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            int noteId = Integer.parseInt(request.getParameter("id"));
            Session s = FactoryProvider.getFactory().openSession();
            Transaction tx = s.beginTransaction();
            Note note = (Note) s.get(Note.class, noteId);

            if (note != null) {
                s.delete(note);
            }
            tx.commit();
            s.close();

            // Redirect to the notes page
            response.sendRedirect("all_notes.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
