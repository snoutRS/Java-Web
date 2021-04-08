import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet3", value = "/Servlet3")
public class purchBookServlet extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        out.println(id);
        if (id == null){
            String url = "/cookie_war_exploded/Servlet1";
            response.sendRedirect(url);
            return;
        }
        Book book = BookDB.getBook(id);
        HttpSession session = request.getSession();
        List<Book> cart = (List) session.getAttribute("cart");
        if(cart == null){
            cart = new ArrayList<Book>();
            session.setAttribute("cart",cart);
        }
        cart.add(book);
        Cookie cookie = new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(60*30);
        cookie.setPath("/cookie_war_exploded");
        response.addCookie(cookie);
        String url = "/cookie_war_exploded/Servlet2";
        response.sendRedirect(url);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}