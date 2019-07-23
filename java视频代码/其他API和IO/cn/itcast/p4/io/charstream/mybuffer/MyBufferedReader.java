package cn.itcast.p4.io.charstream.mybuffer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-22
 */

/*
 * 自定义的读取缓冲区，其实就是模拟一个BufferedReader
 *
 * 分析：
 * 缓冲区中无非就是封装了一个数组
 * 并对外提供了更多的方法对数组进行访问
 * 其实这些方法最终操作的都是素组的角标
 *
 * 缓冲原理：
 * 其实就是从源中获取一批数据装进缓冲区中
 * 再从缓冲区中不断的取出一个一个数据
 *
 * 但此次取完后,再从源中继续取一批数据进缓冲区
 * 当源中的数据取光时，用-1作返回标记
 */
public class MyBufferedReader {

    private FileReader r;

    //定义一个数组作为缓冲区
    private char[] buf = new char[1024];
    //定义一个指针用于操作这个数组中的元素，当操作到最后一个元素后，指针应该归零
    private int pos = 0;

    //定义一个计数器用于记录缓冲区中的数据个数，当该数据减到0，就从源中继续获取数据到缓冲区中
    private int count = 0;


    MyBufferedReader(FileReader r){
        this.r = r;
    }

    /**
     * 该方法从缓冲区中一次取一个字符
     * @return
     * @throws IOException
     */
    public int myRead() throws IOException {

        //1.从源中获取一批数据到缓冲区中,需要先做判断，只有计数器为0时才需要从源中获取数据

        if (count == 0){
            count = r.read(buf);//读字符进入buf数组
            //返回读取的字符数，如果已到达流的末尾，则返回 -1
            pos = 0;
        }
        if (count<0)
            return -1;

        char ch = buf[pos++];

        count--;

        return ch;
        /*if (count == 0) {
            count = r.read(buf);

            if (count<0)
                return -1;

            //每次获取数据到缓冲区后，角标归零
            pos = 0;
            char ch = buf[pos];

            pos++;
            count--;

            return ch;
        }else if(count>0){
            char ch = buf[pos];

            pos++;
            count--;

            return ch;
        }*/
    }

    public String myReadLine() throws IOException {
        StringBuilder sb = new StringBuilder();

        int ch = 0;
        while ((ch = myRead())!=-1){

            if (ch == '\r')//读到\r继续，我还不太懂这个\r和\n的区别。。。
                continue;
            if (ch == '\n')//读到回车，返回字符串
                return sb.toString();
            //将从缓冲区中读到的字符，存储到缓存行数据的缓冲区中
            sb.append((char)ch);
        }

        if (sb.length()!=0){
            return sb.toString();//因为有可能就是文本中最后一行是没回车的，那么while循环中最后一行就在缓存里没被返回
        }

        return null;
    }

    public void myClose() throws IOException {
        r.close();
    }
}
