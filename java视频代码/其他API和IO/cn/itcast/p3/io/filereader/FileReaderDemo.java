package cn.itcast.p3.io.filereader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-21
 */
public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        //1.创建读取字符数据的流对象
        /*
         * 在创建读取流对象时，必须要明确被读取的文件，一定要确定该文件是存在的
         *
         * 用一个读取流关联一个已存在文件
         */
        FileReader fr = new FileReader("demo.txt");

        int ch = 0;

        //读到最后返回-1
        while((ch=fr.read())!=-1){
            System.out.println((char)ch);
        }
        //用Reader中的read方法读取字符
        //从此文件中读取一个数据字节。以整数形式返回此字节，范围在 0 到 255 ( 0x00-0x0ff)。如果尚无输入可用，将阻塞此方法。
        //返回下一个数据字节，如果已到达文件的末尾，则返回 -1
        /*int ch = fr.read();
        System.out.println((char)ch);//a
        System.out.println(ch);//97

        int ch1 = fr.read();
        System.out.println((char)ch1);//b
        System.out.println(ch1);//98*/

        fr.close();
    }
}
