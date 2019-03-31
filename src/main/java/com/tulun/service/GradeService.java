package com.tulun.service;

import com.tulun.bean.Grade;

/**
 * description：
 *
 * @author ajie
 * data 2018/12/9 20:40
 */
public interface GradeService {

    Grade getGrade(String name);

    void addGrade(Grade g);

    Grade queryStudentById(Integer id);
    void removeGradeByName(Grade g);

    void modifyGradeByName(Grade g);
    int getGradeNumber();
    void removeGradeById(Integer id);
}
