package cn.itcast.p7.io.bytestream.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-22
 */
public class ByteStreamDemo {
    public static void main(String[] args) throws IOException {
//        demo_write();
        demo_read();

    }

    public static void demo_read() throws IOException {

        //1.创建一个读取流对象。和指定文件关联
        FileInputStream fis = new FileInputStream("bytedemo.txt");

//        System.out.println(fis.available());//返回此输入流下一个方法调用可以不受阻塞地从此输入流读取（或跳过）的估计字节数。
        byte[] buf = new byte[fis.available()];//怕就怕关联了一个几个G的大文件
        fis.read(buf);
        System.out.println(new String(buf));


        //建议使用这种读取数据的方式
        /*byte[] buf = new byte[1024];
        int len = 0;

        while ((len = fis.read(buf))!=-1){
            System.out.println(new String(buf,0,len));
        }*/

        /*int ch = 0;
        while ((ch=fis.read())!=-1){
            System.out.println((char)ch);
        }*/

        //一次读取一个字节
//        int ch = fis.read();
//        System.out.println(ch);

        fis.close();
    }

    public static void demo_write() throws IOException {

        //1.创建字节输出流对象，用于操作文件
        FileOutputStream fos = new FileOutputStream("bytedemo.txt");

        //2.写数据,直接写入到了目的地中
        fos.write("abcdefg".getBytes());

//        fos.flush();//不用都可以，因为是直接写入的，不用flush都行
        fos.close();//关闭资源动作要完成
    }
}
