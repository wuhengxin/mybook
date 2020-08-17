package com.crm.service.impl;


import com.crm.domain.Books;
import com.crm.mapper.BookMapper;
import com.crm.service.BooksService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: CRM
 * @description: BooksServiceImp
 * @author: wuhx
 * @create: 2020-08-10 09:26
 **/
@Service
public class BooksServiceImp implements BooksService {

    @Autowired
    private BookMapper bookMapper;

    /**
     * 插入图书对象信息
     *
     * @param books 图书对象
     * @return 操作结果
     */
    @Override
    public int insertBooks(Books books) {
        return bookMapper.insertBooks(books);
    }

    /**
     * 删除图书信息
     *
     * @param id key值
     * @return 返回结果
     */
    @Override
    public int deleteBook(Long id) {
        return bookMapper.deleteBook(id);
    }

    /**
     * 查询所有图书
     *
     * @param keyword key值
     * @return 返回结果
     */
    @Override
    public List<Books> selectAllBooks(String keyword) {
        return bookMapper.selectAllBooks(keyword);
    }

    /**
     * 修改图书对象
     *
     * @param books 图书对象
     * @return 返回跟新结果结果
     */
    @Override
    public int updateBooks(Books books) {
        return bookMapper.updateBooks(books);
    }

    /**
     * 修改图书数量信息
     *
     * @param books 图书对象
     * @return 返回更新结果
     */
    @Override
    public int updateBookAcount(Books books) {
        return bookMapper.updateBookAcount(books);
    }

    /**
     * 条件搜索
     *
     * @param keyword1
     * @param keyword2
     * @return
     */
    @Override
    public List<Books> selectAllBooks2(String keyword1,String keyword2) {
        return bookMapper.selectAllBooks2(keyword1,keyword2);
    }
}
