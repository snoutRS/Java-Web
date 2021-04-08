import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(name = "Servlet1", value = "/Servlet1")
public class ListBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Collection<Book> books = BookDB.getAll();
        out.println("本站提供图书有：</br>");
        for(Book book: books){
            String url = "/cookie_war_exploded/Servlet3?id="+book.getId();
            out.write(book.getName()+"<a href='"+url+"'>点击购买</a></br>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}