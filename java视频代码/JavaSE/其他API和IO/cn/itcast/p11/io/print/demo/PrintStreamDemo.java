package cn.itcast.p11.io.print.demo;


import java.io.IOException;
import java.io.PrintStream;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-24
 */
public class PrintStreamDemo {
    public static void main(String[] args) throws IOException {

        /*
         * PrintStream:
         * 1.提供了打印方法可以对多种数据类型值进行打印，并保持数据的表示形式
         * 2.它不抛IOException
         *
         * 构造函数，接受三种类型的值：
         * 1.字符串路径
         * 2.File对象
         * 3.字节流输出
         */

        PrintStream out = new PrintStream("print.txt");

        /*int by = read();
        out.write(by);*/

        out.write(610);//只写最低八位0000-0000 0000-0000 0000-0010 0110-0001
        //只写了0110-0001 97 即b

//        out.write();//只写最低八位
//        out.print(97);//将97先变成字符保持原样将数据打印到目的地  原样！！
        out.close();
    }
}
