package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-23
 */

/**
 * 演示Request对象获取请求行数据
 */
@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            1. 获取请求方式 ：GET
                    * String getMethod()
            2. (*)获取虚拟目录：/servlet_http
                    * String getContextPath()
            3. 获取Servlet路径: /RequestDemo1
                    * String getServletPath()
            4. 获取get方式请求参数：name=zhangsan
                    * String getQueryString()
            5. (*)获取请求URI：/servlet_http/RequestDemo1
                    * String getRequestURI():		/servlet_http/RequestDemo1
                    * StringBuffer getRequestURL()  :http://localhost:8080/servlet_http/RequestDemo1

                    * URL:统一资源定位符 ：http://localhost:8080/servlet_http/RequestDemo1	中华人民共和国
                    * URI：统一资源标识符 : /servlet_http/RequestDemo1					共和国

            6. 获取协议及版本：HTTP/1.1
                    * String getProtocol()

            7. 获取客户机的IP地址：0:0:0:0:0:0:0:1  这是ip地址 这个是因为自己请求自己
                            * String getRemoteAddr()
        */

        //1. 获取请求方式 ：GET
        String method = request.getMethod();
        System.out.println("method = " + method);
        //2. (*)获取虚拟目录：/servlet_http
        String contextPath = request.getContextPath();
        System.out.println("contextPath = " + contextPath);
        //3. 获取Servlet路径: /RequestDemo1
        String servletPath = request.getServletPath();
        System.out.println("servletPath = " + servletPath);
        //4. 获取get方式请求参数：name=zhangsan
        String queryString = request.getQueryString();
        System.out.println("queryString = " + queryString);
        //5.(*)获取请求URI：/servlet_http/RequestDemo1
        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("requestURL = " + requestURL);
        //6. 获取协议及版本：HTTP/1.1
        String protocol = request.getProtocol();
        System.out.println("protocol = " + protocol);
        // 7. 获取客户机的IP地址：0:0:0:0:0:0:0:1
        String remoteAddr = request.getRemoteAddr();
        System.out.println("remoteAddr = " + remoteAddr);
    }
}
