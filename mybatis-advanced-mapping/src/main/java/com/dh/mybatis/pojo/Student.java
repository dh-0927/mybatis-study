package com.dh.mybatis.pojo;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer sid;
    private String sname;

    private Integer cid;

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", cid=" + cid +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Student() {
    }

    public Student(Integer sid, String sname) {
        this.sid = sid;
        this.sname = sname;
    }
}
