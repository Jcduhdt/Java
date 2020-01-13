package com.jcduhdt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2020-01-10
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testInterceptor")
    public String testInterceptor() {
        System.out.println("testInterceptor执行了...");

        return "success";
    }
}
