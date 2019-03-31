package com.tulun.bean;

import java.io.Serializable;

public class Admin0 implements Serializable {
    /* */
    private Integer id;

    /* */
    private String name;

    /* */
    private String password;

    /* */
    private Integer level;

    private static final long serialVersionUID = 1L;

    public Admin0(){}
    public Admin0(String name, String password, Integer level) {
        this.name = name;
        this.password = password;
        this.level = level;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append(", level=").append(level);
        sb.append("]");
        return sb.toString();
    }
}