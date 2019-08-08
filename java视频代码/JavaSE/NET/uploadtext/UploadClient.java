package uploadtext;

import java.io.*;
import java.net.Socket;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-26
 */
public class UploadClient {
    public static void main(String[] args) throws IOException {

        //1.
        Socket s = new Socket("192.168.31.57",10005);

        //2.
        BufferedReader bufr = new BufferedReader(new FileReader("client.txt"));

        //3
        PrintWriter out = new PrintWriter(s.getOutputStream(),true);

        String line = null;
        while ((line = bufr.readLine())!=null){
            out.println(line);
        }
//        告诉服务端，客户端写完了
        s.shutdownOutput();
//        out.println("over");

        //4.
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String str = bufIn.readLine();
        System.out.println(str);

        bufr.close();//因为在读文件，就要关流
        s.close();
    }
}
