        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.*;
        import java.io.IOException;
        import java.io.PrintWriter;
        import java.util.ArrayList;
        import java.util.List;

@WebServlet(name = "IndexServlet", value = "/IndexServlet")
public class IndexServlet extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
       HttpSession session = request.getSession();
       User user = (User) session.getAttribute("user");
       if (user == null){
           response.getWriter().print();
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}