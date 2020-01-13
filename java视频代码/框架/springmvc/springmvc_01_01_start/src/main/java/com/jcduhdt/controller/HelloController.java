package com.jcduhdt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-12-05
 */

//控制器类
@Controller
@RequestMapping(path = "/user")
public class HelloController {

    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("hello stringMVC");
        return "success";
    }

    //RequestMapping的参数，value和path的作用好像是一样的，method就是限制请求方法的类型，parmas就是发送请求中必须含有这个参数
    @RequestMapping(value = "/testRequestMapping",method = {RequestMethod.GET},params = {"username"})
    public String testRequestMapping(){
        System.out.println("测试RequestMapping注解。。。");
        return "success";
    }
}
