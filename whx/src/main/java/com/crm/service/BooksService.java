package com.crm.service;

import com.crm.domain.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: CRM
 * @description: BooksService
 * @author: wuhx
 * @create: 2020-08-10 09:26
 **/
    public interface BooksService {

    /**
     * 插入图书对象信息
     *
     * @param books 图书对象
     * @return 操作结果
     */
    int  insertBooks(Books books);

    /**
     * 删除图书信息
     *
     * @param id key值
     * @return 返回结果
     */
    int deleteBook(Long id);

    /**
     * 查询所有图书
     *
     * @param keyword key值
     * @return 返回结果
     */
    List<Books> selectAllBooks(String keyword);

    /**
     * 修改图书对象
     *
     * @param books 图书对象
     * @return 返回跟新结果结果
     */
    int updateBooks(Books books);

    /**
     * 修改图书数量信息
     *
     * @param books 图书对象
     * @return 返回更新结果
     */
    int updateBookAcount(Books books);

    /**
     * 条件搜索
     * @param keyword1
     * @param keyword2
     * @return
     */
    List<Books> selectAllBooks2(@Param("keyword1") String keyword1,@Param("keyword2") String keyword2);

}
