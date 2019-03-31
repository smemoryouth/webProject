package com.tulun.bean;

import java.io.Serializable;

public class Grade implements Serializable {
    /* */
    private Integer id;

    /* */
    private String name;

    /* */
    private String teacher_name;

    /* */
    private String student_name;

    private Double record;

    private static final long serialVersionUID = 1L;
    public Grade(){}



    public Grade(Integer id, String name, String teacher_name, String student_name, Double record) {
        this.id = id;
        this.name = name;
        this.teacher_name = teacher_name;
        this.student_name = student_name;
        this.record = record;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
    public Double getRecord() {
        return record;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", teacher_name=").append(teacher_name);
        sb.append(", student_name=").append(student_name);
        sb.append(", record  =").append(record);
        sb.append("]");
        return sb.toString();
    }
}