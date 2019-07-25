package cn.itcast.p13.io.randomfile;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-25
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {

        /*
         * RandomAccessFile
         * 一看这名字，纠结，不是io体系中的子类
         *
         * 特点：
         * 1.该对象既能读，又能写
         * 2.该对象内部维护了一个Byte数组，并通过指针可以操作数组中的元素
         * 3.可以通过getFilePointer方法获取指针的位置，和通过seek方法设置指针的位置
         * 4.其实该对象就是把字节输入流和字节输出流封装了起来
         * 5.该对象的源或者目的只能是文件，通过构造函数就可以看出
         *
         * 用多线程来并行写入
         *
         */

//        writeFile();


        //我的读取有问题，年龄是一长串数字，不是我设置的
        //姓名显示也有问题，不知道是不是编码问题还是什么
        //我看指针位置也正常啊
//        readFile();

        randomWrite();
    }

    public static void randomWrite() throws IOException {

        RandomAccessFile raf = new RandomAccessFile("ranacc.txt","rw");

        //往指定位置写数据
        raf.seek(3*8);

        raf.write("狗子".getBytes());
        raf.writeInt(108);

        raf.close();
    }

    public static void readFile() throws IOException {


        RandomAccessFile raf = new RandomAccessFile("ranacc.txt","r");

        //通过seek设置指针的位置
        raf.seek(1*8);//随机的读取。只要指定指针的位置即可

        byte[] buf = new byte[4];
        raf.read(buf);
        
        String name = new String(buf);

        int age = raf.readInt();//从此文件读取一个有符号的 32 位整数。此方法从该文件的当前文件指针开始读取 4 个字节。
        //此文件的下四个字节，解释为一个 int。

        System.out.println("name = " + name);
        System.out.println("age = " + age);

        System.out.println("pos:" + raf.getFilePointer());
        raf.close();
    }


    //使用RandomAccessFile对象写入一些人员信息，比如姓名和年龄
    public static void writeFile() throws IOException {
        
        /*
         * 如果文件不存在则创建，如果文件存在，不创建
         */
        RandomAccessFile raf = new RandomAccessFile("ranacc.txt","rw");//mode只能是r/rw/rws/rwd四选一

        raf.write("张三".getBytes());
//        raf.write(609);//会只保留第八位  就会显示a即97
        raf.writeInt(97);//按四个字节将 int 写入该文件，先写高字节。写入从文件指针的当前位置开始

        raf.write("小强".getBytes());
        raf.writeInt(99);//按四个字节将 int 写入该文件，先写高字节。写入从文件指针的当前位置开始


        raf.close();
    }

}
