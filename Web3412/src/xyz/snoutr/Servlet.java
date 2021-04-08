package xyz.snoutr;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("username");
        String [] target = request.getParameterValues("target");
        out.print(name+"，你期望的春游目的地是");
        for (int i = 0;i<target.length;i++){
            out.print(" "+target[i]+",");
        }
    }

}
