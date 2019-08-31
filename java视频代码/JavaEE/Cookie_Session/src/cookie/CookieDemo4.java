package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-26
 */
@WebServlet("/CookieDemo4")
public class CookieDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie c1 = new Cookie("msg", "hello");
        //2.设置cookie的存活时间
//        c1.setMaxAge(30);//将cookie持久化到硬盘，30秒后会自动删除cookie文件
//        c1.setMaxAge(-1);//负数，默认值
        c1.setMaxAge(0);//删除cookie信息
        //2.发送Cookie
        response.addCookie(c1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
