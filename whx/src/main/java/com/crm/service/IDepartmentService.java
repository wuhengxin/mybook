package com.crm.service;


import com.crm.domain.Department;

import java.util.List;

/**
 * @program: CRM
 * @description: IDepartmentService
 * @author: wuhx
 * @create: 2020-08-10 09:26
 **/
public interface IDepartmentService {

    /**
     * 删除部门信息
     *
     * @param id key值
     * @return 返回结果
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 新增部门信息
     *
     * @param record 部门对象
     * @return 返回结果
     */
    int insert(Department record);

    /**
     * 查询部门信息
     *
     * @param id key值
     * @return 返回结果
     */
    Department selectByPrimaryKey(Long id);

    /**
     * 查询所有部门信息
     *
     * @param keyword key值
     * @return 返回结果
     */
    List<Department> selectAll(String keyword);

    /**
     * 更新部门信息
     *
     * @param record 部门对象
     * @return 返回结果
     */
    int updateByPrimaryKey(Department record);
}
