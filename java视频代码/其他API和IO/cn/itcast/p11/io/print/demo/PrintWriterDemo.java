package cn.itcast.p11.io.print.demo;

import com.sun.source.tree.WhileLoopTree;

import java.io.*;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-24
 */
public class PrintWriterDemo {
    public static void main(String[] args) throws IOException {

        /*
         * PrintWriter：字符打印流
         * 构造函数参数：
         * 1.字符串路径
         * 2.File对象
         * 3.字节输出流
         * 4.字符输出流
         *
         */

        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter out = new PrintWriter(new FileWriter("out.txt"), true);//自动刷新

        String line = null;
        while ((line=bufr.readLine())!=null){
            if ("over".equals(line))
                break;
            out.println(line.toUpperCase());
//            out.flush();//刷新才能在输入后打印到控制台，而不用等到close才出来，前面有自动刷新就不用这个了
        }

        out.close();
        bufr.close();
    }
}
