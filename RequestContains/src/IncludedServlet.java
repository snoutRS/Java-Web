import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "IncludedServlet", value = "/IncludedServlet")
public class IncludedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("中国" + "<br />");
        out.println("URL:" + request.getRequestURI() +"<br />");
        out.println("QueryString" + request.getQueryString() +"<br />");
        out.println("parameter p1:" + request.getParameter("p1") +"<br />");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
