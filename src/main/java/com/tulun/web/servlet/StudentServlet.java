package com.tulun.web.servlet;

import com.tulun.bean.Student;
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
 * data 2018/12/12 10:48
 */
@WebServlet(name = "StudentServlet", urlPatterns = "/studentlist")
public class StudentServlet extends BaseServlet {
    private Map<Integer, Student> studentMap = new ConcurrentHashMap<>();

    public StudentServlet() {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request = showStudent(request, response);
        request.getRequestDispatcher("studentShow.jsp").forward(request, response);
    }

    /**
     * 学生页面的显示
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public HttpServletRequest showStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentController st = new StudentController();
        int size = st.quert();
        for (int i = 0; i < size; i++) {
            Student student = st.query(i + 1);
            if (student == null) {
                size++;
            } else {
                studentMap.put(i + 1, student);
            }
        }
        request.setAttribute("students", studentMap);
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
    public void modStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("sid"));
        Student student = studentMap.get(id);
        request.setAttribute("student", student);
        // 修改页面的跳转，服务器转发
        request.getRequestDispatcher("modifyStudent.jsp").forward(request, response);
    }

    /**
     * 修改学生的实现
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void modifyStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("sid"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        Integer age = Integer.valueOf(request.getParameter("age"));
        Integer c_id = Integer.valueOf(request.getParameter("c_id"));
        String extra = request.getParameter("s_extra");

        Student student = new Student(id, name, sex, age, c_id, extra);
        StudentController sc = new StudentController();
        sc.modify(student);
        response.sendRedirect("studentlist");
    }

    public void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addStudents.jsp").forward(request, response);
    }

    /**
     * 增加学生
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("sid"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        Integer age = Integer.valueOf(request.getParameter("age"));
        Integer c_id = Integer.valueOf(request.getParameter("c_id"));
        String extra = request.getParameter("s_extra");
        if (studentMap.containsKey(id)) {
            request.setAttribute("error", "学号已存在");
            response.sendRedirect("studentlist");
            return;
        }
        Student student = new Student(id, name, sex, age, c_id, extra);
        StudentController sc = new StudentController();
        sc.add(student);
        studentMap.clear();
        response.sendRedirect("studentlist");
    }

    /**
     * 删除学生
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void delStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("sid"));
        StudentController sc = new StudentController();
        sc.remove(id);
        studentMap.clear();
        response.sendRedirect("studentlist");
    }
}
