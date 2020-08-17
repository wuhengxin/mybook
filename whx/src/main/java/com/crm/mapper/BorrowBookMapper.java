package com.crm.mapper;

import com.crm.domain.BorrowBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BorrowBookMapper {
    int insertRecord(BorrowBook borrowBook);

    int updateRecord(BorrowBook borrowBook);

    List<BorrowBook> selectAll(@Param("keyword") String keyword);

    List<BorrowBook> selectAllRecord(@Param("keyword1") String keyword1,@Param("keyword2") String keyword2);

    int updateBookAccount(BorrowBook borrowBook);

    List<BorrowBook> selectRecord(@Param("keyword") Integer keyword);



}
