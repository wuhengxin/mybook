package com.crm.mapper;


import com.crm.domain.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    int  insertBooks(Books books);

    int deleteBook(Long id);

    List<Books> selectAllBooks(@Param("keyword") String keyword);

    int updateBooks(Books books);
    int updateBookAcount(Books books);

    List<Books> selectAllBooks2(@Param("keyword1") String keyword1,@Param("keyword2") String keyword2 );


}
