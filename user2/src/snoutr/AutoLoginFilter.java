package snoutr;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "MyFilter",urlPatterns = "/*")
public class AutoLoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        Cookie[] cookies = httpServletRequest.getCookies();
        String autologin = null;
        for (int i =0;cookies!=null&&i<cookies.length;i++){
            if("autologin".equals(cookies[i].getName())){
                autologin=cookies[i].getValue();
                break;
            }
        }
        if(autologin!=null){
            String[] parts = autologin.split("-");
            String username = parts[0];
            String password = parts[1];
            if("itcast".equals(username) && "123456".equals(password)) {
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                httpServletRequest.getSession().setAttribute("user", user);
            }
        }
        chain.doFilter(request,response);
    }
}
