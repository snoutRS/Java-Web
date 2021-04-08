package xyz.snoutr;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DownManagerServlet", value = "/DownManagerServlet")
public class DownManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String referer = request.getHeader("referer");
        String sitePart = "http://"+request.getServerName();
        if(referer!=null && referer.startsWith(sitePart)){
            out.println("loading>>>>>>>>>>");
        }else {
            out.println("非法访问");
            response.setHeader("Refresh","5;URL=/s1/download.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
