package cn.itcast.p4.io.charstream.buffer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-21
 */
public class BufferedWriteDemo {

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("buf.txt");

        //为了提高写入效率。使用了字符流的缓冲区
        //创建了一个字符写入流的缓冲区对象，并和指定要被缓冲的流对象相关联
        BufferedWriter bufw = new BufferedWriter(fw);

        //使用缓冲区的写入方法将数据先写入到缓冲区中
//        bufw.write("abcdef"+LINE_SEPARATOR+"hahaha");
//        bufw.write("xixixixixi");
//        bufw.newLine();
//        bufw.write("hehehehehhe");

        for (int i = 0; i < 4; i++) {
            bufw.write("abcdef" + i);
            bufw.newLine();
            bufw.flush();
        }





        //使用缓冲区的刷新方法将数据刷到目的地中
//        bufw.flush();

        //关闭缓冲区  其实关闭的是被缓冲的流对象
        bufw.close();
//        fw.write("hehe");//java.io.IOException: Stream closed

//        fw.close();
    }
}
