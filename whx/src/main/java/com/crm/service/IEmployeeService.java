package com.crm.service;


import com.crm.domain.Employee;

import java.util.List;

/**
 * @program: CRM
 * @description: IEmployeeService
 * @author: wuhx
 * @create: 2020-08-10 09:26
 **/
public interface IEmployeeService {

    /**
     * 删除员工信息
     *
     * @param id key值
     * @return 返回结果
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 新增员工信息
     *
     * @param record 员工对象
     * @return 返回结果
     */
    int insert(Employee record);

    /**
     * 查询员工信息
     *
     * @param id key值
     * @return 返回结果
     */
    Employee selectByPrimaryKey(Long id);

    /**
     * 插叙所有员工信息
     *
     * @return 返回结果
     */
    List<Employee> selectAll();

    /**
     * 更新员工信息
     *
     * @param record 员工对象
     * @return 返回结果
     */
    int updateByPrimaryKey(Employee record);

    /**
     * 查询登录对象信息
     *
     * @param loginname 登录名
     * @param password 密码
     * @return 返回结果
     */
    Employee selectForLogin(String loginname, String password);

    /**
     * 查询员工信息:by name
     *
     * @param name key值
     * @return 返回结果
     */
    String selectEmploy(String name);
}
