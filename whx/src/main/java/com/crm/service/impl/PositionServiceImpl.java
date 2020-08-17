package com.crm.service.impl;


import com.crm.domain.Position;
import com.crm.mapper.PositionMapper;
import com.crm.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类描述信息 职位部门管理Controller
 *
 * @author wuhx
 * @ClassName PositionServiceImpl
 * @date 2020/03/03 16:01
 */

@Service
public class PositionServiceImpl implements IPositionService {


    //注入Mapper
    @Autowired
    private PositionMapper mapper;

    /**
     * 删除职位信息
     *
     * @param id key值
     * @return 返回结果
     */
    public int deleteByPrimaryKey(Long id) {

        if (!(id == 0 && id == null)) {
            int pid = mapper.deleteByPrimaryKey(id);
            return pid;
        }
        return 0;
    }

    /**
     * 新增职位信息
     *
     * @param record 职位对象
     * @return 返回结果
     */
    public int insert(Position record) {
        if (record != null) {
            return mapper.insert(record);
        }
        return 0;

    }

    /**
     * 查询职位信息
     *
     * @param id key值
     * @return 返回结果
     */
    public Position selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有职位信息
     *
     * @param keyword key值
     * @return 返回结果
     */
    public List<Position> selectAll(String keyword) {
        return mapper.selectAll(keyword);
    }

    /**
     * 更新职位信息
     *
     * @param record 职位对象
     * @return
     */
    public int updateByPrimaryKey(Position record) {
        return mapper.updateByPrimaryKey(record);
    }
}
