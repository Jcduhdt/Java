package cn.itcast.p12.io.splitfile.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-24
 */

/*
 * 文件切割器
 */
public class SplitFileDemo  {
    private static final int SIZE = 1024*1024;

    public static void main(String[] args) throws IOException {
        File file = new File("F:\\shuangsheng.mp3");
//        splitFile(file);
        splitFile_2(file);
    }

    public static void splitFile_2(File file) throws IOException {
        //用读取流关联文件
        FileInputStream fis = new FileInputStream(file);

        //定义一个1M的缓冲区
        byte[] buf = new byte[SIZE];

        //创建目的
        FileOutputStream fos = null;


        /*
         * 切割文件时，必须记录住被切割文件的名称，以及切割出来碎片文件的个数。以方便于合并
         * 这个信息为了进行描述，使用键值对的方式。用到了properties对象
         */

        Properties prop = new Properties();

        int len = 0;
        int count = 1;

        File dir = new File("F:\\partfiles");//也可以用户传入目的文件
        if (!dir.exists())
            dir.mkdirs();//创建文件夹是mkdir
        //创建文件，是dir.createNewFile() 快被自己气死了

        while ((len = fis.read(buf))!=-1){
            fos = new FileOutputStream(new File(dir,(count++)+".part"));//碎片文件的扩展名，最好定义一个好一点的扩展名，好找
            fos.write(buf,0,len);
            fos.close();
        }

        //将被切割文件的信息保存到prop集合中
        prop.setProperty("partcount",count+"");
        prop.setProperty("filename",file.getName());

        fos = new FileOutputStream(new File(dir,count+".properties"));

        //将prop集合中的数据存储到文件中
        prop.store(fos,"save file info");

        fos.close();
        fis.close();
    }

    public static void splitFile(File file) throws IOException {

        //用读取流关联文件
        FileInputStream fis = new FileInputStream(file);

        //定义一个1M的缓冲区
        byte[] buf = new byte[SIZE];

        //创建目的
        FileOutputStream fos = null;

        int len = 0;
        int count = 1;

        File dir = new File("F:\\partfiles");//也可以用户传入目的文件
        if (!dir.exists())
            dir.mkdirs();//创建文件夹是mkdir
        //创建文件，是dir.createNewFile() 快被自己气死了

        while ((len = fis.read(buf))!=-1){
            fos = new FileOutputStream(new File(dir,(count++)+".part"));//碎片文件的扩展名，最好定义一个好一点的扩展名，好找
            fos.write(buf,0,len);
        }

        fos.close();
        fis.close();
    }
}
