import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Servlet2", value = "/Servlet2")
public class cartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        List<Book> cart = null;
        boolean purFlag = true;
        HttpSession session = request.getSession(false);
        if (session == null){
            purFlag = false;
        }else {
            cart = (List) session.getAttribute("cart");
            if(cart == null){
                purFlag = false;
            }
        }
        if (!purFlag){
            out.write("对不起，你还没购买任何商品");
        }else {
            out.write("您购买的商品有：<br/>");
            double price = 0;
            for (Book book : cart){
                out.write(book.getName()+"<br/>");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}