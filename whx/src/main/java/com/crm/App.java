package com.crm;



import com.crm.domain.*;
import com.crm.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jws.Oneway;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class App {


    @Autowired
    private IUserService service;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IPositionService positionService;
    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private BooksService booksService;


    @Test
    public void test() {
      List<User> users = service.selectAll("d",null);
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }


    @Test
    public void testPage() {

        List<User> users = service.selectPageResult(1, 5);
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void testEmpList() {

        List<Employee> employees = employeeService.selectAll();
        for (Employee employee : employees) {
            System.out.println("employee = " + employee.getDeptId().getDeptname());
        }
    }

    @Test
    public void testPositionList() {
        List<Position> positions = positionService.selectAll("DBA");

        for (Position position : positions) {
            System.out.println("position = " + position);
        }
    }

    @Test
    public void deptList(){

        List<Department> list = departmentService.selectAll("技术");
        for (Department department : list) {
            System.out.println("department = " + department);
        }
    }

    @Test
    public void test11(){
        String name="jav";
        List<Books> list =booksService.selectAllBooks2(name,"1");
        for (Books books : list) {
            System.out.println("department = " + books);
        }
    }


}
