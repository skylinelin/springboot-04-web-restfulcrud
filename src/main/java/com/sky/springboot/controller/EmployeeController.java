package com.sky.springboot.controller;

import com.sky.springboot.dao.EmployeeDao;
import com.sky.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

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
}
