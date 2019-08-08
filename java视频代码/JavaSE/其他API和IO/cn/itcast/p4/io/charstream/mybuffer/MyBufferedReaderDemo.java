package cn.itcast.p4.io.charstream.mybuffer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-21
 */
public class MyBufferedReaderDemo {

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("buf.txt");

        MyBufferedReader bufr = new MyBufferedReader(fr);

        String line = null;

        while ((line=bufr.myReadLine())!=null){
            System.out.println(line);
        }

        bufr.myClose();
    }
}
