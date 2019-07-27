package ie_server;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-27
 */
public class URLDemo {
    //URI>URL
    //URI 是统一资源 标识符，而 URL 是统一资源 定位符。
    // 因此，笼统地说，每个 URL 都是 URI，但不一定每个 URI 都是 URL。
    // 这是因为 URI 还包括一个子类，即统一资源 名称 (URN)，它命名资源但不指定如何定位资源。

    public static void main(String[] args) throws IOException {
        String str_url = "http://tool.oschina.net/apidocs/apidoc?api=jdk-zh";

        URL url = new URL(str_url);

        /*System.out.println(":" + url.getProtocol());//获取协议
        System.out.println(":" + url.getHost());//获取主机
        System.out.println(":" + url.getPort());//获取端口
        System.out.println(":" + url.getFile());
        System.out.println(":" + url.getPath());
        System.out.println(":" + url.getQuery());
        :http
        :tool.oschina.net
        :-1
        :/apidocs/apidoc?api=jdk-zh
        :/apidocs/apidoc
        :api=jdk-zh
        */


        //获取url对象的url连接器对象，将连接封装成了对象：java中内置的可以解析的具体协议的对象+socket
        URLConnection conn = url.openConnection();

        String value = conn.getHeaderField("Content-Type");
        System.out.println(value);//text/html;charset=UTF-8


        System.out.println(conn);
        //sun.net.www.protocol.http.HttpURLConnection:http://tool.oschina.net/apidocs/apidoc?api=jdk-zh

        InputStream in = url.openStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);

        String text = new String(buf,0,len);

        System.out.println(text);

        in.close();
    }
}
