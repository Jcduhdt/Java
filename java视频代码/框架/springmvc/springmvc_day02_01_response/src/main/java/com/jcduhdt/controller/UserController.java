package com.jcduhdt.controller;

import com.jcduhdt.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2020-01-09
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString方法执行了...");
        //模拟从数据库中查询出User对象

        User user = new User();
        user.setUsername("盛大");
        user.setPassword("1315");
        user.setAge(30);
        //model对象
        model.addAttribute("user",user);
        return "success";
    }

    /**
     * 测试void
     * 默认情况会寻找WEB-INF/pages/user/testVoid.jsp
     * 写请求转发一次请求，不用编写项目名称
     * @param request
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("testVoid方法执行了...");
        //编写请求转发程序 不用视图解析器
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //重定向
//        response.sendRedirect(request.getContextPath()+"/index.jsp");
        //设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //浏览器直接会进行响应
        response.getWriter().print("你好");
        return;
    }

    /**
     * 返回ModelAndVoid
     * @return
     */
    @RequestMapping("/testModelAndVoid")
    public ModelAndView testModelAndVoid(){

        //创建ModelAndVoid对象
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndVoid方法执行了...");
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("喜乐");
        user.setPassword("2020");
        user.setAge(30);
        //把user对象存储到mv对象中，也会把user对象存到request对象中
        mv.addObject("user",user);
        //跳转到哪个界面,视图解析器
        mv.setViewName("success");
        return mv;
    }

    /**
     * 关键字方式进行转发或者重定向
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testString方法执行了...");

        //请求的转发
//        return "forward:/WEB-INF/pages/success.jsp";
        //重定向
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求响应
     * @return
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax方法执行了...");
        //客户端发送ajax请求，穿的是json字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        //做响应，模拟查询数据库
        user.setUsername("haha");
        user.setAge(40);
        //做响应
        return user;
    }
}
