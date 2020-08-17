package com.crm.service;


import com.crm.domain.Position;

import java.util.List;

/**
 * @program: CRM
 * @description: IPositionService
 * @author: wuhx
 * @create: 2020-08-10 09:26
 **/
public interface IPositionService {

    /**
     * 删除职位信息
     *
     * @param id key值
     * @return 返回结果
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 新增职位信息
     *
     * @param record 职位对象
     * @return 返回结果
     */
    int insert(Position record);

    /**
     * 查询职位信息
     *
     * @param id key值
     * @return 返回结果
     */
    Position selectByPrimaryKey(Long id);

    /**
     * 查询所有职位信息
     *
     * @param keyword key值
     * @return 返回结果
     */
    List<Position> selectAll(String keyword);

    /**
     * 更新职位信息
     *
     * @param record 职位对象
     * @return
     */
    int updateByPrimaryKey(Position record);
}
