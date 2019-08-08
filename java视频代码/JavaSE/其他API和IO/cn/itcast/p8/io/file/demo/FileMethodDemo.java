package cn.itcast.p8.io.file.demo;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-23
 */
public class FileMethodDemo {
    public static void main(String[] args) throws IOException {

        /*
         * File对象的常见方法
         *
         * 1.获取
         *      1.1获取文件名称
         *      1.2获取文件路径
         *      1.3获取文件大小
         *      1.4获取文件修改时间
         *
         * 2.创建与删除
         *      boolean
         * 
         * 3.判断
         *
         * 4.重命名
         */
//        getDemo();
//        creatAndDelete();
//        isDemo();
//        renameToDemo();
        listRootsDemo();
    }

    public static void listRootsDemo() {

        File file = new File("d:\\");

        System.out.println("getFreeSpace:" + file.getFreeSpace());//返回此抽象路径名指定的分区中未分配的字节数。
        System.out.println("getTotalSpace:" + file.getTotalSpace());//返回此抽象路径名指定的分区大小。
        System.out.println("getUsableSpace:" + file.getUsableSpace());//返回此抽象路径名指定的分区上可用于此虚拟机的字节数。


        /*File[] files = File.listRoots();

        for (File file : files) {
            System.out.println(file);
            //列这个电脑的盘符
            C:\
            D:\
            E:\
            F:\
        }*/
    }

    public static void renameToDemo() {

        //相当于剪切，这操作可以同时重命名和移动
        File f1 = new File("F://我的一个道姑朋友.mp3");
        File f2 = new File("D://happy.mp3");
        
        boolean b = f1.renameTo(f2);
        System.out.println("b = " + b);
    }

    public static void isDemo() throws IOException {
        File f = new File("a.txt");
        f.mkdir();//可以创建一个a.txt的文件夹
        f.createNewFile();

//        boolean b = f.exists();
//        System.out.println("b = " + b);

        //最好先判断是否存在，再判断是文件还是目录
        System.out.println(f.isFile());
        System.out.println(f.isDirectory());
    }


    public static void creatAndDelete() throws IOException {
        
//        File dir = new File("abc");
//        boolean b = dir.mkdir();//make directory
//        System.out.println("b = " + b);
//        System.out.println(dir.delete());//windows的内容从里面往外删，文件夹里面有内容是删不掉的

        File dir = new File("absd//ada//rte//w//f//h//e//v//sad/rwe");
        boolean b = dir.mkdirs();//创建多级目录

        System.out.println(dir.delete());//删的是最里面的rwe文件夹，因为从里面往外删
        
        /*//文件的创建与删除
        File file = new File("file.txt");

        *//*
         * 和输出流不一样，如果文件不存在，则创建，如果存在，则不创建
         *//*
//        boolean b = file.createNewFile();
//        System.out.println("b = " + b);
        
//        boolean b = file.delete();
//        System.out.println("b = " + b);*/
    }

    public static void getDemo()
    {
        File file = new File("a.txt");

        String name = file.getName();
        String abspath = file.getAbsolutePath();//绝对路径  打头有盘符
        String path = file.getPath();
        long len = file.length();
        long time = file.lastModified();
        Date date = new Date(time);
        DateFormat dateformat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
        String str_time = dateformat.format(date);
        String parent = file.getParent();//绝对路径下


        System.out.println("name = " + name);
        System.out.println("abspath = " + abspath);
        System.out.println("path = " + path);
        System.out.println("len = " + len);
        System.out.println("time = " + time);
        System.out.println("str_time = " + str_time);
        System.out.println("parent = " + parent);


    }
}
