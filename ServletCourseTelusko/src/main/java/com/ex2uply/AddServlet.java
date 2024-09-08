package com.ex2uply;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


@WebServlet("/add")
public class AddServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        Scanner a  = new Scanner(System.in);

        if (num1 == null || num2 == null) {
            // Handling null values
            res.getWriter().println("Error: Please enter both numbers.");
            return;
        }

        try {
            int i = Integer.parseInt(num1);
            int j = Integer.parseInt(num2);
            int k = i + j;
            Cookie cookie = new Cookie("k",k+"");
            res.addCookie(cookie);

            res.sendRedirect("square");


            //through session management connecting two servlets
//            HttpSession session = req.getSession();
//            session.setAttribute("k",k);
//            session.removeAttribute("k");


             //Calling a servlet from  a servlet using sendRedirect;
//            res.sendRedirect("square?k="+k);          //server is sending a response to the client to go to the mentioned servlet here with data feed to it
            //concept  used above is url rewriting (inefficient)
            //other two more ways are session and cookies;


            //Calling a servlet from a servlet using requestDispatcher;
//            RequestDispatcher rd = req.getRequestDispatcher("square");
//            req.setAttribute("k",k);
//            rd.forward(req,res);
//            res.getWriter().println("Result: " + k);


        }


        catch (NumberFormatException e) {
            res.getWriter().println("Error: Please enter valid integers.");
        }
    }
}
