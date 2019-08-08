package ie_server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-27
 */
public class MyBrowser {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("192.168.31.57",8080);

        //模拟浏览器给Tomcat服务器端发送符合http协议的请求消息
        PrintWriter out = new PrintWriter(s.getOutputStream(),true);
        out.println("GET / HTTP/1.1");
        out.println("Host: localhost:8080");
        out.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        out.println("Connection: close");
        out.println();
        out.println();

        InputStream in = s.getInputStream();

        byte[] buf = new byte[1024];
        int len = in.read(buf);

        String str = new String(buf,0,len);
        System.out.println(str);

        s.close();
    }
}
