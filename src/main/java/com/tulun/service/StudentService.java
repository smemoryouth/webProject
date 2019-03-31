package com.tulun.service;

import com.tulun.bean.Student;

/**
 * description：
 *
 * @author ajie
 * data 2018/12/9 20:39
 */
public interface StudentService {
    void addStudent(Student s);

    Student queryStudentById(Integer id);

    Student queryStudentByName(String name);

    void removeStudentByName(Student s);

    void modifyStudentByName(Student s);

    int getStudentNumber();

    void removeStudentById(Integer id);
}
