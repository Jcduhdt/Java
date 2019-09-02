package web.listener; /**
 * @version v12.0.1
 * @author ZhangXiong
 * @date 2019-09-02
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.io.FileInputStream;

@WebListener
public class ContextLoaderListener implements ServletContextListener{


    /**
     * 监听ServletContext对象创建的。ServletContext对象服务器启动后自动创建
     * 在服务器启动后自动调用
     * @param sce
     */
    public void contextInitialized(ServletContextEvent sce) {
        //加载资源文件
        //1.获取ServletContext对象
        ServletContext servletContext = sce.getServletContext();

        //2.加载资源文件
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        //3.获取真实路径
        String realPath = servletContext.getRealPath(contextConfigLocation);

        //4.加载进内存
        try{
            FileInputStream fis = new FileInputStream(realPath);
            System.out.println(fis);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("ServletContext对象被创建了...");
    }

    /**
     * 在服务器关闭后，ServletContext对象被销毁了。当服务器正常关闭后该方法被调用
     * @param sce
     */
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext对象被销毁了...");
    }

}
