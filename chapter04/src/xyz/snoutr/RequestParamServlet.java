package xyz.snoutr;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RequestParamServlet", value = "/RequestParamServlet")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("psw");
        System.out.println("username"+username);
        out.println("username"+username);
        System.out.println("psw"+password);
        out.println("psw"+password);

        String [] hobbys = request.getParameterValues("hobby");
        System.out.println("hobby");
        out.println("hobby");
        for (int i = 0;i<hobbys.length;i++){
            System.out.println(hobbys[i]+",");
            out.println(hobbys[i]+",");
        }
    }
}
