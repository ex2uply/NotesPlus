package servlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/first")
public class FirstServlet implements Servlet {
    private ServletConfig serfConfig;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.serfConfig = servletConfig;
        System.out.println("Initializing Servlet");
    }
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Service Request");
    }

    @Override
    public void destroy() {
        System.out.println("Destroying Servlet");
    }

    //non lifecycle methods
    @Override
    public ServletConfig getServletConfig() {
        return this.serfConfig;
    }

    @Override
    public String getServletInfo() {
        return "This Servlet was created by Adi";
    }
}
