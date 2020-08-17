package com.crm.service.impl;

import com.crm.domain.BorrowBook;
import com.crm.mapper.BorrowBookMapper;
import com.crm.service.BorrowBookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: CRM
 * @description: BorrowBookServiceImp
 * @author: wuhx
 * @create: 2020-08-10 09:26
 **/
@Service
public class BorrowBookServiceImp implements BorrowBookService {


    @Autowired
    private BorrowBookMapper borrowBookMapper;

    /**
     * 插入图书租借信息
     *
     * @param borrowBook 图书租借对象
     * @return 操作结果
     */
    @Override
    public int insertRecord(BorrowBook borrowBook) {
        return borrowBookMapper.insertRecord(borrowBook);
    }

    /**
     * 更新图书租借信息
     *
     * @param borrowBook 图书租借对象
     * @return 操作结果
     */
    @Override
    public int updateRecord(BorrowBook borrowBook) {
        return borrowBookMapper.updateRecord(borrowBook);
    }

    /**
     * 查询所有图书租借信息
     *
     * @param keyword keyword值
     * @return 操作结果
     */
    @Override
    public List<BorrowBook> selectAll(String keyword) {
        return borrowBookMapper.selectAll(keyword);
    }

    /**
     * 查询所有图书租借信息
     *
     * @param keyword1 keyword1值
     * @param keyword2 keyword2值
     * @return 操作结果
     */
    @Override
    public List<BorrowBook> selectAllRecord(String keyword1,String keyword2) {
        return borrowBookMapper.selectAllRecord(keyword1,keyword2);
    }

    /**
     * 更新图书租借数量信息
     *
     * @param borrowBook 图书租借对象
     * @return 操作结果
     */
    @Override
    public int updateBookAccount(BorrowBook borrowBook) {
        return borrowBookMapper.updateBookAccount(borrowBook);
    }

    /**
     * 查询所有图书租借记录信息
     *
     * @param keyword keyword值
     * @return 操作结果
     */
    @Override
    public List<BorrowBook> selectRecord(Integer keyword) {
        return borrowBookMapper.selectRecord(keyword);
    }


}
