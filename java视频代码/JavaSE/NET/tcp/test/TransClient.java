package tcp.test;

import java.io.*;
import java.net.Socket;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-26
 */
public class TransClient {
    public static void main(String[] args) throws IOException {

        /*
         * 思路：
         * 客户端：
         * 1.需要先有socket端点
         * 2.客户端数据源：键盘
         * 3.客户端的目的：socket
         * 4.接收服务端的数据，源：socket
         * 5.将数据打印出来，目的:控制台
         * 6.在这些流中操作的数据，都是文本数据
         *
         * 转换客户端
         * 1.创建socket对象
         * 2.获取键盘录入
         * 3.将录入的信息发送给socket输出流
         */

        //1.创建socket客户端对象
        Socket s = new Socket("192.168.31.57",10004);

        //2.获取键盘录入
        BufferedReader bufr =
                new BufferedReader(new InputStreamReader(System.in));

        //3.socket输出流
//        new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(),true);//自动刷新
//        通过现有的 OutputStream 创建自动刷新的 PrintWriter。

        //4.socket输入流，读取服务端返回的大写数据

        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line = null;
        while ((line=bufr.readLine())!=null){
            if ("over".equals(line))
                break;

            out.println(line);//没有刷新动作就只是数据写入到PrintWriter，而没有写入s.getOutputStream()
            //需要刷新，因为阻塞，所以可能双方都在等待
            //缺少结束标记，两边都在等待
//            out.flush();

            //读取服务端发回的一行大写数据
            String upperStr = bufIn.readLine();
            System.out.println(upperStr);
        }

        //关客户端就行
//        while循环break后，关闭了s，socket就会发送-1传给服务端，相当于服务端读到了跳出循环的条件
        s.close();
    }
}
