package tcp.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-26
 */
public class TransServer {
    public static void main(String[] args) throws IOException {

        /*
         * 转换服务器
         * 分析：
         * 1.serversocket服务
         * 2.获取socket对象
         * 3.源：socket，读取客户端发过来的需要转换的数据
         * 4.目的：显示在控制台
         * 5.将数据转成大写发给客户端
         */

        //1.
        ServerSocket ss = new ServerSocket(10004);

        //2.获取Socket对象
        Socket s = ss.accept();

        //获取ip
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip+"...connected");

        //3.获取socket读取流，并转换
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

        //4.获取socket输出流，并装饰
        PrintWriter out = new PrintWriter(s.getOutputStream(),true);

        String line = null;
        while ((line=bufIn.readLine())!=null){

            //readline什么时候完，读到换行标记，如果输入没有换行标记，这个就会等待，认为没发完
            System.out.println(line);
            out.println(line.toUpperCase());//所以两边要么用println或者在发出后添加"\r\n"
        }

        s.close();
        ss.close();
    }
}
