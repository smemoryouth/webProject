package com.tulun.dao;

import com.tulun.bean.Grade;

public interface GradeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);
    Grade getGradeByName(String name);
    int getGradeNumber();
}