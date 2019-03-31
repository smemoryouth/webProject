package com.tulun.service.serviceimpl;

import com.tulun.bean.Admin0;
import com.tulun.dao.Admin0Mapper;
import com.tulun.service.Admin0Service;
import com.tulun.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * description：
 *
 * @author ajie
 * data 2018/12/10 18:08
 */
public class Admin0ServiceImpl implements Admin0Service {

    @Override
    public void addAdmin0(Admin0 a) {
        SqlSession session = MyBatisUtils.getSession();
        try {
            Admin0Mapper am = session.getMapper(Admin0Mapper.class);
            am.insert(a);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Admin0 queryAdmin0ByName(String name) {
        Admin0 admin0;
        try (SqlSession session = MyBatisUtils.getSession()) {
            Admin0Mapper am = session.getMapper(Admin0Mapper.class);
            admin0 = am.selectByName(name);
            return admin0;
        }
    }

    @Override
    public void removeAddmin0ByName(Admin0 a) {

    }

    @Override
    public void modifyAdmin0ByName(Admin0 a) {

    }
}
