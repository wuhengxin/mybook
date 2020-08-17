package com.crm.service;


import com.crm.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: CRM
 * @description: IUserService
 * @author: wuhx
 * @create: 2020-08-10 09:26
 **/
public interface IUserService {

    /**
     * 查询所有管理员信息
     *
     * @param keyword1
     * @param keyword2
     * @return
     */
    List<User> selectAll(String keyword1, String keyword2);

    /**
     * 分页查询管理员信息
     *
     * @param page 开始页
     * @param pageLimit 末尾页
     * @return
     */
    List<User> selectPageResult(int page, int pageLimit);

    /**
     * 新增管理员信息
     *
     * @param record 管理员对象
     * @return
     */
    int insert(User record);

    /**
     * 删除管理员信息
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 查询登录用户信息
     *
     * @param loginname
     * @param password
     * @return
     */
    User selectByLogin(String loginname, String password);

    /**
     * 查询用户名信息
     *
     * @param id
     * @return
     */
    String selectusername(Long id);

    /**
     *
     * @param record 管理员用户对象
     * @return
     */
    int updateByPrimaryKey(User record);

    /**
     *  查询登录名信息
     *
     * @param loginname key值
     * @return
     */
    String selectloginName(String loginname );

}
