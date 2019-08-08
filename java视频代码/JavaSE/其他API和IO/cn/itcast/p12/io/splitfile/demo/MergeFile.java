package cn.itcast.p12.io.splitfile.demo;

import cn.itcast.p12.io.sequence.demo.SequenceInputStreamDemo;
import cn.itcast.p9.io.filter.SuffixFilter;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-24
 */
public class MergeFile {
    public static void main(String[] args) throws IOException {

        File dir = new File("F:\\partfiles");
//        mergeFile(dir);
        mergeFile_2(dir);
    }

    public static void mergeFile_2(File dir) throws IOException {

        /*
         * 获取指定目录下的配置文件对象
         */
        File[] files = dir.listFiles(new SuffixFilter(".properties"));//过滤出配置文件

        if (files.length != 1) {
            throw new RuntimeException(dir+",该目录下没有properties扩展名的文件或者不唯一");
        }

        //记录配置文件对象
        File confile = files[0];




        //获取该文件中的信息=========================================
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(confile);

        prop.load(fis);

        String filename = prop.getProperty("filename");

        int count = Integer.parseInt(prop.getProperty("partcount"));



        //获取该目录下的所有碎片文件=========================
        File[] partFiles = dir.listFiles(new SuffixFilter(".part"));

        if(partFiles.length!=(count-1)){
            throw new RuntimeException("碎片文件不符合要求，个数不对！，应该是"+count+"个");
        }


        //将碎片文件和流对象关联并存储到集合中
        ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
        for (int i = 0; i < partFiles.length; i++) {
            al.add(new FileInputStream(partFiles[i]));
        }



        //将多个流合并成序列流
        Enumeration<FileInputStream> en = Collections.enumeration(al);
        SequenceInputStream sis = new SequenceInputStream(en);

        FileOutputStream fos = new FileOutputStream(new File(dir,filename));

        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = sis.read(buf))!=-1){//read()里面的buf我没写！！！就有问题，一字节一字节的读。。
            fos.write(buf,0,len);
        }

        fos.close();
        sis.close();
    }




    public static void mergeFile(File dir) throws IOException {

        ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();

        for (int i = 1; i <=5 ; i++) {
            al.add(new FileInputStream(new File(dir,i+".part")));
        }

        Enumeration<FileInputStream> en = Collections.enumeration(al);
        SequenceInputStream sis = new SequenceInputStream(en);

        FileOutputStream fos = new FileOutputStream(new File(dir,"双笙.mp3"));

        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = sis.read(buf))!=-1){//read()里面的buf我没写！！！就有问题，一字节一字节的读。。
            fos.write(buf,0,len);
        }

        fos.close();
        sis.close();
    }
}
