package uploadtext;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-26
 */
public class UploadServer {
    public static void main(String[] args) throws IOException {

        //1.
        ServerSocket ss = new ServerSocket(10005);

        //2
        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip+"..连接成功");

        //3
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

        //4
        BufferedWriter bufw = new BufferedWriter(new FileWriter("server.txt"));

        String line = null;


        while ((line=bufIn.readLine())!=null){

//            if (line.equals("over"))
//                break;
            bufw.write(line+"\r\n");//怎么才能不写这个\r\n进行换行
            bufw.flush();
        }

        PrintWriter out = new PrintWriter(s.getOutputStream(),true);
        out.println("上传成功");

        bufw.close();
        s.close();
        ss.close();
    }
}
