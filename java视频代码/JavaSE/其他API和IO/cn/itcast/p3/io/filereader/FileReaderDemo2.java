package cn.itcast.p3.io.filereader;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-21
 */
public class FileReaderDemo2 {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("demo.txt");//abcdehah

        /*
         * 使用read(char[])读取文本文件数据
         *
         * 先创建字符数组
         */

        char[] buf = new char[3];//new char[1024]最好的方式

        int len = 0;

        while((len=fr.read(buf))!=-1){
            System.out.println(new String(buf,0,len));
        }

        /*int num = fr.read(buf);//将读到的字符存储到数组中
        System.out.println(num + ":" + new String(buf));//3:abc

        int num1 = fr.read(buf);//将读到的字符存储到数组中
        System.out.println(num1 + ":" + new String(buf));//3:deh

        int num2 = fr.read(buf);//将读到的字符存储到数组中
        System.out.println(num2 + ":" + new String(buf));//2:ahh

        int num3 = fr.read(buf);//将读到的字符存储到数组中
        System.out.println(num3 + ":" + new String(buf));//-1:ahh*/

        fr.close();
    }
}
