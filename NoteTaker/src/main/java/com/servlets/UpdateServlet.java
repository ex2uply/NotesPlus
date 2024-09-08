package com.servlets;

import com.entities.Note;
import com.helper.FactoryProvider;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

@WebServlet("/updateservlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        try{
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            Integer id = Integer.parseInt(request.getParameter("noteID"));
            Session s = FactoryProvider.getFactory().openSession();
            Transaction tx = s.beginTransaction();

            Note note = s.get(Note.class,id);

            note.setContent(content);
            note.setTitle(title);
            note.setAddedDate(new Date());
            tx.commit();
            s.close();
            response.sendRedirect("all_notes.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
