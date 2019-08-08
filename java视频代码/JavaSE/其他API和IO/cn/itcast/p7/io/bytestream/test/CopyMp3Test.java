package cn.itcast.p7.io.bytestream.test;

import java.io.*;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-22
 */
public class CopyMp3Test {
    public static void main(String[] args) throws IOException {
//        copy_1();
//        copy_2();//有两种方式，注释了一种
//        copy_3();//不建议
        copy_4();//千万不要用，效率没有

    }

    public static void copy_4() throws IOException {
        FileInputStream fis = new FileInputStream("F:\\我的一个道姑朋友.mp3");
        FileOutputStream fos = new FileOutputStream("F:\\双笙4.mp3");


        int ch = 0;

        //读一个字节写一个字节 超级慢
        while ((ch=fis.read())!=-1){
            fos.write(ch);
        }

        fos.close();
        fis.close();
    }

    public static void copy_3() throws IOException {
        FileInputStream fis = new FileInputStream("F:\\我的一个道姑朋友.mp3");
        FileOutputStream fos = new FileOutputStream("F:\\双笙3.mp3");


        byte[] buf = new byte[fis.available()];
        fis.read(buf);
        fos.write(buf);


        fos.close();
        fis.close();
    }

    public static void copy_2() throws IOException {
        FileInputStream fis = new FileInputStream("F:\\我的一个道姑朋友.mp3");
        BufferedInputStream bufis = new BufferedInputStream(fis);

        FileOutputStream fos = new FileOutputStream("F:\\双笙2.mp3");
        BufferedOutputStream bufos = new BufferedOutputStream(fos);

        /*byte[] buf = new byte[1024];

        int len = 0;

        while ((len=bufis.read(buf))!=-1){
            bufos.write(buf,0,len);
            bufos.flush();
        }*/

        int ch = 0;
        while ((ch=bufis.read())!=-1){
            bufos.write(ch);
        }

        fos.close();
        fis.close();
    }

    public static void copy_1() throws IOException {
        FileInputStream fis = new FileInputStream("F:\\我的一个道姑朋友.mp3");
        FileOutputStream fos = new FileOutputStream("F:\\双笙1.mp3");


        byte[] buf = new byte[1024];

        int len = 0;

        while ((len=fis.read(buf))!=-1){
            fos.write(buf,0,len);
        }

        fos.close();
        fis.close();
    }
}
