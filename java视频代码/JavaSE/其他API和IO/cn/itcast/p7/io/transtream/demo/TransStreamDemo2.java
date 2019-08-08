package cn.itcast.p7.io.transtream.demo;

import java.io.*;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-22
 */
public class TransStreamDemo2 {

    public static void main(String[] args) throws IOException {

        /*
         * 1.需求：将键盘录入的数据写入到一个文件中
         *
         * 2.需求：将一个文本文件内容显示在控制台上
         *
         * 3.需求：将一个文本文件中的内容复制到另一个文件中
         */


        BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("a.txt")));

        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("b.txt")));

        String line = null;
        while ((line = bufr.readLine())!=null){
            if ("over".equals(line))
                break;
//            System.out.println(line.toUpperCase());
            bufw.write(line.toUpperCase());//将字符数据用缓冲区对象将数据写入缓冲区，目的地是osw
            bufw.newLine();
            bufw.flush();
        }

        bufr.readLine();
    }
}
