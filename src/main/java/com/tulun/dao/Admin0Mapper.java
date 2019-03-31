package com.tulun.dao;

import com.tulun.bean.Admin0;

public interface Admin0Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin0 record);

    int insertSelective(Admin0 record);

    Admin0 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin0 record);

    int updateByPrimaryKey(Admin0 record);

    Admin0 selectByName(String name);
}