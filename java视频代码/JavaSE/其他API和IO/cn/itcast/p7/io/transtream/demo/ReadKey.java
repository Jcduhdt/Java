package cn.itcast.p7.io.transtream.demo;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-22
 */

/*
 * 读取一个键盘录入的数据，并打印在控制台上
 *
 * 键盘本身就是一个标准的输入设备
 * 对于java而言，对于这种输入设备都有对应的对象
 */
public class ReadKey {
    public static void main(String[] args) throws IOException {
//        readKey();
//        System.out.println((int)'\r');//13
//        System.out.println((int)'\n');//12

        readKey2();
    }

    public static void readKey2() throws IOException {

        /*
         * 获取用户键盘录入的数据
         * 并将数据变成大写显示在控制台上
         * 如果用户输入的是over，结束键盘录入
         *
         *
         * 思路：
         * 1.因为键盘录入只读取一个字节，要判断是否是over，需要先将读取到的字节拼成字符串
         * 2.那就需要一个容器，StringBuilder
         * 3.在用户回车之前将录入的数据变成字符串判断即可
         */

        //1.创建容器
        StringBuilder sb = new StringBuilder();

        //获取键盘读取流
        InputStream in = System.in;

        //定义变量记录读取到的字节，并循环获取
        int ch = 0;
        while((ch=in.read())!=-1){
            //存储之前需要进行判断是否是换行标记，因为换行标记不存储
            if (ch=='\r')
                continue;
            if (ch=='\n') {
                String temp = sb.toString();
                if ("over".equals(temp))
                    break;
                System.out.println(temp.toUpperCase());
                sb.delete(0,sb.length());
            }else
            //将读取的自己存储到StringBuilder中
            sb.append((char)ch);
//            System.out.println(ch);
        }
    }

    public static void readKey() throws IOException {
        InputStream in = System.in;

        int ch = in.read();//阻塞式方法，没数据就一直等
        System.out.println(ch);

        int ch1 = in.read();//阻塞式方法，没数据就一直等
        System.out.println(ch1);

        int ch2 = in.read();//阻塞式方法，没数据就一直等
        System.out.println(ch2);

        /*in.close();//一般不关，系统的流一般随着系统的开而开，关而关
        //一旦关闭，就只能重启系统来打开

        InputStream in2 = System.in;
        int ch3 = in2.read();*/


    }
}
