package com.tulun.web.servlet;

import com.tulun.bean.Teacher;
import com.tulun.web.controller.TeacherController;

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
 * data 2018/12/12 10:21
 */
@WebServlet(name = "TeacherServlet", urlPatterns = "/teacherlist")
public class TeacherServlet extends BaseServlet {
    private ConcurrentHashMap<Integer, Teacher> teacherMap = new ConcurrentHashMap<>();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    public TeacherServlet() {
    }

    public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request = showTeachers(request, response);
        request.getRequestDispatcher("teacherShow.jsp").forward(request, response);
    }

    public HttpServletRequest showTeachers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherController teacher = new TeacherController();
        int size = teacher.quert();
        for (int i = 0; i < size; i++) {
            Teacher teacher1 = teacher.query(i + 1);
            if (teacher1 == null) {
                size++;
            } else {
                teacherMap.put(i + 1, teacher1);
            }
        }
        request.setAttribute("teachers", teacherMap);
        return request;
    }

    /**
     * 请求修改teacher的页面
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void modTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("tid"));
        Teacher teacher = teacherMap.get(id);
        request.setAttribute("teacher", teacher);
        // 修改页面的跳转，服务器转发
        request.getRequestDispatcher("modifyTeacher.jsp").forward(request, response);
    }

    /**
     * 处理teacher数据修改
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void modifyTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("tid"));
        String name = request.getParameter("name");
        Double sal = Double.valueOf(request.getParameter("sal"));
        String sex = request.getParameter("sex");
        String extra = request.getParameter("extra");

        Teacher newTeacher = new Teacher(id, name, sex, sal, extra);
        TeacherController teacher = new TeacherController();
        teacher.modify(newTeacher);

        response.sendRedirect("teacherlist");
    }

    public void addTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addTeachers.jsp").forward(request, response);
    }

    /**
     * 增加教师
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addTeachers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("tid"));
        String name = request.getParameter("name");
        Double sal = Double.valueOf(request.getParameter("sal"));
        String sex = request.getParameter("sex");
        String extra = request.getParameter("extra");
        if (teacherMap.containsKey(id)){
            request.setAttribute("error", "工号已存在");
            response.sendRedirect("teacherlist");
            return;
        }
        Teacher newTeacher = new Teacher(id, name, sex, sal, extra);
        TeacherController teacher = new TeacherController();
        teacher.add(newTeacher);
        teacherMap.clear();
        response.sendRedirect("teacherlist");
    }

    /**
     * 处理删除teacher的逻辑
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void delTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("tid"));
        TeacherController teacher = new TeacherController();
        teacher.remove(id);
        teacherMap.clear();
        response.sendRedirect("teacherlist");
    }
}
