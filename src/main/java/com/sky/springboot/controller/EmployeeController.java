package com.sky.springboot.controller;

import com.sky.springboot.dao.DepartmentDao;
import com.sky.springboot.dao.EmployeeDao;
import com.sky.springboot.entities.Department;
import com.sky.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    /**
     * 查询所有员工，返回页面
     *
     * @return
     */
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> all = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps", all);
        return "emp/list";
    }

    /**
     * 添加页面
     */
    @GetMapping("/emp")
    public String toAddEmp(Model model) {
        //查出所有的部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        return "emp/add";
    }
    /**
     * 添加员工功能
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //打印保存的员工信息
        System.out.println("保存的员工信息："+employee);
        employeeDao.save(employee);
        //来到员工列表页面
        //redirect重定向一个地址
        //forward转发到一个地址
        return "redirect:/emps";
    }
}
