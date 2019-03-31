package com.tulun.web.filter;

import com.tulun.bean.Admin0;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * description：
 *
 * @author ajie
 * data 2018/12/9 20:33
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String url = request.getRequestURI();
        HttpSession session = request.getSession();
        Admin0 admin = (Admin0) session.getAttribute("admin");
        String contextPath = request.getServletContext().getContextPath();
        if(url.endsWith(".css") || url.endsWith(".js")
                || url.endsWith(".jpg")
                || url.endsWith(".ico")){
            chain.doFilter(req, resp);
            return;
        }
        if (admin == null) {
            if(!url.contains("/login")){
                response.sendRedirect(contextPath + "/login");
            }else{
                chain.doFilter(req, resp);
            }
        } else {
            if(url.contains( contextPath + "/login")){
                System.out.println("密码验证通过");
                response.sendRedirect(contextPath + "/main");
            } else{
                chain.doFilter(req, resp);
            }
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }
}
