package com.ex2uply;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/context")
public class ServletConfigandContext extends HttpServlet  {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        PrintWriter out = res.getWriter();
        out.println("HI");
        //fetching a predefined value from servlet;
        ServletContext context = getServletContext();
        String str = context.getInitParameter("name");
        out.println(str);

        ServletConfig cfg = getServletConfig();
        String str2 = cfg.getInitParameter("name");
        out.println(str2);
    }
}
