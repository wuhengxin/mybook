package com.crm.mapper;


import com.crm.domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);

    Employee selectForLogin(@Param("loginname") String loginname, @Param("password") String password);
    String selectEmploy(@Param("name") String name);
}