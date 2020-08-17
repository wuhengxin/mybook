package com.crm.service.impl;


import com.crm.domain.User;
import com.crm.mapper.UserMapper;
import com.crm.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: CRM
 * @description: UserServiceImpl
 * @author: wuhx
 * @create: 2020-08-10 09:26
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper mapper;

    /**
     * 查询所有管理员信息
     *
     * @param keyword1
     * @param keyword2
     * @return
     */
    @Override
    public List<User> selectAll(String keyword1, String keyword2) {
        return mapper.selectAll(keyword1,keyword2);
    }

    /**
     * 分页查询管理员信息
     *
     * @param page 开始页
     * @param pageLimit 末尾页
     * @return
     */
    @Override
    public List<User> selectPageResult(int page, int pageLimit) {
        return mapper.selectPageResult(page, pageLimit);
    }

    /**
     * 新增管理员信息
     *
     * @param record 管理员对象
     * @return
     */
    @Override
    public int insert(User record) {
        return mapper.insert(record);
    }

    /**
     * 删除管理员信息
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    /**
     * 查询登录用户信息
     *
     * @param loginname
     * @param password
     * @return
     */
    @Override
    public User selectByLogin(String loginname, String password) {
        return mapper.selectByLogin(loginname, password);
    }

    /**
     * 查询用户名信息
     *
     * @param id
     * @return
     */
    @Override
    public String selectusername(Long id) {
        return mapper.selectusername(id);
    }


    /**
     *
     * @param record 管理员用户对象
     * @return
     */
    @Override
    public int updateByPrimaryKey(User record) {
        return mapper.updateByPrimaryKey(record);
    }

    /**
     *  查询登录名信息
     *
     * @param loginname key值
     * @return
     */
    @Override
    public  String selectloginName(String loginname ){
       return mapper.selectloginName(loginname);
    }

}
