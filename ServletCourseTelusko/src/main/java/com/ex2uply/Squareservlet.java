package com.ex2uply;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/square")
public class Squareservlet extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
            Cookie[] cookies = req.getCookies();          //clients sends all the cookies it has to the server(!!!)
        int k = 0;
        for(var c: cookies){
                if(c.getName().equals("k")){
                     k= Integer.parseInt(c.getValue());
                }
             }
        k *= k;
        PrintWriter out = res.getWriter();
//        out.println(k);
        
//        HttpSession session = req.getSession();
//        int k = (int)session.getAttribute("k");
//        k *=k;





        out.println("Result is: " + k);          //way to give response to client or in other words show output of server on clients browser
//        System.out.println("square called");
    }
}
