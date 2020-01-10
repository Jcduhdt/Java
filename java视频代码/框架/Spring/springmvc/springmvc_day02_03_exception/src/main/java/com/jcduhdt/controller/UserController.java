package com.jcduhdt.controller;

import com.jcduhdt.exception.SysException;
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
    @RequestMapping("/testException")
    public String testException() throws SysException {
        System.out.println("testException执行了...");
        try {
            //模拟异常
            int i = 10/0;
        } catch (Exception e) {
            //打印异常信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("查询所有用户出现错误");
        }

        return "success";
    }
}
