package com.crm.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.crm.domain.Books;
import com.crm.domain.BorrowBook;
import com.crm.domain.Employee;
import com.crm.service.BooksService;
import com.crm.service.BorrowBookService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "record")
public class BorrowBookController {
    @Autowired
    private BorrowBookService borrowBookService;

    @Autowired
    private BooksService booksService;

    @RequestMapping(value = "insertRecord")
    @ResponseBody
    public String insertBookRecord(@RequestBody JSONObject ob){
        Logger logger=LoggerFactory.getLogger(BorrowBookController.class);
        logger.debug("ob.toJSONString() = " + ob.toJSONString());
        String data = ob.toJSONString();
        BorrowBook borrowBook=jsonData(data);
        logger.debug("borrowBook》》》》》"+borrowBook);
        // 归还图书对象
        Books books=borrowBook.getBooks();
        return bookAndRecord( borrowBook, books);
    }

    @RequestMapping(value = "updateRecord")
    @ResponseBody
    public String updateBookRecord(@RequestBody JSONObject ob){
        System.out.println("ob.toJSONString() = " + ob.toJSONString());
        String data = ob.toJSONString();
        BorrowBook borrowBook=jsonData(data);
        System.out.println("borrowBook"+borrowBook);

        // 归还图书对象
        Books books=borrowBook.getBooks();
        return bookAndRecord( borrowBook, books);
    }

    private BorrowBook jsonData(String data){

        //解析前台传递的json数据
        JSONObject json = JSON.parseObject(data);

        if (json != null) {
            Long id=json.getLong("id");
            Long account=json.getLong("account");
            Integer state=json.getInteger("state");
            Books books=new Books();
            books.setbId(json.getLong("bId"));
            books.setbName(json.getString("bName"));
            books.setbAccount(json.getString("bAccount"));
            Employee employee =new Employee();
            employee.setId(json.getLong("employee_id"));
            employee.setName(json.getString("eName"));
            BorrowBook borrowBook =new BorrowBook(id,account,state,books,employee);
            return borrowBook;
        }
        return  null;
    }
    @RequestMapping(value = "/recordList", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> recordList(@RequestParam int page, @RequestParam int limit,
                                   String keyword1, String keyword2) {
        //查询结果总数
        List<BorrowBook> countDept = borrowBookService.selectAllRecord(keyword1,keyword2);
        //分页
        if (page < 0) {
            page = 1;
        }
        PageHelper.startPage(page, limit);
        List<BorrowBook> listDept = borrowBookService.selectAllRecord(keyword1,keyword2);
        //封装json数据
        Map<String, Object> resultMap = new HashMap<String, Object>() {
            {
                put("code", 0);
                put("msg", "");
                put("count", countDept.size());
                put("data", listDept);
            }
        };
        return resultMap;
    }

    private String bookAndRecord(BorrowBook borrowBook,Books books) {
        List<Books> booksKu = booksService.selectAllBooks(books.getbName());
        Books books1 = booksKu.get(0);
        int index=0;
        // 获取在库图书数量
        Long bookAccount = Long.parseLong(books1.getbAccount());
        Logger logger=LoggerFactory.getLogger(BorrowBookController.class);
        logger.debug("在库图书" + bookAccount);
        // 获取当前要租借的图书数量
        Long tAccount = borrowBook.getAccount();
        if (borrowBook.getState() == 1) {
            tAccount = tAccount * (-1);
        }
        logger.debug("租借图书" + tAccount);
        //比较当前图书数量是否符合租借条件
        Long result = bookAccount + tAccount;
        if (result >= 0) {
            borrowBook.setCompletionTime(new java.sql.Date(new java.util.Date().getTime()));
            if (borrowBook != null) {
                if (borrowBook.getState() == 0){
                    logger.debug("进入库存更新方法");
                    index = borrowBookService.updateRecord(borrowBook);
                }else {
                    logger.debug("进入新增租借记录方法");
                    index =borrowBookService.insertRecord(borrowBook);
                }
                books1.setbAccount(result.toString());
                logger.debug("books1相关信息" + books1);
                int sum = booksService.updateBookAcount(books1);
                if (index > 0) {
                    return "success";
                }else {
                    return "error";
                }
            }

        }
        return "bookNoEnough";
    }

    @RequestMapping(value = "/recordList1", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> recordList1(@RequestParam int page, @RequestParam int limit,
                                   Integer keyword) {
        Logger logger=LoggerFactory.getLogger(BorrowBookController.class);
        logger.debug("keyword = " + keyword);
        //查询结果总数
        List<BorrowBook> countDept = borrowBookService.selectRecord(keyword);
        //分页
        if (page < 0) {
            page = 1;
        }
        PageHelper.startPage(page, limit);
        List<BorrowBook> listDept = borrowBookService.selectRecord(keyword);
        //封装json数据
        Map<String, Object> resultMap = new HashMap<String, Object>() {
            {
                put("code", 0);
                put("msg", "");
                put("count", countDept.size());
                put("data", listDept);
            }
        };
        return resultMap;
    }
}
