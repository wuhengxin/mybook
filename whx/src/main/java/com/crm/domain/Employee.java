package com.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: CRM
 * @description: Employee实体类
 * @author: wuhx
 * @create: 2020-08-10 09:26
 **/
public class Employee {

    /**
     * 员工id
     */
    private Long id;

    /**
     *员工姓名
     */
    private String name;

    /**
     *性别
     */
    private String sex;

    /**
     *电话号码
     */
    private String phone;

    /**
     *邮箱
     */
    private String email;

    /**
     *职位id
     */
    private Position positionId;

    /**
     *毕业院校
     */
    private String eduschool;

    /**
     *省份证号
     */
    private String idcard;

    /**
     *所属部门id
     */
    private Department deptId;

    /**
     *地址
     */
    private String address;

    /**
     *密码
     */
    private String password;

    /**
     *登录用户名
     */
    private String loginname;

    /**
     *账号状态
     */
    private Integer state;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT")
    private Date createtime;


    public Employee() {
    }

    public Employee(String name, String sex, String phone, String email, Position positionId, String eduschool, String idcard, Department deptId, String address, String password, String loginname, Integer state) {
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.positionId = positionId;
        this.eduschool = eduschool;
        this.idcard = idcard;
        this.deptId = deptId;
        this.address = address;
        this.password = password;
        this.loginname = loginname;
        this.state = state;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Position getPositionId() {
        return positionId;
    }

    public void setPositionId(Position positionId) {
        this.positionId = positionId;
    }

    public Department getDeptId() {
        return deptId;
    }

    public void setDeptId(Department deptId) {
        this.deptId = deptId;
    }

    public String getEduschool() {
        return eduschool;
    }

    public void setEduschool(String eduschool) {
        this.eduschool = eduschool == null ? null : eduschool.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", positionId=" + positionId +
                ", eduschool='" + eduschool + '\'' +
                ", idcard='" + idcard + '\'' +
                ", deptId=" + deptId +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", username='" + loginname + '\'' +
                ", state=" + state +
                ", createtime=" + createtime +
                '}';
    }
}