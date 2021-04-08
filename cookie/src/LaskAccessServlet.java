import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

@WebServlet(name = "LaskAccessServlet", value = "/LaskAccessServlet")
public class LaskAccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        Cookie cookie = new Cookie("name", name);
        cookie.setMaxAge(1000);
        response.addCookie(cookie);

        out.println("name:" + name);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
