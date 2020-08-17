package com.crm.mapper;

import com.crm.domain.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Department record);

    Department selectByPrimaryKey(Long id);

    List<Department> selectAll(@Param("keyword") String keyword);

    int updateByPrimaryKey(Department record);
}