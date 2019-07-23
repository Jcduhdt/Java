package cn.itcast.p7.io.transtream.demo;

import java.io.*;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-22
 */
public class TransStreamDemo {

    public static void main(String[] args) throws IOException {

        //字节流
        InputStream in = System.in;
        /*int ch = in.read();
        System.out.println(ch);
        int ch1 = in.read();
        System.out.println(ch1);*/
        //将字节转成字符的桥梁，转换流  因为字节读中文输入的话就要读两次
        InputStreamReader isr = new InputStreamReader(in);

        /*int ch = isr.read();
        System.out.println((char)ch);*/
        //字符流
        BufferedReader bufr = new BufferedReader(isr);//对字符流进行高效装饰

        OutputStream out = System.out;

        OutputStreamWriter osw = new OutputStreamWriter(out);

        BufferedWriter bufw = new BufferedWriter(osw);

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
