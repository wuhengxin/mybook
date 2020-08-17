package com.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/**
 * @program: CRM
 * @description： BorrowBook实体类
 * @author: wuhx
 * @create: 2020-08-10 09:26
 **/
public class BorrowBook {

    /**
     * 借书记录id
     */
    private Long id;

    /**
     * 所借图书数量
     */
    private Long account;

    /**
     * 租借状态，1为借用，0为归还
     */
    private Integer state;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date completionTime;

    private Books books;

    private Employee employee;

    @Override
    public String toString() {
        return "Borrow_book{" +
                "id=" + id +
                ", account=" + account +
                ", state=" + state +
                ", createTime=" + createTime +
                ", completionTime=" + completionTime +
                ", books=" + books +
                ", employee=" + employee +
                '}';
    }

    public BorrowBook(Long id, Long account, Integer state,  Books books, Employee employee) {
        this.id = id;
        this.account = account;
        this.state = state;
        this.books = books;
        this.employee = employee;
    }

    public BorrowBook() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(Date completionTime) {
        this.completionTime = completionTime;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
