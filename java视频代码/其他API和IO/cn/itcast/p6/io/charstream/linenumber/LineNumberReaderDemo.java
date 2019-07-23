package cn.itcast.p6.io.charstream.linenumber;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-22
 */
public class LineNumberReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("IO流_1.txt");
        LineNumberReader lnr = new LineNumberReader(fr);

        String line = null;
        while((line = lnr.readLine())!=null){
            System.out.println(lnr.getLineNumber()+":"+line);
        }

        lnr.close();
    }
}
