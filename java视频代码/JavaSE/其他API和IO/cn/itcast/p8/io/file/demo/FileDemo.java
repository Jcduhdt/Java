package cn.itcast.p8.io.file.demo;

import java.io.File;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-23
 */
public class FileDemo {
    public static void main(String[] args) {
        constructorDemo();
    }

    public static void constructorDemo() {

        //可以将一个已存在的，或者不存在的文件或者目录封装成file对象
        File f1 = new File("c:\\1.txt");

        File f2 = new File("c:\\","a.txt");

        File f = new File("c:\\");

        File f3 = new File(f,"a.txt");

        File f4 = new File("c:"+System.getProperty("file.separator")+"abc"+File.separator+"a.txt");
        //File.separator == System.getProperty("file.separator")
        // 是系统的路径的分隔符  不同系统的分隔符不同 所以这种方式那个平台都能用
        System.out.println(f4);


    }
}
