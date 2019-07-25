package cn.itcast.p12.io.sequence.demo;

import java.io.*;
import java.util.*;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-24
 */
public class SequenceInputStreamDemo {
    public static void main(String[] args) throws IOException {

        /*
         * 需求：将1.txt  2.txt  3.txt文件中的数据合并到一个文件中
         *
         */

        //Vector效率太低，使用ArrayList
        /*Vector<FileInputStream> v = new Vector<FileInputStream>();

        v.add(new FileInputStream("1.txt"));
        v.add(new FileInputStream("2.txt"));
        v.add(new FileInputStream("3.txt"));*/

        ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
        for (int i = 1; i <= 3; i++) {
            al.add(new FileInputStream(i+".txt"));
        }

        Enumeration<FileInputStream>  en = Collections.enumeration(al);
        //返回一个指定 collection 上的枚举。此方法提供与遗留 API 的互操作性，遗留 API 需要一个枚举作为输入。
        //就相当于后面注释的那一块


        //ArrayList无法获取枚举类型 所以自己创建
        /*final Iterator<FileInputStream> it = al.iterator();//迭代器替换枚举
        Enumeration<FileInputStream> en = new Enumeration<FileInputStream>() {
            @Override
            public boolean hasMoreElements() {
                return it.hasNext();
            }

            @Override
            public FileInputStream nextElement() {
                return it.next();
            }
        };*/



//        Enumeration<FileInputStream> en = v.elements();

        //通过记住参数来初始化新创建的 SequenceInputStream，该参数必须是生成运行时类型为 InputStream 对象的 Enumeration 型参数。
        //输入必须是枚举类型
        SequenceInputStream sis = new SequenceInputStream(en);

        FileOutputStream fos = new FileOutputStream("4.txt");

        byte[] buf = new byte[1024];

        int len = 0;

        while ((len = sis.read(buf))!=-1){
            fos.write(buf,0,len);
        }

        fos.close();
    }
}
