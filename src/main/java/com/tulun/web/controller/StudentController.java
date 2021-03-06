package com.tulun.web.controller;

import com.tulun.bean.Student;
import com.tulun.service.StudentService;
import com.tulun.service.serviceimpl.StudentServiceImpl;

/**
 * description：
 *
 * @author ajie
 * data 2018/12/10 23:59
 */
public class StudentController {
    private StudentService ss;

    public StudentController() {
        ss = new StudentServiceImpl();
    }

    public void add(Student s) {
        ss.addStudent(s);
    }

    public int quert() {
        return ss.getStudentNumber();
    }

    public Student query(String name) {
        return ss.queryStudentByName(name);
    }
    public Student query(Integer id) {
        return ss.queryStudentById(id);
    }

    public void remove(Student s) {
        ss.removeStudentByName(s);
    }
    public void remove(Integer id) {
        ss.removeStudentById(id);
    }

    public void modify(Student s) {
        ss.modifyStudentByName(s);
    }
}
