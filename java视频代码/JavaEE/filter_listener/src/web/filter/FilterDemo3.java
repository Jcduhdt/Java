package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-29
 */
//@WebFilter("/*")
public class FilterDemo3 implements Filter {
    /**
     * 服务器关闭后，Filter对象被销毁，如果正常关闭，会调用destory
     */
    public void destroy() {
        System.out.println("destory...");
    }

    /**
     * 每一次请求被拦截资源时，会执行，执行多次
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter...");
        chain.doFilter(req, resp);
    }

    /**
     * 在服务器启动后创建Filter对象，然后调用init方法
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init...");
    }

}
