package com.tulun.web.servlet;

import com.tulun.bean.Clazz;
import com.tulun.bean.Grade;
import com.tulun.bean.Student;
import com.tulun.bean.Teacher;
import com.tulun.web.controller.ClazzController;
import com.tulun.web.controller.StudentController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * description：
 *
 * @author ajie
 * data 2018/12/9 21:43
 */
@WebServlet(name = "MainServlet", urlPatterns = "/main")
public class MainServlet extends BaseServlet {
    public MainServlet() {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }

}
