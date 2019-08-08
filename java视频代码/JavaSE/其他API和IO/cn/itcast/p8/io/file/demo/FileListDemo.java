package cn.itcast.p8.io.file.demo;

import cn.itcast.p9.io.filter.FilterByHidden;
import cn.itcast.p9.io.filter.FilterByJava;
import cn.itcast.p9.io.filter.SuffixFilter;

import java.io.File;


/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-23
 */
public class FileListDemo {
    public static void main(String[] args) {
//        listDemo();
//        listDemo2();
        listDemo3();
    }

    public static void listDemo3() {
        File dir = new File("c:\\");
        File[] files = dir.listFiles(new FilterByHidden());//返回文件对象列表
        for (Object file : files) {
            System.out.println(file);
        }
    }

    public static void listDemo2() {
        File dir = new File("c:\\");

//        String[] names = dir.list(new FilterByJava());//加过滤器
        String[] names = dir.list(new SuffixFilter(".java"));//加过滤器

        for (String name : names) {
            System.out.println(name);
        }
    }

    public static void listDemo() {

        /*
         * 获取当前目录下的文件以及文件夹的名称，包含隐藏文件
         * 调用list方法的File对象中封装的必须是目录
         * 否则会发生NullPointerException
         * 如果访问的系统级目录也会发生空指针异常
         *
         * 如果目录存在但是没有内容，会返回一个数组，但是长度为0
         */
        File file = new File("c:\\");
        String[] names = file.list();
        for (Object name : names) {
            System.out.println(name);
        }
    }
}
