package com.crm.web.controller;



import com.crm.context.EmployeeContext;
import com.crm.context.UserContext;
import com.crm.domain.Employee;
import com.crm.domain.User;
import com.crm.mapper.EmployeeMapper;
import com.crm.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@Controller
public class LoginController {

    //依赖Mapper
    @Autowired
    private UserMapper mapper;
    @Autowired
    private EmployeeMapper mapper1;

    //处理验证码
    @RequestMapping("/imageCode")
    public void imgCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //这个方法实现验证码的生成
        BufferedImage bi = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);//创建图像缓冲区
        Graphics g = bi.getGraphics(); //通过缓冲区创建一个画布
        Color c = new Color(120, 200, 155); //创建颜色
        /*根据背景画了一个矩形框
         */
        g.setColor(c);//为画布创建背景颜色
        g.fillRect(0, 0, 68, 22); //fillRect:填充指定的矩形

        char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();//转化为字符型的数组
        Random r = new Random();
        int len = ch.length;
        int index; //index用于存放随机数字
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            index = r.nextInt(len);//产生随机数字
            g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));  //设置颜色
            g.drawString(ch[index] + "", (i * 15) + 3, 18);//画数字以及数字的位置
            sb.append(ch[index]);
        }
        request.getSession().setAttribute("imgCode", sb.toString()); //将数字保留在session中，便于后续的使用
        ImageIO.write(bi, "JPG", response.getOutputStream());
    }

    //登入处理
    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView login(@RequestParam("loginname") String loginname, @RequestParam("password") String password,
                              @RequestParam("position") Integer position,
                              @RequestParam("imgCode") String imgCode, HttpSession session, ModelAndView mv) {


        //取出session中的验证码
        String imgCode1 = (String) session.getAttribute("imgCode");

        if (position==1) {
            User user = mapper.selectByLogin(loginname, password);
            Logger logger= LoggerFactory.getLogger(LoginController.class);
            logger.debug("user = " + user);

            //校验管理员账号密码
            if (user == null) {
                session.setAttribute("errorMsg", "账号密码错误！请检查！");
                session.setAttribute("loginname", loginname);
                // 服务器内部跳转到登录页面
                mv.setViewName("forward:/login.jsp");
                return mv;

                //检验验证码
            } else if (!(imgCode.equals(imgCode1))) {
                session.setAttribute("errorMsg", "验证码错误！请重新输入！");
                session.setAttribute("loginname", loginname);
                // 服务器内部跳转到登录页面
                mv.setViewName("forward:/login.jsp");
                return mv;
            } else if (user.getState() == 0) {
                session.setAttribute("errorMsg", user.getLoginname() + "用户被锁定！请联系管理员！");
                session.setAttribute("loginname", loginname);
                // 服务器内部跳转到登录页面
                mv.setViewName("forward:/login.jsp");
                return mv;
            }
            //存储用户登入信息
            UserContext.setUserInSession(user);
            // 客户端跳转到main页面
            mv.setViewName("redirect:/main");
            return mv;
        }
        else {
            Employee employee = mapper1.selectForLogin(loginname, password);
            System.out.println("employee = " + employee);
            if (employee == null) {
                session.setAttribute("errorMsg", "账号密码错误！请检查！");
                session.setAttribute("loginname", loginname);
                // 服务器内部跳转到登录页面
                mv.setViewName("forward:/login.jsp");
                return mv;

                //检验验证码
            } else if (!(imgCode.equals(imgCode1))) {
                session.setAttribute("errorMsg", "验证码错误！请重新输入！");
                session.setAttribute("loginname", loginname);
                // 服务器内部跳转到登录页面
                mv.setViewName("forward:/login.jsp");
                return mv;
            } else if (employee.getState() == 0) {
                session.setAttribute("errorMsg", employee.getLoginname() + "用户被锁定！请联系管理员！");
                session.setAttribute("loginname", loginname);
                // 服务器内部跳转到登录页面
                mv.setViewName("forward:/login.jsp");
                return mv;
            }
            //存储用户登入信息
            EmployeeContext.setEmployeeInSession(employee);
        }

        // 客户端跳转到main页面
        mv.setViewName("redirect:/empmain");
        return mv;

    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    @RequestMapping("/empmain")
    public String empmain() {
        return "empmain";
    }

    //注销处理
    @RequestMapping("/loginOut")
    public String invalidate(HttpSession session) {
        session.invalidate();
        return "redirect:login.jsp";
    }
}
