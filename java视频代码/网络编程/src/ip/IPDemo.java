package ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-26
 */
public class IPDemo {
    public static void main(String[] args) throws UnknownHostException {

        //获取本地主机ip地址对象
        InetAddress ip = InetAddress.getLocalHost();

        //获取其他主机的ip地址对象
//        ip = InetAddress.getByName("www.baidu.com");

        System.out.println(ip.getHostAddress());//180.97.33.108
        System.out.println(ip.getHostName());//www.baidu.com
    }
}
