package tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-26
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {

        /*
         * Tcp传输，客户端建立的过程
         * 1.创建tcp客户端socket服务，使用的是Socket对象
         *      建议该对象一创建就明确目的地，要连接的主机
         * 2.如果连接建立成功，就说明数据传输通道（socket流，网络io流）已建立
         *      socket流是底层建立好的，说明这里既有输入也有输出
         *      想要输入或者输出流对象就找Socket来获取
         *      可以通过getOutputStream(),和getInputStream()来获取两个字节流
         * 3.使用输出流，将数据写出
         * 4.关闭资源
         */

        //创建客户端socket服务
        Socket socket = new Socket("192.168.31.57",10002);

        //获取socket流中的输出流
        OutputStream out = socket.getOutputStream();

        //使用输出流将指定的数据写出去
        out.write("tcp演示：哥们又来了！".getBytes());//因为是字节流，所以要得到字节进行输入

        //关闭资源
        socket.close();
    }
}
