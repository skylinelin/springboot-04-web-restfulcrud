package com.sky.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class Hello {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "{'hello'}";
    }

    @ResponseBody
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("name","林法扬");
        return "success";
    }

}
