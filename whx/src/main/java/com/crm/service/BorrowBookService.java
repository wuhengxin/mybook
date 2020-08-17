package com.crm.service;

import com.crm.domain.BorrowBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: CRM
 * @description: BorrowBookService
 * @author: wuhx
 * @create: 2020-08-10 09:26
 **/
public interface BorrowBookService {

    /**
     * 插入图书租借信息
     *
     * @param borrowBook 图书租借对象
     * @return 操作结果
     */
    int insertRecord(BorrowBook borrowBook);

    /**
     * 更新图书租借信息
     *
     * @param borrowBook 图书租借对象
     * @return 操作结果
     */
    int updateRecord(BorrowBook borrowBook);

    /**
     * 查询所有图书租借信息
     *
     * @param keyword keyword值
     * @return 操作结果
     */
    List<BorrowBook> selectAll(@Param("keyword") String keyword);

    /**
     * 查询所有图书租借信息
     *
     * @param keyword1 keyword1值
     * @param keyword2 keyword2值
     * @return 操作结果
     */
    List<BorrowBook> selectAllRecord(@Param("keyword1") String keyword1,@Param("keyword2") String keyword2);

    /**
     * 更新图书租借数量信息
     *
     * @param borrowBook 图书租借对象
     * @return 操作结果
     */
    int updateBookAccount(BorrowBook borrowBook);

    /**
     * 查询所有图书租借记录信息
     *
     * @param keyword keyword值
     * @return 操作结果
     */
    List<BorrowBook> selectRecord(@Param("keyword") Integer keyword);
}
