package com.tulun.service.serviceimpl;

import com.tulun.bean.Student;
import com.tulun.dao.StudentMapper;
import com.tulun.service.StudentService;
import com.tulun.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * description：
 *
 * @author ajie
 * data 2018/12/10 23:56
 */
public class StudentServiceImpl implements StudentService {
    @Override
    public void addStudent(Student s) {
        SqlSession session = MyBatisUtils.getSession();
        try {
            StudentMapper sm = session.getMapper(StudentMapper.class);
            sm.insert(s);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Student queryStudentById(Integer id) {
        Student student;
        try (SqlSession session = MyBatisUtils.getSession()) {
            StudentMapper tm = session.getMapper(StudentMapper.class);
            student = tm.selectByPrimaryKey(id);
            return student;
        }
    }

    @Override
    public Student queryStudentByName(String name) {
        return null;
    }

    @Override
    public void removeStudentByName(Student s) {
        SqlSession session = MyBatisUtils.getSession();
        try {
            StudentMapper tm = session.getMapper(StudentMapper.class);
            tm.deleteByPrimaryKey(s.getId());
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void modifyStudentByName(Student s) {
        SqlSession session = MyBatisUtils.getSession();
        try {
            StudentMapper tm = session.getMapper(StudentMapper.class);
            System.out.println("更新数据库 + " + tm.updateByPrimaryKey(s));
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public int getStudentNumber() {
        SqlSession session = MyBatisUtils.getSession();
        try {
            StudentMapper sm = session.getMapper(StudentMapper.class);
            return sm.getStudentNum();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void removeStudentById(Integer id) {
        SqlSession session = MyBatisUtils.getSession();
        try {
            StudentMapper tm = session.getMapper(StudentMapper.class);
            tm.deleteByPrimaryKey(id);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
    }
}
