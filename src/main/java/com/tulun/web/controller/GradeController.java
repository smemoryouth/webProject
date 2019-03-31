package com.tulun.web.controller;

import com.tulun.bean.Grade;
import com.tulun.bean.Student;
import com.tulun.service.GradeService;
import com.tulun.service.serviceimpl.GradeServiceImpl;

/**
 * description：
 *
 * @author ajie
 * data 2018/12/11 9:24
 */
public class GradeController {
    GradeService gs;
    public GradeController(){
        this.gs = new GradeServiceImpl();
    }

    public Grade getGrade(String name){
        return gs.getGrade(name);
    }

    public int quert() {
        return gs.getGradeNumber();
    }

    public Grade query(Integer i) {
        return gs.queryStudentById(i);
    }

    public void modify(Grade grade) {
        gs.modifyGradeByName(grade);
    }

    public void add(Grade grade) {
        gs.addGrade(grade);
    }

    public void remove(Integer id) {
        gs.removeGradeById(id);
    }
}
