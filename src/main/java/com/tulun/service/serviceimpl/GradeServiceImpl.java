package com.tulun.service.serviceimpl;

import com.tulun.bean.Grade;
import com.tulun.dao.GradeMapper;
import com.tulun.service.GradeService;
import com.tulun.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * description：
 *
 * @author ajie
 * data 2018/12/11 9:21
 */
public class GradeServiceImpl implements GradeService {
    @Override
    public Grade getGrade(String name) {
        SqlSession session = MyBatisUtils.getSession();
        try {
            GradeMapper cm = session.getMapper(GradeMapper.class);
            return cm.getGradeByName(name);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addGrade(Grade g) {
        SqlSession session = MyBatisUtils.getSession();
        try {
            GradeMapper cm = session.getMapper(GradeMapper.class);
            cm.insert(g);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Grade queryStudentById(Integer id) {
        Grade grade;
        try (SqlSession session = MyBatisUtils.getSession()) {
            GradeMapper cm = session.getMapper(GradeMapper.class);
            grade = cm.selectByPrimaryKey(id);
            return grade;
        }
    }

    @Override
    public void removeGradeByName(Grade g) {
        SqlSession session = MyBatisUtils.getSession();
        try {
            GradeMapper cm = session.getMapper(GradeMapper.class);
            cm.deleteByPrimaryKey(g.getId());
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void modifyGradeByName(Grade g) {
        SqlSession session = MyBatisUtils.getSession();
        try {
            GradeMapper cm = session.getMapper(GradeMapper.class);
            cm.updateByPrimaryKey(g);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public int getGradeNumber() {
        SqlSession session = MyBatisUtils.getSession();
        try {
            GradeMapper cm = session.getMapper(GradeMapper.class);
            return cm.getGradeNumber();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void removeGradeById(Integer id) {
        SqlSession session = MyBatisUtils.getSession();
        try {
            GradeMapper cm = session.getMapper(GradeMapper.class);
            cm.deleteByPrimaryKey(id);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
    }
}
