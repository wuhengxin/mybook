package com.crm.utils;

import com.crm.web.controller.BooksController;
import org.apache.ibatis.javassist.bytecode.stackmap.TypeData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: CRM
 * @description OutputLog
 * @author: wuhx
 * @create: 2020-08-10 17:22
 **/
public  class OutputLog {
    public static void output(Class name, String string){
        Logger logger= LoggerFactory.getLogger(name.getClass());
        logger.debug(string);
    }
}
