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
@WebServlet("/CookieDemo5")
public class CookieDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie c1 = new Cookie("msg", "你好");
        c1.setPath("/");//设置cookie的获取范围。默认情况下，设置当前的虚拟目录
//					* 如果要共享，则可以将path设置为"/"
        //2.发送Cookie
        response.addCookie(c1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
