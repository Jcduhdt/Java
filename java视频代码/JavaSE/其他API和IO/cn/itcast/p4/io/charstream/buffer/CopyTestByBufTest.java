package cn.itcast.p4.io.charstream.buffer;

import java.io.*;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-21
 */
public class CopyTestByBufTest {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("buf.txt");
        BufferedReader bufr = new BufferedReader(fr);

        FileWriter fw = new FileWriter("buf_copy.txt");
        BufferedWriter bufw = new BufferedWriter(fw);

        String line = null;
        while ((line=bufr.readLine())!=null){
            bufw.write(line);
            bufw.newLine();
            bufw.flush();
        }


        /*int ch = 0;

        while ((ch=bufr.read())!=-1){
            bufw.write(ch);
        }
*/
        bufw.close();
        bufr.close();
    }
}
