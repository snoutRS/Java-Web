package xyz;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "Servlet2", value = "/Servlet2")
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random random = new Random();
        String [] name1 = {"aa1","bb1","cc1","dd1"};
        int j = random.nextInt(name1.length);
        request.setAttribute("name",name1[j]);
        request.getRequestDispatcher("index1.jsp").forward(request,response);
    }
}
