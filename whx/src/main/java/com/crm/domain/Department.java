package com.crm.domain;

/**
 * @program: CRM
 * @description： Department实体类
 * @author: wuhx
 * @create: 2020-08-10 09:26
 **/
public class Department {
    /**
     * 部门id
     */
    private Long id;

    /**
     * 部门名称
     */
    private String deptname;

    /**
     * 部门相关描述信息
     */
    private String deptmsg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    public String getDeptmsg() {
        return deptmsg;
    }

    public void setDeptmsg(String deptmsg) {
        this.deptmsg = deptmsg == null ? null : deptmsg.trim();
    }


    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptname='" + deptname + '\'' +
                ", deptmsg='" + deptmsg + '\'' +
                '}';
    }
}