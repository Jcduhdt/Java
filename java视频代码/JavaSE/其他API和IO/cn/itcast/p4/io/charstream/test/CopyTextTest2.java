package cn.itcast.p4.io.charstream.test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-21
 */

/*
 * 需求：作业：将c盘的一个文本文件复制到d盘
 *
 * 思路：
 * 1.需要读取源
 * 2.将读到的源数据写入到目的地
 * 3.既然是操作文本数据，使用字符流
 */
public class CopyTextTest2 {
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {

        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("IO流_1.txt");//这个文本应该是在project目录下
            fw = new FileWriter("copytext_2.txt");

            //创建一个临时容器，用于缓存读取到的字符
            char[] buf = new char[BUFFER_SIZE];//这就是缓冲区

            //定义一个变量记录读取到的字符数，其实就是往数组里装的字符个数
            int len = 0;

            while ((len = fr.read(buf))!=-1){
                fw.write(buf,0,len);
            }
        } catch (Exception e) {
//            System.out.println("读写失败");
            throw new RuntimeException("读写失败");
        }finally {
            if (fw!=null)
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (fr!=null)
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        fw.close();
        fr.close();
    }
}
