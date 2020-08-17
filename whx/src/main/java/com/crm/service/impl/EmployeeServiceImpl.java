package com.crm.service.impl;


import com.crm.domain.Employee;
import com.crm.mapper.EmployeeMapper;
import com.crm.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类描述信息 员工业务层
 *
 * @author wuhx
 * @ClassName EmployeeServiceImpl
 * @date 2020/03/02 11:33
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    //注入mapper
    @Autowired
    private EmployeeMapper mapper;

    /**
     * 删除员工信息
     *
     * @param id key值
     * @return 返回结果
     */
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    /**
     * 新增员工信息
     *
     * @param record 员工对象
     * @return 返回结果
     */
    public int insert(Employee record) {
        if (record != null) {
            return mapper.insert(record);
        }
        return 0;

    }

    /**
     * 查询员工信息
     *
     * @param id key值
     * @return 返回结果
     */
    public Employee selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 插叙所有员工信息
     *
     * @return 返回结果
     */
    public List<Employee> selectAll() {
        return mapper.selectAll();
    }

    /**
     * 更新员工信息
     *
     * @param record 员工对象
     * @return 返回结果
     */
    public int updateByPrimaryKey(Employee record) {
        return mapper.updateByPrimaryKey(record);
    }

    /**
     * 查询登录对象信息
     *
     * @param loginname 登录名
     * @param password 密码
     * @return 返回结果
     */
    public Employee selectForLogin(String loginname, String password) {
        return mapper.selectForLogin(loginname, password);
    }

    /**
     * 查询员工信息:by name
     *
     * @param name key值
     * @return 返回结果
     */
    public String selectEmploy(String name){
        return mapper.selectEmploy(name);
    }
}
