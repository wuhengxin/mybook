package com.crm.web.controller;


import com.crm.domain.Books;
import com.crm.service.BooksService;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: CRM
 * @description:BooksController 类
 * @author: wuhx
 **/
@Controller
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @RequestMapping("/bookView")
    public String bookView() {

        return "book/book";
    }

    @RequestMapping("/bookAddView")
    public String bookAddView() {

        return "book/bookAdd";
    }

    @RequestMapping("/bookAddRecord")
    public String bookAddRecord() {

        return "book/bookAddRecord";
    }

    @RequestMapping("/bookSearchRecord")
    public String bookSearchRecord() {

        return "book/record";
    }

    @RequestMapping(value = "/recordHistory")
    public String recordHistory(){
        return "book/recordHistory";
    }

    @RequestMapping(value = "/recordAllHistory")
    public String recordAllHistory(){
        return "book/recordAllHistory";
    }

    /**
     * 查询部门所有数据
     * @param keyword
     * @return
     */
    @RequestMapping("/bookOption")
    @ResponseBody
    public List<Books> jsonDeptOption(String keyword) {
        List<Books> list = booksService.selectAllBooks(keyword);
        return list;
    }

    @RequestMapping(value = "/bookList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> selectAllBooks(@RequestParam int page, @RequestParam int limit,String keyword){
        // 查询结果总数，根据 keyword

        List<Books> countBooks =booksService.selectAllBooks(keyword);
        countBooks.size();//获取结果个数

        //PageHelper实现分页

        if (page < 0) {
            page = 1;
        }

        PageHelper.startPage(page, limit);

        //封装JSON数据
        Map<String, Object> resultMap = new HashMap<String, Object>() {
            {
                put("code", 0);
                put("msg", "");
                put("count", countBooks.size());
                put("data", countBooks);
            }
        };

        return resultMap;
    }

    @RequestMapping(value = "/bookList1", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> selectAllBooks1(@RequestParam int page, @RequestParam int limit,
                                               String keyword1,String keyword2){
        // 查询结果总数，根据 keyword

        List<Books> countBooks =booksService.selectAllBooks2(keyword1,keyword2);
        countBooks.size();//获取结果个数

        //PageHelper实现分页

        if (page < 0) {
            page = 1;
        }

        PageHelper.startPage(page, limit);

        //封装JSON数据
        Map<String, Object> resultMap = new HashMap<String, Object>() {
            {
                put("code", 0);
                put("msg", "");
                put("count", countBooks.size());
                put("data", countBooks);
            }
        };

        return resultMap;
    }

    @RequestMapping("/bookInsert")
    @ResponseBody
    public String insertBooks(@RequestBody Books books){
        if(books != null){
            int index=booksService.insertBooks(books);
            if(index >0)
                return "success";
        }
        return "error";
    }

    @RequestMapping(value = "/bookDelete")
    @ResponseBody
    public String deleteBook(@RequestParam ("id")Long id){
        if(id != null){
            int index=booksService.deleteBook(id);
            if(index > 0)
                return "success";
        }
        return "error";
    }


    @RequestMapping(value = "/bookUpdate")
    @ResponseBody
    public String updateBook(@RequestBody Books books){
        if(books !=null){
            int index=booksService.updateBooks(books);
            if(index > 0){
                return "success";
            }
        }
        return "error";
    }
}
