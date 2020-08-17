package com.crm.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.crm.domain.Department;
import com.crm.domain.Employee;
import com.crm.domain.Position;
import com.github.pagehelper.PageHelper;

import com.crm.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类描述信息 员工Controller处理类
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    //注入mapper
    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/empView")
    public String employeeView() {

        return "employee/employee";
    }

    @RequestMapping("/empView01")
    public String employeeView1() {

        return "employee/employee01";
    }

    @RequestMapping("/empAddView")
    public String employeeAddView() {

        return "employee/employeeAdd";
    }

    //查询部门所有数据
    @RequestMapping("/empOption")
    @ResponseBody
    public List<Employee> jsonDeptOption(String keyword) {
        List<Employee> list = employeeService.selectAll();
        return list;
    }

    //解析json
    private Employee jsonData(String data) {
        //解析前台传递的json数据
        JSONObject json = JSON.parseObject(data);
        if (json != null) {
            String name = json.getString("name");
            String sex = json.getString("sex");
            String phone = json.getString("phone");
            String email = json.getString("email");
            String positionId = json.getString("positionId");
            String eduschool = json.getString("eduschool");
            String idcard = json.getString("idcard");
            String deptId = json.getString("deptId");
            String address = json.getString("address");
            String password = json.getString("password");
            String loginname = json.getString("loginname");
            Integer state = json.getInteger("state");
            Position p = new Position();
            p.setId(Long.parseLong(positionId));
            Department d = new Department();
            d.setId(Long.parseLong(deptId));
            Employee e = new Employee(name, sex, phone, email, p, eduschool,
                    idcard, d, address,password,loginname,state);
                return e;
        }
        return null;
    }

    //保存数据
    @RequestMapping(value = "/empSave", method = RequestMethod.POST)
    @ResponseBody
    public String employeeSave(@RequestBody JSONObject ob) {

        String data = ob.toJSONString();
        System.out.println(data);
        Employee employee = jsonData(data);
        if (employee != null && employeeService.selectEmploy(employee.getLoginname()) == null) {
            int insert = employeeService.insert(employee);
            if (insert != 0) {
                return "success";
            }
        }
        return "error";
    }

    //更新
    @RequestMapping("/empUpdate")
    @ResponseBody
    public String update(@RequestBody JSONObject ob) {
        System.out.println("ob.toJSONString() = " + ob.toJSONString());
        String data = ob.toJSONString();
        Employee employee = jsonData(data);
        if (employee != null) {
            int index = employeeService.updateByPrimaryKey(employee);
            if (index != 0) {
                return "success";
            }
        }
        return "error";
    }

    //删除
    @RequestMapping("/empDelete")
    @ResponseBody
    public String delete(Long id) {
        if (id != null) {
            int index = employeeService.deleteByPrimaryKey(id);
            if (index == 0 || index == -1) {
                return "error";
            }
        }
        return "success";
    }

    @RequestMapping(value = "/empList", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> empList(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        //查询所有的数据
        List<Employee> countEmp = employeeService.selectAll();
        //加入分页
        if (page < 0) {
            page = 1;
        }
        PageHelper.startPage(page, limit);
        List<Employee> employeeList = employeeService.selectAll();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        //结果总数
        map.put("count", countEmp.size());
        //结果对象数据
        map.put("data", employeeList);
        return map;
    }
}
