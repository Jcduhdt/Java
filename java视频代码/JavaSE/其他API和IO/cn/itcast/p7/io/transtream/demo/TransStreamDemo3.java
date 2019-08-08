package cn.itcast.p7.io.transtream.demo;

import java.io.*;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-23
 */

//果然，我设置了全局utf-8 所以要查看不同的话，应该把charset设置为其他码表，eg：GBK

public class TransStreamDemo3 {

    public static void main(String[] args) throws IOException {
//        writeText();
        writeText_2();
//        writeText_3();
        readText();
    }

    public static void readText() throws IOException {
        FileReader fr = new FileReader("gbk_1.txt");

        char[] buf = new char[10];
        int len = fr.read(buf);
        String str = new String(buf,0,len);
        System.out.println(str);
        fr.close();

    }

    public static void writeText_3() throws IOException {
        //emmm 我似乎在IDEA设置了全局utf-8
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("u8_2.txt"),"UTF-8");
        osw.write("你好");
        osw.close();
    }

    public static void writeText_2() throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("gbk_1.txt"),"GBK");
        /*
         * 这两句代码的功能其实是等同的
         * FileWriter:其实就是转换流指定了本机默认码表的体现，而且这个转换流的子类对象，可以方便操作文本文件
         *            简单说：操作文件的字节流+本机默认编码表
         *            这是按照默认码表来操作文件的便捷类
         *
         * 如果操作文本文件需要明确具体的编码，FileWriter就不行了，必须用转换流
         */

        osw.write("你好");
        osw.close();
    }

    public static void writeText() throws IOException {
        FileWriter fw = new FileWriter("u8_1.txt");
        fw.write("你好");
        fw.close();
    }
}
