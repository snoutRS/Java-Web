package xyz;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Random random = new Random();
        String [] names = {"aaa","bbb","ccc","ddd"};
        int i = random.nextInt(names.length);
        request.setAttribute("name",names[i]);
        request.getRequestDispatcher("index1.jsp").forward(request,response);
    }
}
