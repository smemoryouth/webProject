package com.tulun.web.servlet;

import com.tulun.bean.Clazz;
import com.tulun.web.controller.ClazzController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * description：
 *
 * @author ajie
 * data 2018/12/12 10:50
 */
@WebServlet(name = "ClazzServlet", urlPatterns = "/clazzlist")
public class ClazzServlet extends BaseServlet {
    private Map<Integer, Clazz> clazzMap = new ConcurrentHashMap<>();

    public ClazzServlet() {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request = showClazz(request, response);
        request.getRequestDispatcher("clazzShow.jsp").forward(request, response);
    }

    public HttpServletRequest showClazz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClazzController cc = new ClazzController();
        int size = cc.quert();
        for (int i = 0; i < size; i++) {
            Clazz clazz = cc.query(i + 1);
            if (clazz == null) {
                size++;
            } else {
                clazzMap.put(i + 1, clazz);
            }
        }
        request.setAttribute("clazzs", clazzMap);
        return request;
    }

    public void modClazz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("cid"));
        Clazz clazz = clazzMap.get(id);
        request.setAttribute("clazz", clazz);
        request.getRequestDispatcher("modifyClazz.jsp").forward(request, response);
    }

    public void modifyClazz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("cid"));
        String c_name = request.getParameter("c_name");
        String c_teacher = request.getParameter("c_teacher");
        Integer c_s_number = Integer.valueOf(request.getParameter("c_s_number"));
        String c_extra = request.getParameter("c_extra");
        ClazzController cc = new ClazzController();
        Clazz clazz = new Clazz(id, c_name, c_teacher, c_s_number, c_extra);
        cc.modify(clazz);
        response.sendRedirect("clazzlist");
    }

    public void addClazz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addClazzs.jsp").forward(request, response);
    }

    /**
     * 增加班级
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addClazzs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("cid"));
        String c_name = request.getParameter("c_name");
        String c_teacher = request.getParameter("c_teacher");
        Integer c_s_number = Integer.valueOf(request.getParameter("c_s_number"));
        String c_extra = request.getParameter("c_extra");

        if (clazzMap.containsKey(id)) {
            request.setAttribute("error", "班号已存在");
            response.sendRedirect("clazzlist");
            return;
        }
        ClazzController cc = new ClazzController();
        Clazz clazz = new Clazz(id, c_name, c_teacher, c_s_number, c_extra);
        cc.add(clazz);
        clazzMap.clear();
        response.sendRedirect("clazzlist");

    }

    public void delClazz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("cid"));
        ClazzController cc = new ClazzController();
        cc.remove(id);
        clazzMap.clear();
        response.sendRedirect("clazzlist");
    }
}
