package com.tulun.web.controller;

import com.tulun.bean.Admin0;
import com.tulun.service.Admin0Service;
import com.tulun.service.serviceimpl.Admin0ServiceImpl;

/**
 * description：
 *
 * @author ajie
 * data 2018/12/10 18:15
 */
public class Admin0Controller {
    private Admin0Service admin;

    public Admin0Controller(){
        admin = new Admin0ServiceImpl();
    }

    public void add(Admin0 a) {
        admin.addAdmin0(a);
    }

    public Admin0 query(String name){
        return admin.queryAdmin0ByName(name);
    }

    public void remove(Admin0 a){
        admin.removeAddmin0ByName(a);
    }

    public void modify(Admin0 a){
        admin.modifyAdmin0ByName(a);
    }

}
