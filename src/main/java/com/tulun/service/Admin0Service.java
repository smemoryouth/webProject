package com.tulun.service;

import com.tulun.bean.Admin0;

/**
 * description：
 *
 * @author ajie
 * data 2018/12/10 18:08
 */
public interface Admin0Service {

    void addAdmin0(Admin0 a);

    Admin0 queryAdmin0ByName(String name);

    void removeAddmin0ByName(Admin0 a);

    void modifyAdmin0ByName(Admin0 a);
}
