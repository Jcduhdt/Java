package cn.itcast.p10.io.test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-24
 */

/*
 * 过去指定目录下，指定扩展名的文件（包含子目录中的）
 * 这些文件的绝对路径写入到一个文本文件中
 *
 * 简单说，就是建立一个指定扩展名的文件的列表
 *
 * 思路：
 * 1.必须进行深度遍历
 * 2.要在遍历过程中进行过滤，将符合条件的内容都存储到容器中
 * 3.对容器中的内容进行遍历并将绝对路径写入到文件中
 */
public class Test {
    public static void main(String[] args) {

        File dir = new File("D:\\Java\\JavaProject\\泛型");

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        };

        List<File> list = new ArrayList<File>();

        getFiles(dir,filter,list);

        File destFile = new File("javalist.txt");
        write2File(list,destFile);
    }

    public static void write2File(List<File> list,File destFile) {
        BufferedWriter bufw = null;
        try {
            bufw = new BufferedWriter(new FileWriter(destFile));
            for (File file : list) {
                bufw.write(file.getAbsolutePath());
                bufw.newLine();
                bufw.flush();
            }
        }catch (IOException e) {
            throw new RuntimeException("写入失败");
        }finally {
            if (bufw!=null)
                try {
                    bufw.close();
                } catch (IOException e) {
                    throw new RuntimeException("关闭失败");
                }
        }
    }

    /**
     * 对指定目录中的内容进行深度遍历，并按照制定的过滤器进行过滤
     * 将过滤后的内容存储到指定容器List中
     * @param dir
     * @param filter
     * @param list
     */
    public static void getFiles(File dir, FilenameFilter filter, List<File> list) {

        File[] files = dir.listFiles();

        for (File file : files) {
            if (file.isDirectory()){
                //递归啦
                getFiles(file,filter,list);
            }else{
                //对遍历到的文件进行过滤器的过滤。将符合条件的File对象，存储到List集合中
                if (filter.accept(dir,file.getName())){
                    list.add(file);
                }
            }
        }
    }
}
