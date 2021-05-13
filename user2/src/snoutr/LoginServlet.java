package snoutr;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if("itcast".equals(username) && "123456".equals(password)){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            request.getSession().setAttribute("user",user);
            String autoLoging = request.getParameter("autologing");
            if(autoLoging != null){
                Cookie cookie = new Cookie("autoLogin",username+"-" + password);
                cookie.setMaxAge(Integer.parseInt(autoLoging));
                response.addCookie(cookie);
            }
            response.sendRedirect(request.getContextPath()+"index,jsp");
        }else {
            request.setAttribute("errorMsg","用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
