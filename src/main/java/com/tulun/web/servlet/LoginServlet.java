package com.tulun.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tulun.bean.Admin0;
import com.tulun.web.controller.Admin0Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * description：
 *
 * @author ajie
 * data 2018/12/9 20:18
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends BaseServlet {

    public LoginServlet() {
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //以字符串形式返回请求参数的值，或者如果参数不存在则返回 null。
        String name = req.getParameter("name");
        System.out.println("name是" + name);
        String password = req.getParameter("pwd");
        System.out.println("密码是：" + password);

        HttpSession session = req.getSession();

        Admin0Controller admin = new Admin0Controller();
        Admin0 admin0 = admin.query(name);

        if (admin0.getPassword().equals(password)) {
            // 登录成功  客户端转发
            session.setAttribute("admin", admin0);
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode node = mapper.createObjectNode();
            node.put("code", 200);
            node.put("url", "/main");
            // {code:200, url:/main}
            resp.getWriter().println(node.toString());
            return;
        }

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("code", 100);

        // error
        resp.getWriter().println(node.toString());
    }
}
