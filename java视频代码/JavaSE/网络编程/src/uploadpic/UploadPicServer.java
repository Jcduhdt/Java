package uploadpic;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-27
 */
public class UploadPicServer {
    public static void main(String[] args) throws IOException {

        //创建tcp的socket服务端
        ServerSocket ss = new ServerSocket(10006);

        //为了让多个用户使用服务器进行上传，所以需要用多线程
        //而不是因为ss.accept的阻塞导致只有一个用户能使用这个服务器的端口
        while (true){
            Socket s = ss.accept();

            new Thread(new UploadTask(s)).start();
        }
//        ss.close();//因为无限循环
    }
}
