package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-27
 */
@WebServlet("/SessionDemo3")
public class SessionDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session
        HttpSession session = request.getSession();

        //期望客户端关闭后，session也能相同
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(60*60);

        response.addCookie(cookie);
        System.out.println(session);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
