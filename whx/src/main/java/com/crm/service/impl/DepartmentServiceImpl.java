package com.crm.service.impl;


import com.crm.domain.Department;
import com.crm.mapper.DepartmentMapper;
import com.crm.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类描述信息 部门业务处理类
 *
 * @author wuhx
 * @ClassName DepartmentServiceImpl
 * @date 2020/02/25 16:14
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentMapper mapper;

    /**
     * 删除部门信息
     *
     * @param id key值
     * @return 返回结果
     */
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    /**
     * 新增部门信息
     *
     * @param record 部门对象
     * @return 返回结果
     */
    public int insert(Department record) {
        return mapper.insert(record);
    }

    /**
     * 查询部门信息
     *
     * @param id key值
     * @return 返回结果
     */
    public Department selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有部门信息
     *
     * @param keyword key值
     * @return 返回结果
     */
    public List<Department> selectAll(String keyword) {
        return mapper.selectAll(keyword);
    }

    /**
     * 更新部门信息
     *
     * @param record 部门对象
     * @return 返回结果
     */
    public int updateByPrimaryKey(Department record) {
        return mapper.updateByPrimaryKey(record);
    }
}
