package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-29
 */
@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取map
        Map<String, String[]> map = request.getParameterMap();
        //封装对象
        User user = new User();
        try{
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用service修改
        System.out.println(user);
        UserServiceImpl service = new UserServiceImpl();
        service.updateUser(user);
        //跳转到查询所有servlet
        response.sendRedirect(request.getContextPath()+"/userListServlet ");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
