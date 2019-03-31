package com.tulun.web.servlet;

import com.tulun.bean.Grade;
import com.tulun.web.controller.GradeController;

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
 * data 2018/12/12 12:21
 */
@WebServlet(name = "GradeServlet", urlPatterns = "/gradelist")
public class GradeServlet extends BaseServlet {
    private Map<Integer, Grade> gradeMap = new ConcurrentHashMap<>();

    public GradeServlet() {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request = showGrade(request, response);
        request.getRequestDispatcher("gradeShow.jsp").forward(request, response);
    }

    /**
     * 学生页面的显示
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public HttpServletRequest showGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GradeController gt = new GradeController();
        int size = gt.quert();
        for (int i = 0; i < size; i++) {
            Grade grade = gt.query(i + 1);
            if (gradeMap == null) {
                size++;
            } else {
                gradeMap.put(i + 1, grade);
            }
        }
        request.setAttribute("grades", gradeMap);
        return request;
    }

    /**
     * 修改学生的请求
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void modGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("gid"));
        Grade grade = gradeMap.get(id);
        request.setAttribute("grade", grade);
        // 修改页面的跳转，服务器转发
        request.getRequestDispatcher("modifyGrade.jsp").forward(request, response);
    }

    /**
     * 修改学生的实现
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void modifyGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("gid"));
        String name = request.getParameter("name");
        String teacher_name = request.getParameter("teacher_name");
        String student_name = request.getParameter("student_name");
        Double record = Double.parseDouble(request.getParameter("record"));
        Grade grade = new Grade(id, name, teacher_name, student_name, record);
        GradeController gc = new GradeController();
        gc.modify(grade);
        response.sendRedirect("gradelist");
    }

    public void addGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addGrades.jsp").forward(request, response);
    }

    /**
     * 增加学生
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addGrades(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("gid"));
        String name = request.getParameter("name");
        String teacher_name = request.getParameter("teacher_name");
        String student_name = request.getParameter("student_name");
        Double record = Double.parseDouble(request.getParameter("record"));
        if (gradeMap.containsKey(id)) {
            request.setAttribute("error", "成绩标号已存在");
            response.sendRedirect("gradelist");
            return;
        }
        Grade grade = new Grade(id, name, teacher_name, student_name, record);
        GradeController gc = new GradeController();
        gc.add(grade);
        gradeMap.clear();
        response.sendRedirect("gradelist");

    }

    /**
     * 删除成绩
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void delGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("gid"));
        GradeController gc = new GradeController();
        gc.remove(id);
        gradeMap.clear();
        response.sendRedirect("gradelist");

    }
}
