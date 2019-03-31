package com.tulun.constant;

import com.tulun.bean.Admin0;
import com.tulun.bean.Student;
import com.tulun.dao.StudentMapper;
import com.tulun.util.MyBatisUtils;
import com.tulun.web.controller.Admin0Controller;
import com.tulun.web.controller.ClazzController;
import com.tulun.web.controller.StudentController;
import com.tulun.web.controller.TeacherController;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

/**
 * description：
 *
 * @author ajie
 * data 2018/12/10 13:50
 */
class ConnectionTest {
    @Test
    void test(){
        Admin0Controller admin = new Admin0Controller();
        Admin0 admin0 = admin.query("123");
        System.out.println(admin0);
    }
    @Test
    void test1(){
        TeacherController teacher = new TeacherController();
        int b = teacher.quert();
        System.out.println(b);
    }

    @Test
    void test2(){
        StudentController student = new StudentController();
        int b = student.quert();
        System.out.println(b);
    }

    @Test
    void test3(){
        ClazzController clazz = new ClazzController();
        clazz.quert();

    }
}
