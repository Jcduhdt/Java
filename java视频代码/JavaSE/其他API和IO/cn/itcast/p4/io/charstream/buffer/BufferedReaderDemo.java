package cn.itcast.p4.io.charstream.buffer;

import java.io.*;


/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-21
 */
public class BufferedReaderDemo {

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("buf.txt");

        BufferedReader bufr = new BufferedReader(fr);

        String line = null;

        while ((line=bufr.readLine())!=null){
            System.out.println(line);
        }
        /*String line1 = bufr.readLine();//读一行
        System.out.println(line1);

        String line2 = bufr.readLine();
        System.out.println(line2);

        String line3 = bufr.readLine();
        System.out.println(line3);

        String line4 = bufr.readLine();
        System.out.println(line4);

        String line5 = bufr.readLine();
        System.out.println(line5);*/

        bufr.close();
//        demo();


    }

    public static void demo() throws IOException {
        FileReader fr = new FileReader("buf.txt");

        char[] buf = new char[1024];

        int len = 0;
        while ((len = fr.read(buf))!=-1){
            System.out.println(new String(buf,0,len));
        }
        fr.close();
    }
}
