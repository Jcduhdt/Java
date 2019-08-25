package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-23
 */
@WebServlet("/RequestDemo4")
public class RequestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //演示获取请求头数据：referer

        String referer = request.getHeader("referer");
        System.out.println("referer = " + referer);//referer = http://localhost:8080/servlet_http/login.html

        //防盗链
        if (referer != null){
            if (referer.contains("/servlet_http")){
                //正常访问
//                System.out.println("播放电影");
                //页面上显示
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("播放电影...");
            }else {
                //盗链
                System.out.println("想看电影吗？来腾讯吧");
            }
        }
    }
}
